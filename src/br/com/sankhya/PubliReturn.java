package br.com.sankhya;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sankhya.common.Utils;
import br.com.sankhya.infrastructure.JdbcOracleConnection;
import br.com.sankhya.service.InvoicedOrder;
import br.com.sankhya.service.PubliAmplaServiceHelper;

public class PubliReturn {

	private static final String service = "https://apiduca.publicloud.com.br/Services/IntegracaoService.svc/SetSituacao?";
	private static final String publiCookie = new PubliAmplaServiceHelper().Login();
	private static final boolean producao = false;
	
	private static String getURLEnviroment(String url) {
		return producao ? url : url.replace("//apiduca.", "//homologaapiduca.");
	}

	public static void main(String[] args) throws SQLException {

		System.out.println("Iniciando o processo de atualização de Status no Publi.");

		ArrayList<InvoicedOrder> list = new ArrayList<InvoicedOrder>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		String query = "SELECT DISTINCT CASE WHEN ITE.CODPROD IN (661, 662, 671, 674,675) THEN ? "
				+ "ELSE ? END AS TIPODOC, CAB.NUMNOTA AS DOCUMENTO, CAB.NUMNOTA AS FATURA,CAB.NUNOTA AS NUNOTA, CAB.CODTIPOPER AS TOP, "
				+ "CAB.DTFATUR AS DTSITUACAO, CAB.AD_PIXOC AS PIXOC FROM TGFCAB CAB INNER JOIN TGFITE ITE ON (ITE.NUNOTA = CAB.NUNOTA) "
				+ "WHERE (CAB.DTFATUR BETWEEN ? AND ?) AND CAB.TIPMOV = ? AND CAB.AD_PUBLI IS NULL AND CAB.AD_PIXOC IS NOT NULL";

		try {

			conn = JdbcOracleConnection.getDBConnection();

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "PI");
			pstmt.setString(2, "OC");
			pstmt.setDate(3, new java.sql.Date(Utils.GetInvoicedOrderIntervalDateDDMMYYYY().getTime()));
			pstmt.setDate(4, new java.sql.Date(Utils.GetDateTimeNowDDMMYYY().getTime()));
			pstmt.setString(5, "V");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				InvoicedOrder order = new InvoicedOrder();

				order.setDocType(rs.getString("TIPODOC"));

				if(order.getDocType().equals("OC")) {
                    order.setDocNumber(Integer.toString(rs.getInt("DOCUMENTO")));
                }else{
                    order.setDocNumber(Integer.toString(rs.getInt("PIXOC")));
                }

				order.setDtSituation(rs.getString("DTSITUACAO"));
				order.setCompany("1");
				order.setInvoiceNumber(Integer.toString(rs.getInt("FATURA")));
				order.setInvoiceCompany("1");
				order.setInvoiceType("");
				order.setTOP(rs.getString("TOP"));

				if (order.getTOP().equals("706")) {
					order.setFlagSituation("O");
				} else {
					order.setFlagSituation("F");
				}

				order.setNUNOTA(Integer.toString(rs.getInt("NUNOTA")));

				list.add(order);

			}

			System.out.println("\n\nForam encontrados " + Integer.toString(list.size()) + " registros.");

			for (InvoicedOrder item : list) {

				setInvoicedStateOnPubli(item);

			}

			updateAD_PUBLI(list);

			System.out.println("\n\nAtualização de Status do Publi finalizado.");

		} catch (SQLException e) {

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

	public static void setInvoicedStateOnPubli(InvoicedOrder order) {

		try {

			String obj = "";
			System.out.println("\n\nAtualizando o documento de número: " + order.getDocNumber());

			URL url = new URL(getURLEnviroment(service) + "tipoDocumento=" + order.getDocType() + "&documento=" + order.getDocNumber()
					+ "&situacao=" + order.getFlagSituation() + "&dataSituacao=" + order.getDtSituation()
					+ "&motivoSituacao=Faturamento" + "&empresa=" + order.getCompany() + "&fatura="
					+ order.getInvoiceNumber() + "&fatura_empresa=" + order.getInvoiceCompany() + "&tipoFatura=" + " "
					+ "&hash=" + publiCookie);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			System.out.println(obj);

			conn.disconnect();

			System.out.println("Processo de número: " + order.getDocNumber() + " atualizado!");

		} catch (MalformedURLException e) {

			System.out.println("\n\n" + e.getMessage());

		} catch (IOException e) {

			System.out.println("\n\n" + e.getMessage());

		}

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
