package br.com.sankhya.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Node;

import br.com.sankhya.common.Base64Utils;
import br.com.sankhya.common.Utils;
import br.com.sankhya.common.XmlHelper;
import br.com.sankhya.domain.Address;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.MediaOrderInstallment;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;

public class JivaServiceHelper {

	private static final String loginService = "http://jiva.grupoduca.com.br:8180/mge/service.sbr?serviceName=MobileLoginSP.login";
	private static final String insertService = "http://jiva.grupoduca.com.br:8180/mge/service.sbr?serviceName=CRUDServiceProvider.saveRecord";
	private static final String loadService = "http://jiva.grupoduca.com.br:8180/mge/service.sbr?serviceName=CRUDServiceProvider.loadRecords";
	private static final String includeOrder = "http://jiva.grupoduca.com.br:8180/mgecom/service.sbr?serviceName=CACSP.incluirNota&mgeSession=";

	private static final boolean producao = false;
	
	private static String getURLEnviroment(String url) {
		return producao ? url : url.replace(":8180/", ":8380/");
	}

	/**
	 * 
	 * @return Token do Jiva
	 */
	public static String LogIn() {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = br.com.sankhya.common.XmlHelper.MountLogInRequest();

			URL url = new URL(getURLEnviroment(loginService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			return document.getElementsByTagName("jsessionid").item(0).getTextContent();

		} catch (Throwable e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	/**
	 * Verifica se o Pedido existe.
	 * 
	 * @param numNota
	 * @param cookie
	 * @param parcela 
	 * @return true/false se o Pedido existe ou não
	 */
	public static boolean VerifyIfOrderExistsByNUMNOTA(String numNota, String cookie, String tipMov, int codEmp, String complemento) {

		boolean exists = false;

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToVerifyIfOrderExists(numNota, tipMov, codEmp, complemento );

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			exists = XmlHelper.OrderExists(document);

			//System.out.println(XmlHelper.getStringFromDoc(document));

			return exists;

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return exists;
	}

	/**
	 * 
	 * 
	 * /** Insere Pedidos de Mídia no Jiva
	 * 
	 * @param order
	 * @param cookie
	 */
	public static void InsertMediaOrder(MediaOrder order, String cookie, String fornId, int tipoFat,
			String customerId) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToInsertMediaOrder(order, customerId, tipoFat, customerId);

			URL url = new URL(getURLEnviroment(includeOrder) + cookie);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere Pedidos de Prodição no Jiva
	 * 
	 * @param order
	 * @param cookie
	 */
	public static void InsertProductionOrder(ProductionOrder order, String cookie, String fornId, String tipoFat,
			String customerId) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToInsertProductionOrder(order, fornId, tipoFat, customerId);

			URL url = new URL(getURLEnviroment(includeOrder) + cookie);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere OCs (Producao)
	 * 
	 * @param budget
	 * @param cookie
	 * @param customerId
	 */
	public static void InsertFixedBudget(FixedBudget budget, String cookie, String customerId, Object service) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToInsertFixedBudget(budget, customerId, service, cookie);
			
			URL url = new URL(getURLEnviroment(includeOrder) + cookie);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			Node itemNuNota = document.getElementsByTagName("NUNOTA").item(0);
			String nuNota = itemNuNota != null ? itemNuNota.getTextContent() : null;
			
			if (nuNota == null || nuNota.isEmpty()) {
				String erro = document.getElementsByTagName("statusMessage").item(0).getTextContent();
				System.out.println("Não foi possível importar a OC " + budget.getNumero() + ": " + Base64Utils.decode(erro));
			} else {
				System.out.println("OC " + budget.getNumero() + " importada com sucesso! Nro Unico: " + nuNota + " Série '"+budget.getComplemento()+"'");
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verifica se cliente existe pelo CNPJ
	 * 
	 * @param cnpj
	 * @param cookie
	 * @return true/false
	 */
	public static boolean VerifyIfCustomerExistsByCNPJ(String cnpj, String cookie, String codPubli) {

		boolean exists = false;

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToVerifyIfCustomerExists(cnpj, codPubli);

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			exists = XmlHelper.CustomerExists(document);

			// System.out.println(XmlHelper.getStringFromDoc(document));

			return exists;

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return exists;
	}

	/**
	 * 
	 * @param cnpj
	 * @param cookie
	 * @return Id do Cliente no Jiva
	 */
	public static String GetCustomerIdByCNPJ(String cnpj, String cookie, String codPubli) {

		String id = "";

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToVerifyIfCustomerExists(cnpj, codPubli);

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			id = XmlHelper.GetCustomerId(document);

			//System.out.println(XmlHelper.getStringFromDoc(document));

			return id;

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return id;
	}

	public static String GetCustomerNameById(String id, String cookie) {

		String name = "";

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToGetPartnerNameById(id);

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			name = XmlHelper.GetCustomerId(document);

			return name;

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return name;
	}

	/**
	 * Pesquisa o enereço pelo CEP
	 * 
	 * @param cep
	 * @param cookie
	 * @return Endereço completo do Jiva
	 */
	public static Address GetAddressCodesByCEP(String cep, String cookie) {

		Address obj = new Address();

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToGetAddress(cep);

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			obj = XmlHelper.GetAddressCodes(document);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;

	}

	/**
	 * Atualiza Cliente no Jiva
	 * 
	 * @param customer
	 * @param customerId
	 * @param cookie
	 */
	public static void UpdateCustomer(Customer customer, String customerId, String cookie) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToUpdateCustomer(customer, customerId);

			URL url = new URL(getURLEnviroment(insertService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

//			InputStream resStream = con.getInputStream();
//			org.w3c.dom.Document document = builder.parse(resStream);

			// System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere Cliente no Jiva
	 * 
	 * @param customer
	 * @param cookie
	 */
	public static void InsertCustomer(Customer customer, String cookie, String codPubli) {

		try {
			Document doc;
			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Address address = GetAddressCodesByCEP(Utils.RemoveSpecialCharacters(customer.getCep()), cookie);

			if (address.getCodCid() == null || address.getCodCid().isEmpty()) {
				Address address2 = new Address();
				address2.setCep(null);
				address2.setCodCid("5573");
				address2.setCodBai(null);
				address2.setCodEnd(null);

				doc = XmlHelper.MountXMLToInsertCustomer(customer, address2, codPubli);
			} else {

				doc = XmlHelper.MountXMLToInsertCustomer(customer, address, codPubli);
			}

			URL url = new URL(getURLEnviroment(insertService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

            if(!wasSuccessful(document)){
	            	String motivo = document.getElementsByTagName("statusMessage").item(0).getTextContent();
	            	
	            	System.out.println("Não foi possível adicionar o cliente: " + customer.getNome() +  " ao Jiva. Deverá ser adicionado manualmente.");
				System.out.println("Motivo: " + Base64Utils.decode(motivo));
            }

//			 System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere Fornecedor no Jiva
	 * 
	 * @param provider
	 * @param cookie
	 */
	public static void InsertProvider(Provider provider, String cookie, String codPubli) {

		try {
			Document doc = null;

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Address address = GetAddressCodesByCEP(Utils.RemoveSpecialCharacters(provider.getCep()), cookie);

			if (address.getCodCid() == null || address.getCodCid().isEmpty()) {
				Address address2 = new Address();
				address2.setCep(null);
				address2.setCodCid("5573");
				address2.setCodBai(null);
				address2.setCodEnd(null);

				doc = XmlHelper.MountXMLToInsertProvider(provider, address2, codPubli);
			} else {
				doc = XmlHelper.MountXMLToInsertProvider(provider, address, codPubli);
			}

			URL url = new URL(getURLEnviroment(insertService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

            if(!wasSuccessful(document)){
            		String motivo = document.getElementsByTagName("statusMessage").item(0).getTextContent();

            		System.out.println("Não foi possível adicionar o fornecedor: " + provider.getNome() +  " ao Jiva. Deverá ser adicionado manualmente.");
            		System.out.println("Motivo: " + Base64Utils.decode(motivo));
            }

			// System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Atualiza Fornecedor no Jiva
	 * 
	 * @param provider
	 * @param providerId
	 * @param cookie
	 */
	public static void UpdateProvider(Provider provider, String providerId, String cookie) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToUpdateProvider(provider, providerId);

			URL url = new URL(getURLEnviroment(insertService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

//			InputStream resStream = con.getInputStream();
//			org.w3c.dom.Document document = builder.parse(resStream);

			// System.out.println(XmlHelper.getStringFromDoc(document));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public static String GetCustomerCostCenterById(String id) {

		String cod = "";

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = XmlHelper.MountXMLToGetCustomerCostCenter(id);

			URL url = new URL(getURLEnviroment(loadService));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + LogIn());
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			cod = XmlHelper.GetCostCenterId(document);

			return cod;

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return cod;
	}

	public static void InsertPublicationAuth(MediaOrder order, String cookie, String customerId, String providerId,
			String providerCNPJ, MediaOrderInstallment parcela) {

		try {

			XMLOutputter xmlOutput = new XMLOutputter();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = XmlHelper.MountXMLToInsertPublicationAuth( order, 
					                                                  customerId, 
					                                                  providerId, 
					                                                  providerCNPJ,
					                                                  cookie,
					                                                  parcela );

			URL url = new URL(getURLEnviroment(includeOrder) + cookie);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "JSESSIONID=" + cookie);
			con.setRequestProperty("Content-type", "text/xml; charset=ISO-8859-1");

			OutputStream reqStream = con.getOutputStream();
			reqStream.write(xmlOutput.outputString(doc).getBytes("UTF-8"));

			InputStream resStream = con.getInputStream();
			org.w3c.dom.Document document = builder.parse(resStream);

			Node itemNuNota = document.getElementsByTagName("NUNOTA").item(0);
			String nuNota = itemNuNota != null ? itemNuNota.getTextContent() : null;
			if (nuNota == null || nuNota.isEmpty()) {
				String erro = document.getElementsByTagName("statusMessage").item(0).getTextContent();
				System.out.println("Não foi possível importar a MÍDIA " + order.getPlanilhaNumero() + ": " + Base64Utils.decode(erro));
			} else {
				System.out.println("MÍDIA " + order.getPlanilhaNumero() + " importada com sucesso. Nro Unico: " + nuNota + " Série '" + parcela.getComplemento() + "'.");
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}


	public static boolean wasSuccessful(org.w3c.dom.Document doc){

		try {
			
			String added = doc.getElementsByTagName("CODPARC").item(0).getTextContent();

			if(added != null && !added.isEmpty()){
				return true;
			}else{
				return false;
			}

		} catch (Exception ex){
			return false;
		}

	}

}
