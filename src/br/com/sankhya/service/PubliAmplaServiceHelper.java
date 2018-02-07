package br.com.sankhya.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.sankhya.common.Utils;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.Filter;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.domain.PubliGetListParam;
import br.com.sankhya.domain.StructuredBudget;

public class PubliAmplaServiceHelper implements IPubliServiceHelper {

	private static final String loginService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/Login?usuario=API&senha=p4237&empresa=1";
	private static final String getStructuredBudgetService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetOrcamentosEstruturados";
	private static final String getFixedBudgetService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetOrcamentosFixos";
	private static final String getMediaOrderService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetPedidosMidia";
	private static final String getProductionOrderService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetPedidosProducao";
	private static final String getCustomerService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetClientes";
	private static final String getCustomerServiceById = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetClienteByKey?";
	private static final String getProviderServiceById = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetFornecedorByKey?";
	private static final String getProviderService = "http://apiduca.publicloud.com.br/Services/IntegracaoService.svc/GetFornecedores";
	private static final String publiCookie = new PubliAmplaServiceHelper().Login();

	private static final boolean producao = true;
	private static final int LIMIT = 50;

	public PubliAmplaServiceHelper() {

	}

	@Override
	public String Login() {

		String cookie = "";

		try {

			System.out.println("> Autenticando na AMPLA: " + getURLEnviroment(loginService));

			URL url = new URL(getURLEnviroment(loginService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			if (conn.getResponseCode() != 200) {
				System.out.println(
						"\n\nExcedido o limite de usuários da Base Ampla. HTTP ERROR: " + conn.getResponseCode() + " "
								+ getURLEnviroment(loginService) + " " + conn.getResponseMessage() + "\n\n");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {
				cookie = output;
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

		if (cookie == null || cookie.isEmpty() || cookie.equals("0")) {
			throw new RuntimeException("ERRO: Excedido o limite de usuários da Base Ampla!!!");
		} else {
			return cookie;
		}

	}

	private String getURLEnviroment(String url) {
		return producao ? url : url.replace("//apiduca.", "//homologaapiduca.");
	}

	@Override
	public ArrayList<MediaOrder> GetMediaOrderList() throws Exception {

		ArrayList<MediaOrder> list = new ArrayList<MediaOrder>();
		Collection<? extends MediaOrder> fromJson = new ArrayList<MediaOrder>();
		int offset = 0;

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			request.getFilters().add(new Filter("#DataManutencao#", Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
//			request.getFilters().add(new Filter("#PlanilhaNumero#", "67695", 9, 1, 0, false));
			request.setFreeFilter("");
			request.setLimit(String.valueOf(LIMIT));
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			do {
				
				request.setOffSet(offset);
				
				URL url = new URL(getURLEnviroment(getMediaOrderService));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

				String input = gson.toJson(request);

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes("UTF-8"));
				os.flush();

				obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

				Type listType = new TypeToken<ArrayList<MediaOrder>>() {
				}.getType();

				fromJson = gson.fromJson(obj, listType);
				list.addAll(fromJson);
				
				conn.disconnect();
				
				offset++;
				
			} while (!fromJson.isEmpty() && fromJson.size() == LIMIT);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

		return list;
	}

	@Override
	public ArrayList<FixedBudget> GetFixedBudgetList() throws Exception {

		ArrayList<FixedBudget> fromJson = new ArrayList<FixedBudget>();
		ArrayList<FixedBudget> list = new ArrayList<FixedBudget>();
		int offset = 0;
		
		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			//request.getFilters().add(new Filter("#DataManutencao#", Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
			request.getFilters().add(new Filter("#Numero#", "45218", 9, 1, 0, false));
			request.setFreeFilter("");
			request.setLimit(String.valueOf(LIMIT));
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			do {
				
				request.setOffSet(offset);
				
				URL url = new URL(getURLEnviroment(getFixedBudgetService));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
				conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

				String input = gson.toJson(request);
				
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes("UTF-8"));
				os.flush();

				obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

				Type listType = new TypeToken<ArrayList<FixedBudget>>() {
				}.getType();

				fromJson = gson.fromJson(obj, listType);
				list.addAll(fromJson);

				conn.disconnect();
				
				offset++;
				
			} while (!fromJson.isEmpty() && fromJson.size() == LIMIT);

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return list;

	}

	@Override
	public ArrayList<ProductionOrder> GetProductionOrderList(int codOC) {

		ArrayList<ProductionOrder> list = new ArrayList<ProductionOrder>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			request.getFilters().add(new Filter("Orcamento", Integer.toString(codOC), 9, 1, 0, false));
			// request.getFilters().add(new Filter("DTMANU", "2720", 7, 1, 0,
			// false));
			request.setFreeFilter("");
			request.setLimit("50");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			URL url = new URL(getURLEnviroment(getProductionOrderService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			Type listType = new TypeToken<ArrayList<ProductionOrder>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public Customer GetCustomerById(int id) {

		Customer customer = null;
		String obj = "";
		Gson gson = new Gson();

		try {

			URL url = new URL(getURLEnviroment(getCustomerServiceById + "codigo=" + id + "&hash=" + getPublicookie()));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			customer = gson.fromJson(obj, Customer.class);

			conn.disconnect();

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

		return customer;

	}

	@Override
	public Provider GetProviderById(int id) {

		Provider provider = null;

		try {

			String obj = "";
			Gson gson = new Gson();

			URL url = new URL(getURLEnviroment(getProviderServiceById + "codigo=" + id + "&hash=" + getPublicookie()));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			provider = gson.fromJson(obj, Provider.class);

			conn.disconnect();

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

		return provider;
	}

	@Override
	public ProductionOrder GetProviderNF(int ppCod, String complemento) {

		ArrayList<ProductionOrder> list = new ArrayList<ProductionOrder>();

		try {
			
			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			
			//request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			
			request.getFilters().add(new Filter("#Numero#", Integer.toString(ppCod), 9, 1, 0, false));
			request.getFilters().add(new Filter("#Complemento#", complemento, 9, 1, 0, false));
			
			request.setFreeFilter("");
			request.setLimit("50");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			URL url = new URL(getURLEnviroment(getProductionOrderService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<ProductionOrder>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());
			
		}

		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Retorna lista de clientes Ativos
	 * 
	 * @param cookie
	 * @return Lista de Clientes do Publi
	 */
	public ArrayList<Customer> GetCustomerList(String cookie) {

		ArrayList<Customer> list = new ArrayList<Customer>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "A", 9, 1, 0, false));
			// request.getFilters().add(new Filter("DTMANU",
			// Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
			request.setFreeFilter("");
			request.setLimit("15");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			URL url = new URL(getURLEnviroment(getCustomerService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<Customer>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return list;

	}

	/**
	 * Retorna lista de Fornecedores Ativos
	 * 
	 * @param cookie
	 * @return Lista de Fornecedores do Publi
	 */
	public ArrayList<Provider> GetProviderList(String cookie) {

		ArrayList<Provider> list = new ArrayList<Provider>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "A", 9, 1, 0, false));
			// request.getFilters().add(new Filter("DTMANU",
			// Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
			request.setFreeFilter("");
			request.setLimit("15");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			URL url = new URL(getURLEnviroment(getProviderService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<Provider>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return list;

	}

	@Override
	public ArrayList<StructuredBudget> GetStructuredBudgetList() {

		ArrayList<StructuredBudget> list = new ArrayList<StructuredBudget>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			// request.getFilters().add(new Filter("DATA_APROV",
			// getDateNowYYYMMDD(), 7, 1, 0, false));
			request.setFreeFilter("");
			request.setLimit("15");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegUsu(getPublicookie());

			URL url = new URL(getURLEnviroment(getStructuredBudgetService));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<StructuredBudget>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return list;

	}

	public static String getPublicookie() {
		return publiCookie;
	}

}
