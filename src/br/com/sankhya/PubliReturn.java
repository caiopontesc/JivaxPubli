package br.com.sankhya;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sankhya.common.Utils;
import br.com.sankhya.infrastructure.JdbcOracleConnection;
import br.com.sankhya.service.InvoicedOrder;
import br.com.sankhya.service.PubliAmplaServiceHelper;
import br.com.sankhya.service.PubliBg9ALServiceHelper;
import br.com.sankhya.service.PubliBg9PEServiceHelper;

public class PubliReturn {

	private static final boolean producao = true;
	private static String cookieAmpla;
	private static String cookieBg9PE;
	private static String cookieBg9AL;
	
	private static String getURLEnviroment(String url) {
		return producao ? url : url.replace("//apiduca.", "//homologaapiduca.");
	}

	public static void main(String[] args) throws SQLException {
		cookieAmpla = new PubliAmplaServiceHelper().getPublicookie();
		//cookieBg9PE = new PubliBg9PEServiceHelper().getPublicookie();
		//cookieBg9AL = new PubliBg9ALServiceHelper().getPublicookie();

		System.out.println("Iniciando o processo de atualização de Status no Publi.");

		ArrayList<InvoicedOrder> list = new ArrayList<InvoicedOrder>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		String query = "SELECT DISTINCT "
				+ "CAB.NUMNFSE AS FATURA,"
				+ "CAB.NUNOTA AS NUNOTA, "
				+ "CAB.CODTIPOPER AS TOP, "
				+ "TO_CHAR(CAB.DTFATUR, 'YYYY-MM-DD') AS DTSITUACAO, "
				+ "CASE WHEN CAB.CODEMP IN (2,3,6) THEN 'Ampla' WHEN CAB.CODEMP = 4 THEN 'BG9 PE' WHEN CAB.CODEMP = 5 THEN 'BG9 AL' ELSE '' END EMPRESA, "
				+ "CASE WHEN EXISTS (SELECT 1 FROM TGFCAN CAN, TGFCAB_EXC EXC WHERE CAN.NUNOTA = EXC.NUNOTA AND EXC.TIPMOV IN ('V') AND CAN.NUNOTA = CAB.NUNOTA) THEN 'CANCELADA' ELSE 'FATURADA' END STATUS "
				+ "FROM TGFCAB CAB "
				+ "INNER JOIN TGFITE ITE ON (ITE.NUNOTA = CAB.NUNOTA) "
				+ "WHERE (TRUNC(CAB.DTFATUR) BETWEEN ? AND ?) AND CAB.TIPMOV = ? AND CAB.AD_PUBLI IS NULL AND CAB.AD_PIXOC IS NOT NULL";
//				+ "  and cab.nunota = 43722";
		
		try {

			conn = JdbcOracleConnection.getDBConnection();

			pstmt = conn.prepareStatement(query);

			//System.out.println();
			pstmt.setDate(1, new java.sql.Date(Utils.GetInvoicedOrderIntervalDateDDMMYYYY().getTime()));
			pstmt.setDate(2, new java.sql.Date(Utils.GetDateTimeNowDDMMYYY().getTime()));
			pstmt.setString(3, "V");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				InvoicedOrder order = new InvoicedOrder();

//				order.setDocType(rs.getString("TIPODOC"));

//				if (order.getDocType().equals("OC")) {
//					order.setDocNumber(Integer.toString(rs.getInt("DOCUMENTO")));
//				} else {
//					order.setDocNumber(Integer.toString(rs.getInt("PIXOC")));
//				}

				order.setEmpresa(rs.getString("EMPRESA"));
				order.setDtSituation(rs.getString("DTSITUACAO"));
				order.setInvoiceNumber(Integer.toString(rs.getInt("FATURA")));
				order.setInvoiceType("");
				order.setTOP(rs.getString("TOP"));

				if (order.getTOP().equals("706")) {
					order.setFlagSituation("O");
				} else {
					order.setFlagSituation("F");
				}
				
				if ("CANCELADA".equals(rs.getString("STATUS"))) {
					order.setFlagSituation("L");
					order.setInvoiceNumber("");
					order.setDtSituation("");
				}

				order.setNUNOTA(Integer.toString(rs.getInt("NUNOTA")));

				list.add(order);

			}

			System.out.println("\n\nForam encontrados " + list.size() + " registro(s).");

			for (InvoicedOrder item : list) {
				List<InvoicedOrder> documentosRelacionados = getDocumentosRelacionados(item.getNUNOTA());
				
				// atualiza status dos documentos relacionados
				for (InvoicedOrder docRelacionado : documentosRelacionados) {
					item.setEmpresa(docRelacionado.getEmpresa());
					item.setDocType(docRelacionado.getDocType());
					item.setDocNumber(docRelacionado.getNUNOTA());
					
					// atualiza OC/PI
					setInvoicedStateOnPubli(item);
					
					// atualiza PP
					if (docRelacionado.getDocType().equals("OC")) {
						int codPP = getCodPP(docRelacionado.getNUNOTA());
						if (codPP > 0) {
							item.setDocNumber(String.valueOf(codPP));
							item.setDocType("PP");
							setInvoicedStateOnPubli(item);
						}
					}
				}
			}
			
			updateAD_PUBLI(list);

			System.out.println("\n\nAtualização de Status do Publi finalizado.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n\n" + e.getMessage());

		} finally {

			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}

