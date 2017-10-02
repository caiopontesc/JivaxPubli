package br.com.sankhya.common;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import br.com.sankhya.domain.Address;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.FixedCost;
import br.com.sankhya.domain.Item;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.service.JivaServiceHelper;
import br.com.sankhya.service.PubliAmplaServiceHelper;
import br.com.sankhya.service.PubliBg9ALServiceHelper;
import br.com.sankhya.service.PubliBg9PEServiceHelper;

public class XmlHelper {
	private static final String loginService = "MobileLoginSP.login";
	private static final String insertOrderService = "CACSP.incluirNota";
	private static final String loadService = "CRUDServiceProvider.loadRecords";
	private static final String insertService = "CRUDServiceProvider.saveRecord";
	private static final String executiveProd = "PP";
	private static final String graphicProd = "PG";
	private static final String eletronicProd = "PE";
	private static final String digitalProd = "PD";

	/**
	 * Monta XML para Login no Jiva
	 * 
	 * @return token
	 */
	public static Document MountLogInRequest() {

		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loginService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// Parameters
		// NOMUSU
		Element nomUsu = new Element("NOMUSU");
		nomUsu.setText("SUP");
		// INTERNO
		Element interno = new Element("INTERNO");
		interno.setText("Duca2016!");
		body.addContent(nomUsu);
		body.addContent(interno);
		doc.getRootElement().addContent(body);

		return doc;

	}

	/**
	 * Monta XML para Inserir Orçamento no Jiva
	 * 
	 * @param order
	 * @return
	 */
	public static Document MountXMLToInsertBudget(MediaOrder order) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho

			Element nunota = new Element("NUNOTA");

			Element centRes = new Element("CODCENCUS");
			centRes.setText("101012");
			Element natureza = new Element("CODNAT");
			natureza.setText("30101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("P");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(br.com.sankhya.common.Utils.ConvertMSJSONDateToDate(order.getDataInclusao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("300");
			Element codParc = new Element("CODPARC");
			codParc.setText("6565");
			Element tipOper = new Element("CODTIPOPER");
			tipOper.setText("601");
			Element codEmp = new Element("CODEMP");
			codEmp.setText("2");
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("OBSERVACAO");
			obs.setText("Pedido incluido via integração.");

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMAPRECO", "S"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");
			Element codProd = new Element("CODPROD");
			codProd.setText("168");
			Element codVol = new Element("CODVOL");
			codVol.setText("UN");
			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");
			Element controle = new Element("CONTROLE");
			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");
			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText("10.00");

			item.addContent(vlrUnit);
			item.addContent(qtdNeg);
			item.addContent(controle);
			item.addContent(codLocalOrig);
			item.addContent(codVol);
			item.addContent(codProd);
			item.addContent(sequencia);
			item.addContent(nunotaIte);
			itens.addContent(item);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			// System.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return doc;
		}
	}

	/**
	 * Monta XML para verificar se um Pedido existe através do NUMNOTA
	 * 
	 * @param numNota
	 * @return true/false
	 */
	public static Document MountXMLToVerifyIfOrderExists(String numNota, String tipMov, int codEmp) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "CabecalhoNota"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "NUNOTA"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.NUMNOTA = " + numNota + " AND this.TIPMOV = '" + tipMov + "' AND this.CODEMP = "
				+ Integer.toString(codEmp));

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;
	}

	/**
	 * Verifica nos elementos do XML retornado se o pedido existe ou não
	 * 
	 * @param doc
	 * @return true/false
	 */
	public static boolean OrderExists(org.w3c.dom.Document doc) {

		String pk = "";
		boolean exists = false;

		NodeList nList = doc.getElementsByTagName("entity");

		for (int i = 0; i < nList.getLength(); i++) {

			Node node = nList.item(i);
			org.w3c.dom.Element element = (org.w3c.dom.Element) node;

			pk = element.getElementsByTagName("f0").item(0).getTextContent();
		}

		if (pk == null || pk.isEmpty()) {
			exists = false;
		} else {
			exists = true;
		}

		return exists;
	}

	public static String GetOrderId(org.w3c.dom.Document doc) {

		String pk = "";

		try {

			NodeList nList = doc.getElementsByTagName("entity");

			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);
				org.w3c.dom.Element element = (org.w3c.dom.Element) node;

				pk = element.getElementsByTagName("f0").item(0).getTextContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pk;
	}

	// Orders Area
	/**
	 * Monta XML para inserir uma AP
	 * 
	 * @param order
	 * @param customerId
	 * @param providerId
	 * @return
	 */
	public static Document MountXMLToInsertPublicationAuth(MediaOrder order, String customerId, String providerId,
			String providerCNPJ, String cookie) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		String codCenCus = JivaServiceHelper.GetCustomerCostCenterById(customerId);

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho

			Element nunota = new Element("NUNOTA");

			Element numNota = new Element("NUMNOTA");
			numNota.setText(Integer.toString(order.getPlanilhaNumero()));

			Element numPIOC = new Element("AD_PIXOC");
			numPIOC.setText(Integer.toString(order.getNumero()));

			Element sFrete = new Element("CIF_FOB");
			sFrete.setText("S");

			Element centRes = new Element("CODCENCUS");
			if (codCenCus == null || codCenCus.isEmpty()) {
				centRes.setText("9900000");
			} else {
				centRes.setText(codCenCus);
			}

			Element natureza = new Element("CODNAT");
			natureza.setText("30101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("P");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(Utils.ConvertMSJSONDateToDate(order.getDataManutencao()));// Utils.ConvertMSJSONDateToDate(order.getDataInclusao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("300");
			Element codParc = new Element("CODPARC");
			codParc.setText(customerId);
			Element tipOper = new Element("CODTIPOPER");
			tipOper.setText("601");
			Element codEmp = new Element("CODEMP");
			codEmp.setText(Integer.toString(order.getEmpresa()));
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("AD_OBSERVACAOPEDIDO");
			if (order.getTextosLivres() != null && !order.getTextosLivres().isEmpty()) {

				if (!order.getTextosLivres().get(0).getTexto().isEmpty()) {
					String teste = "DESCRICAO: " + order.getTextosLivres().get(0).getTexto() + "\r\n AP: "
							+ Integer.toString(order.getPlanilhaNumero()) + "\r\nPedido incluido via integracao.";
					obs.setText(Utils.removeInvalidXMLCharacters(teste));
				} else {
					obs.setText("DESCRICAO: " + "\r\n AP: " + order.getPlanilhaNumero()
							+ "\r\nPedido incluido via integracao.");
				}
			} else {
				obs.setText("DESCRICAO: " + "\r\n AP: " + order.getPlanilhaNumero()
						+ "\r\nPedido incluido via integracao.");
			}

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMARPRECO", "True"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");

			Element codProd = new Element("CODPROD");

			if (order.getMeio() != null && !order.getMeio().isEmpty() && order.getMeio().equals("IN")) {
				codProd.setText("661");
			} else if (order.getMeio() != null && !order.getMeio().isEmpty()) {
				codProd.setText("662");
			}

			Element codVol = new Element("CODVOL");
			codVol.setText("UN");

			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");

			Element controle = new Element("CONTROLE");

			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");

			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText(String.format("%.2f", order.getParcelas().get(0).getLiquido()).replace(",", "."));

			Element percDesc = new Element("PERCDESC");
			percDesc.setText("0.00");

			Element codFor = new Element("AD_CODFORN");
			codFor.setText(providerId);

			Element descFor = new Element("AD_FORNECEDOR");
			descFor.setText(JivaServiceHelper.GetCustomerNameById(providerId, cookie));

			Element notaF = new Element("AD_NOTA");
			notaF.setText(Utils.removeInvalidXMLCharacters(Utils.RemoveSpecialCharacters(order.getNfNumero()))
					.replaceAll("[^\\d.]", ""));

			Element descr = new Element("OBSERVACAO");
			if (order.getTextosLivres() != null && !order.getTextosLivres().isEmpty()) {

				if (!order.getTextosLivres().get(0).getTexto().isEmpty()) {

					descr.setText(Utils
							.removeInvalidXMLCharacters("CAMPANHA: " + order.getCampanha() + "\nNOME FORNECEDOR: "
									+ order.getNomeFornecedor() + "\nCNPJ: "
									+ Utils.RemoveSpecialCharacters(providerCNPJ) + "\nNOTA FISCAL FORNECEDOR: "
									+ Utils.removeInvalidXMLCharacters(
											Utils.removeInvalidXMLCharacters(order.getNfNumero()))
									+ "\nPI: " + order.getNumero())
							+ "\nVENCIMENTO: " + Utils.ConvertMSJSONDateToDate(order.getVencimento()));
				} else {
					descr.setText(Utils
							.removeInvalidXMLCharacters("CAMPANHA: " + order.getCampanha() + "\nNOME FORNECEDOR: "
									+ order.getNomeFornecedor() + "\nCNPJ: "
									+ Utils.RemoveSpecialCharacters(providerCNPJ) + "\nNOTA FISCAL FORNECEDOR: "
									+ Utils.removeInvalidXMLCharacters(
											Utils.removeInvalidXMLCharacters(order.getNfNumero()))
									+ "\nPI: " + order.getNumero())
							+ "\nVENCIMENTO: " + Utils.ConvertMSJSONDateToDate(order.getVencimento()));
				}

			} else {
				descr.setText(Utils
						.removeInvalidXMLCharacters("CAMPANHA: " + order.getCampanha() + "\nNOME FORNECEDOR: "
								+ order.getNomeFornecedor() + "\nCNPJ: " + Utils.RemoveSpecialCharacters(providerCNPJ)
								+ "\nNOTA FISCAL FORNECEDOR: "
								+ Utils.removeInvalidXMLCharacters(
										Utils.removeInvalidXMLCharacters(order.getNfNumero()))
								+ "\nPI: " + order.getNumero())
						+ "\nVENCIMENTO: " + Utils.ConvertMSJSONDateToDate(order.getVencimento()));
			}

			Element dtVenc = new Element("AD_DTVENCIMENTO");
			dtVenc.setText(Utils.removeInvalidXMLCharacters(Utils.ConvertMSJSONDateToDate(order.getVencimento())));

			// item2
			Element item2 = new Element("item");

			Element nunotaIte2 = new Element("NUNOTA");
			Element sequencia2 = new Element("SEQUENCIA");

			Element codProd2 = new Element("CODPROD");
			if(codProd.getText().equals("661")) {
				codProd2.setText("674");
			}else{
				codProd2.setText("675");
			}

			Element codVol2 = new Element("CODVOL");
			codVol2.setText("UN");

			Element codLocalOrig2 = new Element("CODLOCALORIG");
			codLocalOrig2.setText("0");

			Element controle2 = new Element("CONTROLE");

			Element qtdNeg2 = new Element("QTDNEG");
			qtdNeg2.setText("1");

			Element descr2 = new Element("OBSERVACAO");
			if (order.getTextosLivres() != null && !order.getTextosLivres().isEmpty()) {
				if (!order.getTextosLivres().get(0).getTexto().isEmpty()) {
					descr2.setText(Utils.removeInvalidXMLCharacters("AP: " + Integer.toString(order.getPlanilhaNumero())
							+ "\nCAMPANHA: " + order.getCampanha()));
				} else {
					descr2.setText(Utils.removeInvalidXMLCharacters("AP: " + Integer.toString(order.getPlanilhaNumero())
							+ "\nCAMPANHA: " + order.getCampanha()));
				}
			} else {
				descr2.setText(Utils.removeInvalidXMLCharacters(
						"AP: " + Integer.toString(order.getPlanilhaNumero()) + "\nCAMPANHA: " + order.getCampanha()));
			}

			Element vlrUnit2 = new Element("VLRUNIT");
			double comission = order.getParcelas().get(0).getBrutoCliente() - order.getParcelas().get(0).getLiquido();
			vlrUnit2.setText(String.format("%.2f", comission).replace(",", "."));

			Element percDesc2 = new Element("PERCDESC");
			percDesc2.setText("0.00");
			// vlrUnit2.setText(Utils.CalculatesComission(order.getParcelas().get(0).getLiquido(),
			// order.getPercentualHonorarios()));

			if (order.getParcelas().get(0).getBrutoCliente() - order.getParcelas().get(0).getLiquido() != 0) {

				item2.addContent(percDesc2);
				item2.addContent(descr2);
				item2.addContent(vlrUnit2);
				item2.addContent(qtdNeg2);
				item2.addContent(controle2);
				item2.addContent(codLocalOrig2);
				item2.addContent(codVol2);
				item2.addContent(codProd2);
				item2.addContent(sequencia2);
				item2.addContent(nunotaIte2);
				itens.addContent(item2);
			}

			item.addContent(dtVenc);
			item.addContent(percDesc);
			item.addContent(notaF);
			item.addContent(descr);
			item.addContent(codFor);
			item.addContent(descFor);
			item.addContent(vlrUnit);
			item.addContent(qtdNeg);
			item.addContent(controle);
			item.addContent(codLocalOrig);
			item.addContent(codVol);
			item.addContent(codProd);
			item.addContent(sequencia);
			item.addContent(nunotaIte);
			itens.addContent(item);

			cabecalho.addContent(sFrete);
			cabecalho.addContent(numPIOC);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(numNota);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			// System.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return doc;
		}
	}

	/**
	 * Monta XML para inserir um Pedido de Mídia no Jiva
	 * 
	 * @param order
	 * @return
	 */
	public static Document MountXMLToInsertMediaOrder(MediaOrder order, String fornId, int tipoFat, String customerId) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		String codCenCus = JivaServiceHelper.GetCustomerCostCenterById(customerId);

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho

			Element nunota = new Element("NUNOTA");

			Element numNota = new Element("NUMNOTA");
			numNota.setText(Integer.toString(order.getPlanilhaNumero()));

			Element centRes = new Element("CODCENCUS");

			if (codCenCus == null || codCenCus.isEmpty()) {
				centRes.setText("9900000");
			} else {
				centRes.setText(codCenCus);
			}

			Element natureza = new Element("CODNAT");
			natureza.setText("80101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("C");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(Utils.ConvertMSJSONDateToDate(order.getDataManutencao()));// Utils.ConvertMSJSONDateToDate(order.getDataInclusao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("300");
			Element codParc = new Element("CODPARC");
			codParc.setText(fornId);
			Element tipOper = new Element("CODTIPOPER");

			if (tipoFat == 2) {
				tipOper.setText("307");
			} else {
				tipOper.setText("306");
			}

			Element codEmp = new Element("CODEMP");
			codEmp.setText(Integer.toString(order.getEmpresa()));
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("AD_OBSERVACAOPEDIDO");

			if (order.getTextosLivres() != null && !order.getTextosLivres().isEmpty()) {

				if (!order.getTextosLivres().get(0).getTexto().isEmpty()) {
					obs.setText(Utils.removeInvalidXMLCharacters("DESCRICAO: "
							+ order.getTextosLivres().get(0).getTexto() + "\r\n AP: "
							+ Integer.toString(order.getPlanilhaNumero()) + "\r\nPedido incluido via integracao."));
				} else {
					obs.setText(Utils.removeInvalidXMLCharacters("DESCRICAO: " + "\r\n AP: "
							+ Integer.toString(order.getPlanilhaNumero()) + "\r\nPedido incluido via integracao."));
				}
			} else {
				obs.setText(Utils.removeInvalidXMLCharacters("DESCRICAO: " + "\r\n AP: "
						+ Integer.toString(order.getPlanilhaNumero()) + "\r\nPedido incluido via integracao."));
			}

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMARPRECO", "S"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");

			Element codProd = new Element("CODPROD");

			if (order.getMeio() != null && !order.getMeio().isEmpty() && order.getMeio().equals("IN")) {
				codProd.setText("661");
			} else if (order.getMeio() != null && !order.getMeio().isEmpty()) {
				codProd.setText("662");
			}

			Element codVol = new Element("CODVOL");
			codVol.setText("UN");

			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");

			Element controle = new Element("CONTROLE");

			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");

			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText(Double.toString(order.getParcelas().get(0).getLiquido()));

			Element codFor = new Element("AD_CODFORN");
			codFor.setText(fornId);

			Element descFor = new Element("AD_FORNECEDOR");
			descFor.setText(order.getNomeFornecedor());

			Element descr = new Element("OBSERVACAO");
			if (order.getTextosLivres() != null && !order.getTextosLivres().isEmpty()) {
				if (!order.getTextosLivres().get(0).getTexto().isEmpty()) {
					descr.setText(Utils.removeInvalidXMLCharacters("NOME FORNECEDOR: " + order.getNomeFornecedor()
							+ "\r\nDESCRICAO: " + order.getTextosLivres().get(0).getTexto() + "\r\n PI: "
							+ Integer.toString(order.getNumero())));
				} else {
					descr.setText(Utils.removeInvalidXMLCharacters(
							"DESCRICAO: " + "\r\n PI: " + Integer.toString(order.getNumero())));
				}
			} else {
				descr.setText(Utils
						.removeInvalidXMLCharacters("DESCRICAO: " + "\r\n PI: " + Integer.toString(order.getNumero())));
			}

			Element numNf = new Element("AD_NUMNOTAFORN");
			numNf.setText(Utils.RemoveSpecialCharacters(order.getNfNumero().replaceAll("[^0-9]", "")));

			Element numNfEmi = new Element("AD_DTEMISSAO");
			numNfEmi.setText(Utils.ConvertMSJSONDateToDate(order.getNfEmissao()));

			Element venc = new Element("AD_DTVENCIMENTO");
			venc.setText(Utils.ConvertMSJSONDateToDate(order.getVencimento()));

			// item2
			Element item2 = new Element("item");

			Element nunotaIte2 = new Element("NUNOTA");
			Element sequencia2 = new Element("SEQUENCIA");

			Element codProd2 = new Element("CODPROD");
			codProd2.setText("671");

			Element codVol2 = new Element("CODVOL");
			codVol2.setText("UN");

			Element codLocalOrig2 = new Element("CODLOCALORIG");
			codLocalOrig2.setText("0");

			Element controle2 = new Element("CONTROLE");

			Element qtdNeg2 = new Element("QTDNEG");
			qtdNeg2.setText("1");

			Element vlrUnit2 = new Element("VLRUNIT");
			vlrUnit2.setText(br.com.sankhya.common.Utils.CalculatesComission(order.getParcelas().get(0).getLiquido(),
					order.getPercentualHonorarios()));

			item2.addContent(vlrUnit2);
			item2.addContent(qtdNeg2);
			item2.addContent(controle2);
			item2.addContent(codLocalOrig2);
			item2.addContent(codVol2);
			item2.addContent(codProd2);
			item2.addContent(sequencia2);
			item2.addContent(nunotaIte2);
			itens.addContent(item2);
			item.addContent(venc);
			item.addContent(numNfEmi);
			item.addContent(numNf);
			item.addContent(descr);
			item.addContent(descFor);
			item.addContent(codFor);
			item.addContent(vlrUnit);
			item.addContent(qtdNeg);
			item.addContent(controle);
			item.addContent(codLocalOrig);
			item.addContent(codVol);
			item.addContent(codProd);
			item.addContent(sequencia);
			item.addContent(nunotaIte);
			itens.addContent(item);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(numNota);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			// sóSystem.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return doc;
		}
	}

	/**
	 * Metodo incompleto (se precisar, terminar)
	 * 
	 * @param order
	 * @param orderId
	 * @return
	 */
	public static Document MountXMLToUpdateMediaOrder(MediaOrder order, String orderId) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho

			Element nunota = new Element("NUNOTA");

			Element numNota = new Element("NUMNOTA");
			numNota.setText(Integer.toString(order.getNumero()));

			Element centRes = new Element("CODCENCUS");
			centRes.setText("101012");
			Element natureza = new Element("CODNAT");
			natureza.setText("30101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("P");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(br.com.sankhya.common.Utils.ConvertMSJSONDateToDate(order.getDataInclusao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("300");
			Element codParc = new Element("CODPARC");
			codParc.setText("6565");
			Element tipOper = new Element("CODTIPOPER");
			tipOper.setText("601");
			Element codEmp = new Element("CODEMP");
			codEmp.setText("2");
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("AD_OBSERVACAOPEDIDO");
			obs.setText("DESCRICAO: " + order.getTextosLivres().get(0).getTexto() + "\r\n AP: "
					+ order.getPlanilhaNumero() + "\r\nPedido incluido via integração.");

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMAPRECO", "S"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");

			Element codProd = new Element("CODPROD");

			if (order.getMeio() != null && !order.getMeio().isEmpty() && order.getMeio().equals("IN")) {
				codProd.setText("661");
			} else if (order.getMeio() != null && !order.getMeio().isEmpty()) {
				codProd.setText("662");
			}

			Element codVol = new Element("CODVOL");
			codVol.setText("UN");

			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");

			Element controle = new Element("CONTROLE");

			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");

			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText(Double.toString(order.getParcelas().get(0).getLiquido()));

			// item2
			Element item2 = new Element("item");

			Element nunotaIte2 = new Element("NUNOTA");
			Element sequencia2 = new Element("SEQUENCIA");

			Element codProd2 = new Element("CODPROD");
			codProd2.setText("671");

			Element codVol2 = new Element("CODVOL");
			codVol2.setText("UN");

			Element codLocalOrig2 = new Element("CODLOCALORIG");
			codLocalOrig2.setText("0");

			Element controle2 = new Element("CONTROLE");

			Element qtdNeg2 = new Element("QTDNEG");
			qtdNeg2.setText("1");

			Element vlrUnit2 = new Element("VLRUNIT");
			vlrUnit2.setText(Double
					.toString(order.getParcelas().get(0).getBrutoCliente() - order.getParcelas().get(0).getLiquido()));

			// chave para update
			Element key = new Element("key");

			Element cod = new Element("NUNOTA");
			cod.setText(orderId);

			item.addContent(vlrUnit2);
			item.addContent(qtdNeg2);
			item.addContent(controle2);
			item.addContent(codLocalOrig2);
			item.addContent(codVol2);
			item.addContent(codProd2);
			item.addContent(sequencia2);
			item.addContent(nunotaIte2);
			itens.addContent(item2);
			item.addContent(vlrUnit);
			item.addContent(qtdNeg);
			item.addContent(controle);
			item.addContent(codLocalOrig);
			item.addContent(codVol);
			item.addContent(codProd);
			item.addContent(sequencia);
			item.addContent(nunotaIte);
			itens.addContent(item);
			key.addContent(cod);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			// System.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return doc;
		}
	}

	/**
	 * Monta XML para inserir uma OC
	 * 
	 * @param budget
	 * @param customerId
	 * @param service
	 * @return
	 */
	public static Document MountXMLToInsertFixedBudget(FixedBudget budget, String customerId, Object service,
			String cookie) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		String codCenCus = JivaServiceHelper.GetCustomerCostCenterById(customerId);
		String nf = "";

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho
			Element nunota = new Element("NUNOTA");

			Element numNota = new Element("NUMNOTA");
			numNota.setText(Integer.toString(budget.getNumero()));

			Element sFrete = new Element("CIF_FOB");
			sFrete.setText("S");

			Element centRes = new Element("CODCENCUS");
			if (codCenCus == null || codCenCus.isEmpty()) {
				centRes.setText("9900000");
			} else {
				centRes.setText(codCenCus);
			}

			Element natureza = new Element("CODNAT");
			natureza.setText("30101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("P");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(Utils.ConvertMSJSONDateToDate(budget.getDataManutencao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("300");
			Element codParc = new Element("CODPARC");
			codParc.setText(customerId);
			Element tipOper = new Element("CODTIPOPER");
			tipOper.setText("602");
			Element codEmp = new Element("CODEMP");
			codEmp.setText(Integer.toString(budget.getEmpresa()));
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("AD_OBSERVACAOPEDIDO");
			obs.setText("CAMPANHA: " + budget.getCampanha() + "; \r\n" + "DESCRIÇÃO: "
					+ budget.getDescricao().replace("<br>", " ") + "\r\nPedido incluido via integracao.");

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMARPRECO", "True"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");

			Element codProd = new Element("CODPROD");

			switch (budget.getSubTipo()) {
				case executiveProd:
					codProd.setText("680");
					break;
				case eletronicProd:
					codProd.setText("677");
					break;
				case graphicProd:
					codProd.setText("676");
					break;
				case digitalProd:
					 codProd.setText("678");
					 break;
				default:

			}

			Element codVol = new Element("CODVOL");
			codVol.setText("UN");

			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");

			Element controle = new Element("CONTROLE");

			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");

			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText(Double.toString(budget.getHonorarios()));

			Element percDesc = new Element("PERCDESC");
			percDesc.setText("0.00");

			Element descr = new Element("OBSERVACAO");
			descr.setText(budget.getDescricao().replace("<br>", " "));

			if (budget.getCustosFixos() != null && !budget.getCustosFixos().isEmpty()) {

				for (FixedCost obj : budget.getCustosFixos()) {

					// Servico Interno
					if (obj.getNomeFornecedor().isEmpty() && obj.getCodigoFornecedor() == 0) {

						Element item2 = new Element("item");

						Element nunotaIte2 = new Element("NUNOTA");
						Element sequencia2 = new Element("SEQUENCIA");

						Element codProd2 = new Element("CODPROD");
						codProd2.setText("673");

						Element codVol2 = new Element("CODVOL");
						codVol2.setText("UN");

						Element codLocalOrig2 = new Element("CODLOCALORIG");
						codLocalOrig2.setText("0");

						Element controle2 = new Element("CONTROLE");

						Element qtdNeg2 = new Element("QTDNEG");
						qtdNeg2.setText(Integer.toString(obj.getQuantidade()));

						Element vlrUnit2 = new Element("VLRUNIT");
						vlrUnit2.setText(Double.toString(obj.getValorUnitario()));

						//Levava em consideração o valor de desconto
						/*
						 * Element vlrDesc2 = new Element("VLRDESC");
						 * vlrDesc2.setText(Double.toString((obj.
						 * getValorUnitario() / 100) * obj.getDesconto()));
						 */

						Element percDesc2 = new Element("PERCDESC");
						percDesc2.setText(Double.toString(obj.getDesconto()));

						Element descr2 = new Element("OBSERVACAO");
						descr2.setText(
								"OC: " + budget.getNumero() + "\nCAMPANHA: " + budget.getCampanha().replace("<br>", " ")
										+ "\nVENCIMENTO: " + Utils.ConvertMSJSONDateToDate(budget.getVencimento()));

						item2.addContent(descr2);
						item2.addContent(percDesc2);
						item2.addContent(vlrUnit2);
						item2.addContent(qtdNeg2);
						item2.addContent(controle2);
						item2.addContent(codLocalOrig2);
						item2.addContent(codVol2);
						item2.addContent(codProd2);
						item2.addContent(sequencia2);
						item2.addContent(nunotaIte2);
						itens.addContent(item2);

					// Servico Encomendado
					} else {

						Provider provider = new Provider();

						Element item2 = new Element("item");

						Element nunotaIte2 = new Element("NUNOTA");
						Element sequencia2 = new Element("SEQUENCIA");

						Element codProd2 = new Element("CODPROD");

						switch (budget.getSubTipo()) {
							case executiveProd:
								codProd2.setText("665");
								break;
							case eletronicProd:
								codProd2.setText("664");
								break;
							case graphicProd:
								codProd2.setText("663");
								break;
							case digitalProd:
								codProd2.setText("666");
								break;
						}

						Element codVol2 = new Element("CODVOL");
						codVol2.setText("UN");

						Element codLocalOrig2 = new Element("CODLOCALORIG");
						codLocalOrig2.setText("0");

						Element controle2 = new Element("CONTROLE");

						Element qtdNeg2 = new Element("QTDNEG");
						qtdNeg2.setText(Integer.toString(obj.getQuantidade()));

						Element vlrUnit2 = new Element("VLRUNIT");
						vlrUnit2.setText(Double.toString(obj.getValorUnitario()));

						Element percDesc2 = new Element("PERCDESC");
						percDesc2.setText(Double.toString(obj.getDesconto()));

						if (service instanceof PubliAmplaServiceHelper) {
							nf = new PubliAmplaServiceHelper().GetProviderNF(obj.getPedido());
						} else if (service instanceof PubliBg9PEServiceHelper) {
							nf = new PubliBg9PEServiceHelper().GetProviderNF(obj.getPedido());
						} else {
							nf = new PubliBg9ALServiceHelper().GetProviderNF(obj.getPedido());
						}

						if (service instanceof PubliAmplaServiceHelper) {
							provider = new PubliAmplaServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						} else if (service instanceof PubliBg9PEServiceHelper) {
							provider = new PubliBg9PEServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						} else {
							provider = new PubliBg9ALServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						}

						Element notaF = new Element("AD_NOTA");
						notaF.setText(Utils.removeInvalidXMLCharacters(Utils.RemoveSpecialCharacters(nf))
								.replaceAll("[^\\d.]", ""));

						Element codFor = new Element("AD_CODFORN");
						codFor.setText(JivaServiceHelper.GetCustomerIdByCNPJ(
								br.com.sankhya.common.Utils.RemoveSpecialCharacters(provider.getCnpj()), cookie,
								Integer.toString(provider.getCodigo())));

						Element descFor = new Element("AD_FORNECEDOR");
						descFor.setText(JivaServiceHelper.GetCustomerNameById(JivaServiceHelper.GetCustomerIdByCNPJ(
								br.com.sankhya.common.Utils.RemoveSpecialCharacters(provider.getCnpj()), cookie,
								Integer.toString(provider.getCodigo())), cookie));

						Element tipo2 = new Element("TIPO");
						tipo2.setText(budget.getSubTipo());

						Element descr2 = new Element("OBSERVACAO");
						descr2.setText("CAMPANHA: " + budget.getCampanha() + "\nNOME DO FORNECEDOR: "
								+ obj.getNomeFornecedor() + "\nNOTA FISCAL DO FORNECEDOR: " + nf + "\nCNPJ: "
								+ provider.getCnpj() + "\nDESCRICAO: " + obj.getDescricao().replace("<br>", " ")
								+ "\nPP: " + obj.getPedido());

						Element dtVenc = new Element("AD_DTVENCIMENTO");
						dtVenc.setText(Utils
								.removeInvalidXMLCharacters(Utils.ConvertMSJSONDateToDate(budget.getVencimento())));

						item2.addContent(dtVenc);
						item2.addContent(descr2);
						item2.addContent(tipo2);
						item2.addContent(notaF);
						item2.addContent(descFor);
						item2.addContent(codFor);
						item2.addContent(percDesc2);
						item2.addContent(vlrUnit2);
						item2.addContent(qtdNeg2);
						item2.addContent(controle2);
						item2.addContent(codLocalOrig2);
						item2.addContent(codVol2);
						item2.addContent(codProd2);
						item2.addContent(sequencia2);
						item2.addContent(nunotaIte2);
						itens.addContent(item2);

					}
				}

			} else if (budget.getItens() != null && !budget.getItens().isEmpty()) {

				for (Item obj : budget.getItens()) {

					// Servico Interno
					if (obj.getNomeFornecedor().isEmpty() && obj.getCodigoFornecedor() == 0 && obj.getGrau() == 2) {

						Element item2 = new Element("item");

						Element nunotaIte2 = new Element("NUNOTA");
						Element sequencia2 = new Element("SEQUENCIA");

						Element codProd2 = new Element("CODPROD");
						codProd2.setText("673");

						Element codVol2 = new Element("CODVOL");
						codVol2.setText("UN");

						Element codLocalOrig2 = new Element("CODLOCALORIG");
						codLocalOrig2.setText("0");

						Element controle2 = new Element("CONTROLE");

						Element qtdNeg2 = new Element("QTDNEG");
						if (obj.getQuantidadeUnitaria() != 0) {
							qtdNeg2.setText(Integer.toString(obj.getQuantidade() * obj.getQuantidadeUnitaria()));
						} else {
							qtdNeg2.setText(Integer.toString(obj.getQuantidade()));
						}

						Element vlrUnit2 = new Element("VLRUNIT");
						vlrUnit2.setText(Double.toString(obj.getValorUnitario()));

						//Levava em consideração o valor do desconto
						/*
						 * Element vlrDesc2 = new Element("VLRDESC");
						 * vlrDesc2.setText(Double.toString((obj.
						 * getValorUnitario() / 100) * obj.getDesconto()));
						 */

						Element percDesc2 = new Element("PERCDESC");
						percDesc2.setText(Double.toString(obj.getDesconto()));

						Element descr2 = new Element("OBSERVACAO");
						descr2.setText(
								"OC: " + budget.getNumero() + "\nCAMPANHA: " + budget.getCampanha().replace("<br>", " ")
										+ "\nVENCIMENTO: " + Utils.ConvertMSJSONDateToDate(budget.getVencimento()));

						item2.addContent(descr2);
						item2.addContent(percDesc2);
						// item2.addContent(vlrDesc2);
						item2.addContent(vlrUnit2);
						item2.addContent(qtdNeg2);
						item2.addContent(controle2);
						item2.addContent(codLocalOrig2);
						item2.addContent(codVol2);
						item2.addContent(codProd2);
						item2.addContent(sequencia2);
						item2.addContent(nunotaIte2);
						itens.addContent(item2);

					// Servico Encomendado
					} else if (obj.getGrau() == 2) {

						Provider provider = new Provider();

						Element item2 = new Element("item");

						Element nunotaIte2 = new Element("NUNOTA");
						Element sequencia2 = new Element("SEQUENCIA");

						Element codProd2 = new Element("CODPROD");

						switch (obj.getSubTipo()) {
							case executiveProd:
								codProd2.setText("665");
								break;
							case eletronicProd:
								codProd2.setText("664");
								break;
							case graphicProd:
								codProd2.setText("663");
								break;
							case digitalProd:
								codProd2.setText("666");
								break;
						}

						Element codVol2 = new Element("CODVOL");
						codVol2.setText("UN");

						Element codLocalOrig2 = new Element("CODLOCALORIG");
						codLocalOrig2.setText("0");

						Element controle2 = new Element("CONTROLE");

						Element qtdNeg2 = new Element("QTDNEG");

						if (obj.getQuantidadeUnitaria() != 0) {
							qtdNeg2.setText(Integer.toString(obj.getQuantidade() * obj.getQuantidadeUnitaria()));
						} else {
							qtdNeg2.setText(Integer.toString(obj.getQuantidade()));
						}

						Element vlrUnit2 = new Element("VLRUNIT");
						vlrUnit2.setText(Double.toString(obj.getValorUnitario()));

						//Levava em consideração o valor de desconto
						/*
						 * Element vlrDesc2 = new Element("VLRDESC");
						 * vlrDesc2.setText(Double.toString((obj.
						 * getValorUnitario() / 100) * obj.getDesconto()));
						 */

						Element percDesc2 = new Element("PERCDESC");
						percDesc2.setText(Double.toString(obj.getDesconto()));

						if (service instanceof PubliAmplaServiceHelper) {
							nf = new PubliAmplaServiceHelper().GetProviderNF(obj.getPedido());
						} else if (service instanceof PubliBg9PEServiceHelper) {
							nf = new PubliBg9PEServiceHelper().GetProviderNF(obj.getPedido());
						} else {
							nf = new PubliBg9ALServiceHelper().GetProviderNF(obj.getPedido());
						}

						if (service instanceof PubliAmplaServiceHelper) {
							provider = new PubliAmplaServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						} else if (service instanceof PubliBg9PEServiceHelper) {
							provider = new PubliBg9PEServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						} else {
							provider = new PubliBg9ALServiceHelper().GetProviderById(obj.getCodigoFornecedor());
						}

						Element notaF = new Element("AD_NOTA");
						notaF.setText(Utils.removeInvalidXMLCharacters(Utils.RemoveSpecialCharacters(nf))
								.replaceAll("[^\\d.]", ""));

						Element codFor = new Element("AD_CODFORN");
						codFor.setText(
								JivaServiceHelper.GetCustomerIdByCNPJ(Utils.RemoveSpecialCharacters(provider.getCnpj()),
										cookie, Integer.toString(provider.getCodigo())));

						Element descFor = new Element("AD_FORNECEDOR");
						descFor.setText(JivaServiceHelper.GetCustomerNameById(
								JivaServiceHelper.GetCustomerIdByCNPJ(Utils.RemoveSpecialCharacters(provider.getCnpj()),
										cookie, Integer.toString(provider.getCodigo())),
								cookie));

						Element tipo2 = new Element("TIPO");
						tipo2.setText(budget.getSubTipo());

						Element descr2 = new Element("OBSERVACAO");
						descr2.setText("CAMPANHA: " + budget.getCampanha() + "\nNOME DO FORNECEDOR: "
								+ obj.getNomeFornecedor() + "\nNOTA FISCAL DO FORNECEDOR: " + nf + "\nCNPJ: "
								+ provider.getCnpj() + "\nDESCRICAO: " + obj.getDescricao().replace("<br>", " ")
								+ "\nPP: " + obj.getPedido());

						item2.addContent(descr2);
						item2.addContent(tipo2);
						item2.addContent(descFor);
						item2.addContent(codFor);
						item2.addContent(percDesc2);
						item2.addContent(notaF);
						item2.addContent(vlrUnit2);
						item2.addContent(qtdNeg2);
						item2.addContent(controle2);
						item2.addContent(codLocalOrig2);
						item2.addContent(codVol2);
						item2.addContent(codProd2);
						item2.addContent(sequencia2);
						item2.addContent(nunotaIte2);
						itens.addContent(item2);

					}
				}

			}

			if (budget.getHonorarios() != 0) {
				item.addContent(descr);
				item.addContent(percDesc);
				item.addContent(vlrUnit);
				item.addContent(qtdNeg);
				item.addContent(controle);
				item.addContent(codLocalOrig);
				item.addContent(codVol);
				item.addContent(codProd);
				item.addContent(sequencia);
				item.addContent(nunotaIte);
				itens.addContent(item);
			}

			cabecalho.addContent(sFrete);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(numNota);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			//System.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return doc;
		}

	}

	/**
	 * Monta XML para inserir um Pedido de Produção no Jiva
	 * 
	 * @param order
	 * @return
	 */
	public static Document MountXMLToInsertProductionOrder(ProductionOrder order, String fornId, String tipoFat,
			String customerId) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertOrderService));
		Document doc = new Document(request);

		String codCenCus = JivaServiceHelper.GetCustomerCostCenterById(customerId);

		try {

			// Body
			Element body = new Element("requestBody");
			// nota
			Element nota = new Element("nota");
			// cabecalho
			Element cabecalho = new Element("cabecalho");
			// campos cabecalho

			Element nunota = new Element("NUNOTA");

			Element status = new Element("STATUSNOTA");
			status.setText("L");

			Element numNota = new Element("AD_NUMNOTAFORN");
			numNota.setText(Utils.RemoveSpecialCharacters(order.getNotaFiscalFornecedor().replaceAll("[^0-9]", "")));

			Element numOc = new Element("NUMNOTA");
			numOc.setText(Integer.toString(order.getOrcamento()));

			Element centRes = new Element("CODCENCUS");

			if (codCenCus == null || codCenCus.isEmpty()) {
				centRes.setText("9900000");
			} else {
				centRes.setText(codCenCus);
			}

			Element natureza = new Element("CODNAT");
			natureza.setText("80101001");
			Element tipMov = new Element("TIPMOV");
			tipMov.setText("C");
			Element dtNeg = new Element("DTNEG");
			dtNeg.setText(Utils.ConvertMSJSONDateToDate(order.getDataManutencao()));// Utils.ConvertMSJSONDateToDate(order.getDataInclusao()));
			Element codTipVen = new Element("CODTIPVENDA");
			codTipVen.setText("400");
			Element codParc = new Element("CODPARC");
			codParc.setText(fornId);
			Element tipOper = new Element("CODTIPOPER");

			if (tipoFat.equals("2")) {
				tipOper.setText("307");
			} else {
				tipOper.setText("306");
			}

			Element codEmp = new Element("CODEMP");
			codEmp.setText(Integer.toString(order.getEmpresa()));
			Element codVen = new Element("CODVEN");
			codVen.setText("1");
			Element obs = new Element("AD_OBSERVACAOPEDIDO");
			obs.setText("CAMPANHA: " + order.getCampanha() + "\r\nSERVICO: " + order.getServico() + "\r\nDESCRICAO: "
					+ order.getDescricao() + "\r\nORCAMENTO: " + order.getOrcamento()
					+ "\r\nPedido incluido via integração.");

			// itens
			Element itens = new Element("itens");
			itens.setAttribute(new Attribute("INFORMARPRECO", "True"));

			// item
			Element item = new Element("item");

			Element nunotaIte = new Element("NUNOTA");
			Element sequencia = new Element("SEQUENCIA");
			Element codProd = new Element("CODPROD");
			
			switch (order.getSubTipo()) {
				case executiveProd:
					codProd.setText("665");
					break;
				case eletronicProd:
					codProd.setText("664");
					break;
				case graphicProd:
					codProd.setText("663");
					break;
				default:
					codProd.setText("666");
					break;
			}

			Element codVol = new Element("CODVOL");
			codVol.setText("UN");
			Element codLocalOrig = new Element("CODLOCALORIG");
			codLocalOrig.setText("0");
			Element controle = new Element("CONTROLE");
			Element qtdNeg = new Element("QTDNEG");
			qtdNeg.setText("1");
			Element vlrUnit = new Element("VLRUNIT");
			vlrUnit.setText(Double.toString(order.getValorLiquido()));
			Element percDesc = new Element("PERCDESC");
			percDesc.setText("0.00");

			Element codFor = new Element("AD_CODFORN");
			codFor.setText(fornId);

			Element descFor = new Element("AD_FORNECEDOR");
			descFor.setText(order.getNomeFornecedor());

			Element numNfEmi = new Element("AD_DTEMISSAO");
			numNfEmi.setText(Utils.ConvertMSJSONDateToDate(order.getNfEmissao()));

			Element venc = new Element("AD_DTVENCIMENTO");
			venc.setText(Utils.ConvertMSJSONDateToDate(order.getVencimento()));

			item.addContent(venc);
			item.addContent(numNfEmi);
			item.addContent(codFor);
			item.addContent(descFor);
			item.addContent(percDesc);
			item.addContent(vlrUnit);
			item.addContent(qtdNeg);
			item.addContent(controle);
			item.addContent(codLocalOrig);
			item.addContent(codVol);
			item.addContent(codProd);
			item.addContent(sequencia);
			item.addContent(nunotaIte);
			itens.addContent(item);
			cabecalho.addContent(obs);
			cabecalho.addContent(codVen);
			cabecalho.addContent(codEmp);
			cabecalho.addContent(tipOper);
			cabecalho.addContent(numOc);
			cabecalho.addContent(status);
			cabecalho.addContent(numNota);
			cabecalho.addContent(nunota);
			cabecalho.addContent(centRes);
			cabecalho.addContent(natureza);
			cabecalho.addContent(codParc);
			cabecalho.addContent(codTipVen);
			cabecalho.addContent(dtNeg);
			cabecalho.addContent(tipMov);

			nota.addContent(cabecalho);
			nota.addContent(itens);
			body.addContent(nota);
			doc.getRootElement().addContent(body);

			System.out.println(new XMLOutputter().outputString(doc));

			return doc;

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return doc;
		}
	}

	/**
	 * Monta XML para verificar se um Parceiro existe pelo CNPJ
	 * 
	 * @param cnpj
	 * @return
	 */
	public static Document MountXMLToVerifyIfCustomerExists(String cnpj, String codPubli) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "CODPARC"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.CGC_CPF = '" + cnpj + "' AND this.AD_CODPUBLI = " + codPubli);

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;
	}

	public static Document MountXMLToGetPartnerNameById(String id) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "NOMEPARC"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.CODPARC = " + id);

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;
	}

	public static String GetPartnerName(org.w3c.dom.Document doc) {

		String name = "";

		NodeList nList = doc.getElementsByTagName("entity");

		for (int i = 0; i < nList.getLength(); i++) {

			Node node = nList.item(i);
			org.w3c.dom.Element element = (org.w3c.dom.Element) node;

			name = element.getElementsByTagName("f0").item(0).getTextContent();
		}

		return name;
	}

	/**
	 * Verifica nos elementos do XML retornado se o parceiro existe ou não
	 * 
	 * @param doc
	 * @return true/false
	 */
	public static boolean CustomerExists(org.w3c.dom.Document doc) {

		String pk = "";
		boolean exists = false;

		NodeList nList = doc.getElementsByTagName("entity");

		for (int i = 0; i < nList.getLength(); i++) {

			Node node = nList.item(i);
			org.w3c.dom.Element element = (org.w3c.dom.Element) node;

			pk = element.getElementsByTagName("f0").item(0).getTextContent();
		}

		if (pk == null || pk.isEmpty()) {
			exists = false;
		} else {
			exists = true;
		}

		return exists;
	}

	/**
	 * Pega nos elementos do XML retornado o Id do Parceiro
	 * 
	 * @param doc
	 * @return
	 */
	public static String GetCustomerId(org.w3c.dom.Document doc) {

		String pk = "";

		try {

			NodeList nList = doc.getElementsByTagName("entity");

			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);
				org.w3c.dom.Element element = (org.w3c.dom.Element) node;

				pk = element.getElementsByTagName("f0").item(0).getTextContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pk;
	}

	/**
	 * Monta XML para pegar Endereço completo
	 * 
	 * @param cep
	 * @return
	 */
	public static Document MountXMLToGetAddress(String cep) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "CEP"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "CEP, CODEND, CODBAI, CODCID"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.CEP = " + cep);

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;
	}

	/**
	 * Serializa XML retornado do Jiva na classe Address
	 * 
	 * @param doc
	 * @return
	 */
	public static Address GetAddressCodes(org.w3c.dom.Document doc) {

		Address obj = new Address();

		try {

			NodeList nList = doc.getElementsByTagName("entity");

			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);
				org.w3c.dom.Element element = (org.w3c.dom.Element) node;

				obj.setCep(element.getElementsByTagName("f0").item(0).getTextContent());
				obj.setCodEnd(element.getElementsByTagName("f1").item(0).getTextContent());
				obj.setCodBai(element.getElementsByTagName("f2").item(0).getTextContent());
				obj.setCodCid(element.getElementsByTagName("f3").item(0).getTextContent());
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return obj;
	}

	/**
	 * Monta XML para atualizar Parceiro do tipo Cliente
	 * 
	 * @param obj
	 * @param pk
	 * @return
	 */
	public static Document MountXMLToUpdateCustomer(Customer obj, String pk) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "*"));

		// criteria
		Element dataRow = new Element("dataRow");

		// expression
		Element localFields = new Element("localFields");

		Element nome = new Element("NOMEPARC");
		nome.setText(obj.getNome());
		Element cliente = new Element("CLIENTE");
		cliente.setText("S");
		Element fornecedor = new Element("FORNECEDOR");
		fornecedor.setText("S");
		Element tipPessoa = new Element("TIPPESSOA");
		tipPessoa.setText("J");
		Element razaoSocial = new Element("RAZAOSOCIAL");
		razaoSocial.setText(obj.getNome());
		Element cep = new Element("CEP");
		cep.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCep()));
		Element telefone = new Element("TELEFONE");
		telefone.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getTelefone()));
		// Element email = new Element("EMAIL");
		// email.setText(obj.getEmail());
		Element inscEstadual = new Element("IDENTINSCESTAD");
		if (obj.getInscricaoEstadual() == null || obj.getInscricaoEstadual().isEmpty()
				|| obj.getInscricaoEstadual().contains("ISEN")) {
			inscEstadual.setText("ISENTO");
		} else {
			inscEstadual.setText(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoEstadual()).toUpperCase());
		}
		Element inscMunicipal = new Element("INSCMUN");
		inscMunicipal.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoMunicipal()));
		Element cnpj = new Element("CGC_CPF");
		cnpj.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCnpj()));
		Element ativo = new Element("ATIVO");
		ativo.setText("S");
		Element usuario = new Element("USUARIO");
		usuario.setText("N");
		Element bloquear = new Element("BLOQUEAR");
		bloquear.setText("N");
		Element obs = new Element("OBSERVACOES");
		obs.setText("Parceiro atualizado via integração");

		// chave para update
		Element key = new Element("key");

		Element nsu = new Element("CODPARC");
		nsu.setText(pk);

		localFields.addContent(fornecedor);
		// localFields.addContent(obs);
		// localFields.addContent(bloquear);
		// localFields.addContent(ativo);
		// localFields.addContent(cnpj);
		// localFields.addContent(inscMunicipal);
		// localFields.addContent(inscEstadual);
		// localFields.addContent(email);
		// localFields.addContent(telefone);
		// localFields.addContent(cep);
		// localFields.addContent(razaoSocial);
		// localFields.addContent(tipPessoa);
		localFields.addContent(cliente);
		// localFields.addContent(nome);
		key.addContent(nsu);
		dataRow.addContent(localFields);
		dataRow.addContent(key);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(dataRow);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		// System.out.println(new XMLOutputter().outputString(doc));

		return doc;
	}

	/**
	 * Monta XML para inserir Parceiro do tipo Cliente
	 * 
	 * @param obj
	 * @param address
	 * @return
	 */
	public static Document MountXMLToInsertCustomer(Customer obj, Address address, String codPub) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "*"));

		// criteria
		Element dataRow = new Element("dataRow");

		// expression
		Element localFields = new Element("localFields");

		Element nome = new Element("NOMEPARC");
		nome.setText(obj.getNome());
		Element cliente = new Element("CLIENTE");
		cliente.setText("S");
		Element fornecedor = new Element("FORNECEDOR");
		fornecedor.setText("S");
		Element tipPessoa = new Element("TIPPESSOA");
		tipPessoa.setText("J");
		Element razaoSocial = new Element("RAZAOSOCIAL");
		razaoSocial.setText(obj.getNome());
		Element cep = new Element("CEP");
		cep.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCep()));
		Element codEnd = new Element("CODEND");
		codEnd.setText(address.getCodEnd());
		Element codBai = new Element("CODBAI");
		codBai.setText(address.getCodBai());
		Element codCid = new Element("CODCID");
		codCid.setText(address.getCodCid());
		Element telefone = new Element("TELEFONE");
		telefone.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getTelefone()));
		// Element email = new Element("EMAIL");
		// email.setText(obj.getEmail());
		Element inscEstadual = new Element("IDENTINSCESTAD");
		if (obj.getInscricaoEstadual() == null || obj.getInscricaoEstadual().isEmpty()
				|| obj.getInscricaoEstadual().contains("ISEN")) {
			inscEstadual.setText("ISENTO");
		} else {
			inscEstadual.setText(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoEstadual()).toUpperCase());
		}
		Element inscMunicipal = new Element("INSCMUN");
		inscMunicipal.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoMunicipal()));
		Element cnpj = new Element("CGC_CPF");
		cnpj.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCnpj()));
		Element ativo = new Element("ATIVO");
		ativo.setText("S");
		Element usuario = new Element("USUARIO");
		usuario.setText("N");
		Element bloquear = new Element("BLOQUEAR");
		bloquear.setText("N");
		Element centroCusto = new Element("AD_CODCENCUS");
		centroCusto.setText("9900000");
		Element codPubli = new Element("AD_CODPUBLI");
		codPubli.setText(codPub);

		Element obs = new Element("OBSERVACOES");
		obs.setText("Parceiro incluído via integração");

		localFields.addContent(obs);
		localFields.addContent(codPubli);
		localFields.addContent(centroCusto);
		localFields.addContent(bloquear);
		localFields.addContent(ativo);
		localFields.addContent(cnpj);
		localFields.addContent(inscMunicipal);
		localFields.addContent(inscEstadual);
		// localFields.addContent(email);
		// localFields.addContent(telefone);
		localFields.addContent(codCid);
		localFields.addContent(codBai);
		localFields.addContent(codEnd);
		localFields.addContent(cep);
		localFields.addContent(razaoSocial);
		localFields.addContent(tipPessoa);
		localFields.addContent(fornecedor);
		localFields.addContent(cliente);
		localFields.addContent(nome);
		dataRow.addContent(localFields);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(dataRow);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		// System.out.println(new XMLOutputter().outputString(doc));

		return doc;
	}

	/**
	 * Monta XML para atualizar Parceiro do tipo Fornecedor
	 * 
	 * @param obj
	 * @param pk
	 * @return
	 */
	public static Document MountXMLToUpdateProvider(Provider obj, String pk) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "*"));

		// criteria
		Element dataRow = new Element("dataRow");

		// expression
		Element localFields = new Element("localFields");

		Element nome = new Element("NOMEPARC");
		nome.setText(obj.getNome());
		Element fornecedor = new Element("FORNECEDOR");
		fornecedor.setText("S");
		Element tipPessoa = new Element("TIPPESSOA");
		tipPessoa.setText("J");
		Element razaoSocial = new Element("RAZAOSOCIAL");
		razaoSocial.setText(obj.getNome());
		Element cep = new Element("CEP");
		cep.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCep()));
		Element telefone = new Element("TELEFONE");
		telefone.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getTelefone()));
		Element email = new Element("EMAIL");
		email.setText(obj.getEmail());
		Element inscEstadual = new Element("IDENTINSCESTAD");
		if (obj.getInscricaoEstadual() == null || obj.getInscricaoEstadual().isEmpty()
				|| obj.getInscricaoEstadual().contains("ISEN")) {
			inscEstadual.setText("ISENTO");
		} else {
			inscEstadual.setText(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoEstadual()).toUpperCase());
		}
		Element inscMunicipal = new Element("INSCMUN");
		inscMunicipal.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoMunicipal()));
		Element cnpj = new Element("CGC_CPF");
		cnpj.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCnpj()));
		Element ativo = new Element("ATIVO");
		ativo.setText("S");
		Element usuario = new Element("USUARIO");
		usuario.setText("N");
		Element bloquear = new Element("BLOQUEAR");
		bloquear.setText("N");

		Element codBco = new Element("CODBCO");
		if (obj.getBancoPagamento() != null && !obj.getBancoPagamento().isEmpty()) {
			codBco.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getBancoPagamento()));
		} else {
			codBco.setText("0");
		}

		Element agencia = new Element("CODAGE");
		if (obj.getAgenciaPagamento() != null && !obj.getAgenciaPagamento().isEmpty()) {
			agencia.setText(br.com.sankhya.common.Utils
					.RemoveLeftZeros(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getAgenciaPagamento())));
		} else {
			agencia.setText("0");
		}

		Element codConta = new Element("CODCTABCO");
		if (obj.getContaCorrentePagamento() != null && !obj.getContaCorrentePagamento().isEmpty()) {
			codConta.setText(br.com.sankhya.common.Utils.RemoveLeftZeros(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getContaCorrentePagamento())));
		} else {
			codConta.setText("0");
		}

		Element obs = new Element("OBSERVACOES");
		obs.setText("Parceiro atualizado via integração");

		// chave para update
		Element key = new Element("key");

		Element nsu = new Element("CODPARC");
		nsu.setText(pk);

		// localFields.addContent(obs);
		// localFields.addContent(codConta);
		// localFields.addContent(agencia);
		// localFields.addContent(codBco);
		// localFields.addContent(bloquear);
		// localFields.addContent(ativo);
		// localFields.addContent(cnpj);
		// localFields.addContent(inscMunicipal);
		// localFields.addContent(inscEstadual);
		// localFields.addContent(email);
		// localFields.addContent(telefone);
		// localFields.addContent(cep);
		// localFields.addContent(razaoSocial);
		// localFields.addContent(tipPessoa);
		localFields.addContent(fornecedor);
		// localFields.addContent(nome);
		key.addContent(nsu);
		dataRow.addContent(localFields);
		dataRow.addContent(key);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(dataRow);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		// System.out.println(new XMLOutputter().outputString(doc));

		return doc;
	}

	/**
	 * Monta XML para inserir Parceiro do tipo Fornecedor
	 * 
	 * @param obj
	 * @param address
	 * @return
	 */
	public static Document MountXMLToInsertProvider(Provider obj, Address address, String codPub) {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", insertService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "*"));

		// criteria
		Element dataRow = new Element("dataRow");

		// expression
		Element localFields = new Element("localFields");

		Element nome = new Element("NOMEPARC");
		nome.setText(obj.getNome());
		Element fornecedor = new Element("FORNECEDOR");
		fornecedor.setText("S");
		Element tipPessoa = new Element("TIPPESSOA");
		tipPessoa.setText("J");
		Element razaoSocial = new Element("RAZAOSOCIAL");
		razaoSocial.setText(obj.getNome());
		Element cep = new Element("CEP");
		cep.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCep()));
		Element codEnd = new Element("CODEND");
		codEnd.setText(address.getCodEnd());
		Element codBai = new Element("CODBAI");
		codBai.setText(address.getCodBai());
		Element codCid = new Element("CODCID");
		codCid.setText(address.getCodCid());
		// Element telefone = new Element("TELEFONE");
		// telefone.setText(Utils.RemoveSpecialCharacters(obj.getTelefone()));
		// Element email = new Element("EMAIL");
		// email.setText(obj.getEmail());
		Element inscEstadual = new Element("IDENTINSCESTAD");
		if (obj.getInscricaoEstadual() == null || obj.getInscricaoEstadual().isEmpty()
				|| obj.getInscricaoEstadual().contains("ISEN")) {
			inscEstadual.setText("ISENTO");
		} else {
			inscEstadual.setText(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoEstadual()).toUpperCase());
		}
		Element inscMunicipal = new Element("INSCMUN");
		inscMunicipal.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getInscricaoMunicipal()));
		Element cnpj = new Element("CGC_CPF");
		cnpj.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getCnpj()));
		Element ativo = new Element("ATIVO");
		ativo.setText("S");
		Element usuario = new Element("USUARIO");
		usuario.setText("N");
		Element bloquear = new Element("BLOQUEAR");
		bloquear.setText("N");
		Element centroCusto = new Element("AD_CODCENCUS");
		centroCusto.setText("9900000");

		Element codBco = new Element("CODBCO");
		if (obj.getBancoPagamento() != null && !obj.getBancoPagamento().isEmpty()) {
			codBco.setText(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getBancoPagamento()));
		} else {
			codBco.setText("0");
		}

		Element agencia = new Element("CODAGE");
		if (obj.getAgenciaPagamento() != null && !obj.getAgenciaPagamento().isEmpty()) {
			agencia.setText(br.com.sankhya.common.Utils
					.RemoveLeftZeros(br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getAgenciaPagamento())));
		} else {
			agencia.setText("0");
		}

		Element codConta = new Element("CODCTABCO");
		if (obj.getContaCorrentePagamento() != null && !obj.getContaCorrentePagamento().isEmpty()) {
			codConta.setText(br.com.sankhya.common.Utils.RemoveLeftZeros(
					br.com.sankhya.common.Utils.RemoveSpecialCharacters(obj.getContaCorrentePagamento())));
		} else {
			codConta.setText("0");
		}

		Element codPubli = new Element("AD_CODPUBLI");
		codPubli.setText(codPub);
		Element obs = new Element("OBSERVACOES");
		obs.setText("Parceiro incluído via integração");

		localFields.addContent(obs);
		localFields.addContent(codPubli);
		localFields.addContent(codConta);
		localFields.addContent(agencia);
		localFields.addContent(codBco);
		localFields.addContent(centroCusto);
		localFields.addContent(bloquear);
		localFields.addContent(ativo);
		localFields.addContent(cnpj);
		localFields.addContent(inscMunicipal);
		localFields.addContent(inscEstadual);
		// localFields.addContent(email);
		// localFields.addContent(telefone);
		localFields.addContent(codCid);
		localFields.addContent(codBai);
		localFields.addContent(codEnd);
		localFields.addContent(cep);
		localFields.addContent(razaoSocial);
		localFields.addContent(tipPessoa);
		localFields.addContent(fornecedor);
		localFields.addContent(nome);
		dataRow.addContent(localFields);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(dataRow);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		// System.out.println(new XMLOutputter().outputString(doc));

		return doc;
	}

	public static Document MountXMLToGetCustomerCostCenter(String id) {
		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Parceiro"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "AD_CODCENCUS"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.CODPARC = " + id);

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;
	}

	public static String GetCostCenterId(org.w3c.dom.Document doc) {

		String pk = "";

		try {

			NodeList nList = doc.getElementsByTagName("entity");

			for (int i = 0; i < nList.getLength(); i++) {

				Node node = nList.item(i);
				org.w3c.dom.Element element = (org.w3c.dom.Element) node;

				pk = element.getElementsByTagName("f0").item(0).getTextContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pk;
	}

	public static Document MountXMLToGetInvoicedOrders() {

		// RootElement
		Element request = new Element("serviceRequest");
		request.setAttribute(new Attribute("serviceName", loadService));
		Document doc = new Document(request);

		// Body
		Element body = new Element("requestBody");

		// DataSet
		Element dataSet = new Element("dataSet");
		dataSet.setAttribute(new Attribute("rootEntity", "Cabecalho"));
		dataSet.setAttribute(new Attribute("includePresentationFields", "S"));
		dataSet.setAttribute(new Attribute("parallelLoader", "false"));
		dataSet.setAttribute(new Attribute("disableRowsLimit", "true"));

		// entity
		Element entity = new Element("entity");
		entity.setAttribute(new Attribute("path", ""));

		// fieldSet
		Element fieldSet = new Element("fieldset");
		fieldSet.setAttribute(new Attribute("list", "NUMNOTA"));

		// criteria
		Element criteria = new Element("criteria");

		// expression
		Element expression = new Element("expression");
		expression.setText("this.CODPARC = ");

		criteria.addContent(expression);
		entity.addContent(fieldSet);
		dataSet.addContent(entity);
		dataSet.addContent(criteria);
		body.addContent(dataSet);
		doc.getRootElement().addContent(body);

		return doc;

	}

	/**
	 * Converte um org.w3c.dom.Document (XMl) em uma String
	 * 
	 * @param doc
	 * @return XMl no formato String
	 */
	public static String getStringFromDoc(org.w3c.dom.Document doc) {
		DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
		LSSerializer lsSerializer = domImplementation.createLSSerializer();
		return lsSerializer.writeToString(doc);
	}

}