	private static int getCodPP(String nuNota) throws SQLException {
		int codPP = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = JdbcOracleConnection.getDBConnection();

			String query = "SELECT REPLACE(REGEXP_SUBSTR(ITE.observacao, 'PP: ([0-9]+)'), 'PP: ', '') AS NUM_PP "
							+ "FROM TGFITE ITE "
							+ "INNER JOIN TGFCAB CAB ON CAB.NUNOTA = ITE.NUNOTA "
							+ "WHERE NUMNOTA = ? AND REGEXP_SUBSTR(ITE.observacao, 'PP: ([0-9]+)') IS NOT NULL";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(nuNota));
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				codPP = rs.getInt("NUM_PP");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		}
		
		return codPP;
	}

	private static List<InvoicedOrder> getDocumentosRelacionados(String nunota) throws SQLException {
		List<InvoicedOrder> documentosRelacionados = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = JdbcOracleConnection.getDBConnection();
			
			String query = "SELECT DISTINCT " + 
				  " CASE WHEN CAB.AD_PIXOC IS NOT NULL THEN CAB.AD_PIXOC ELSE CAB.NUMNOTA END NUMNOTA," + 
	              " CASE WHEN ITE.CODPROD IN (661, 662, 671, 674, 675) THEN 'PI' ELSE 'OC' END AS TIPODOC," + 
	              " CASE WHEN CAB.CODEMP IN (2,3,6) THEN 'Ampla' WHEN CAB.CODEMP = 4 THEN 'BG9 PE' WHEN CAB.CODEMP = 5 THEN 'BG9 AL' ELSE '' END EMPRESA" + 
	              " FROM TGFVAR VAR" + 
	              " JOIN TGFITE ITE ON ITE.SEQUENCIA = VAR.SEQUENCIAORIG AND ITE.NUNOTA = VAR.NUNOTAORIG" + 
	              " JOIN TGFCAB CAB ON CAB.NUNOTA = ITE.NUNOTA" + 
	              " WHERE VAR.NUNOTA = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(nunota));
			
			ResultSet rs = pstmt.executeQuery();

			InvoicedOrder docRelacionado;
			while (rs.next()) {
				docRelacionado = new InvoicedOrder();
				docRelacionado.setNUNOTA(String.valueOf(rs.getInt("NUMNOTA")));
				docRelacionado.setDocType(rs.getString("TIPODOC"));
				docRelacionado.setEmpresa(rs.getString("EMPRESA"));
				
				documentosRelacionados.add(docRelacionado);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("\n\n" + e.getMessage());
			
		} finally {
			
			if (pstmt != null) {
				pstmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		}
		
		return documentosRelacionados;
	}

	public static void setInvoicedStateOnPubli(InvoicedOrder order) {

		try {

			String obj = "";
			System.out.println("\n");
			
			String publiCookie = buildCookie(order.getEmpresa());
			
			URL url = new URL(getURLEnviroment(buildUrl(order.getEmpresa())) + "tipoDocumento=" + order.getDocType() + "&documento="
					+ order.getDocNumber() + "&situacao=" + order.getFlagSituation() + "&dataSituacao="
					+ order.getDtSituation() + "&motivoSituacao=Faturamento" + "&empresa=" + order.getCompany()
					+ "&fatura=" + order.getInvoiceNumber() + "&fatura_empresa=" + order.getInvoiceCompany()
					+ "&tipoFatura=4&hash=" + publiCookie);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");
			
			if (conn.getResponseCode() >= 400) {
				obj = Utils.ConvertInputStreamToJsonString(conn.getErrorStream());
				System.out.println("Erro ao atualizar o processo de número " + order.getDocNumber() + ".\n"
									+ "Mais detalhes: " + obj);
			} else {
				System.out.println("Empresa " + order.getEmpresa() + ": Processo (" + order.getDocType()
						+ ") de número " + order.getDocNumber() + " atualizado!");
			}

			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar o processo de número " + order.getDocNumber() + " ("
					+ order.getDocType() + ") \n" + "Mais detalhes: " + e.getMessage() + "\n");
		}

	}

	private static String buildCookie(String empresa) {
		
		if ("Ampla".equals(empresa)) {
			return cookieAmpla;
		} else if ("BG9 PE".equals(empresa)) {
			return cookieBg9PE;
		} else if ("BG9 AL".equals(empresa)) {
			return cookieBg9AL;
		}
		
		return null;
	}

	private static String buildUrl(String empresa) {
		String service = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/SetSituacao?";
		
		if (empresa.startsWith("BG9")) {
			service = "http://apibg9.publicloud.com.br/Services/IntegracaoService.svc/SetSituacao?";
		}
		
		return service;
	}

	public static void updateAD_PUBLI(ArrayList<InvoicedOrder> list) throws SQLException {

		Connection conn = JdbcOracleConnection.getDBConnection();
		PreparedStatement pstmt1 = null;

		String query = "UPDATE TGFCAB SET AD_PUBLI = ? WHERE NUNOTA = ?";

		conn.setAutoCommit(false);

		pstmt1 = conn.prepareStatement(query);

		try {

			for (InvoicedOrder item : list) {

				try {

					pstmt1.setDate(1, new java.sql.Date(Utils.GetDateTimeNowDDMMYYY().getTime()));
					pstmt1.setInt(2, Integer.parseInt(item.getNUNOTA()));
					pstmt1.executeUpdate();

					conn.commit();

				} catch (SQLException e) {

					System.out
							.println("\n\nErro ao atualizar as informacoes da nota de nro unico: " + item.getNUNOTA());

					if (conn != null) {
						try {
							conn.rollback();
						} catch (SQLException e2) {
							e.printStackTrace();
							System.out.println("\n\n" + e.getMessage());
						}

					}
				}

			}

		} finally {

			if (pstmt1 != null) {
				pstmt1.close();
			}

			conn.setAutoCommit(true);

			if (conn != null) {
				conn.close();
			}
		}

	}

}
