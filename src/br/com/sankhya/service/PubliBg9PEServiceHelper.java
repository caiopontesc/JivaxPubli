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

public class PubliBg9PEServiceHelper implements IPubliServiceHelper {

	private static final String loginService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/Login?usuario=API2&senha=p4237&empresa=1";
	private static final String getStructuredBudgetService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetOrcamentosEstruturados";
	private static final String getFixedBudgetService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetOrcamentosFixos";
	private static final String getMediaOrderService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetPedidosMidia";
	private static final String getProductionOrderService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetPedidosProducao";
	private static final String getCustomerService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetClientes";
	private static final String getCustomerServiceById = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetClienteByKey?";
	private static final String getProviderServiceById = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetFornecedorByKey?";
	private static final String getProviderService = "https://apibg9.publicloud.com.br/Services/IntegracaoService.svc/GetFornecedores";
	private static final String publiCookie = new PubliBg9PEServiceHelper().Login();

	@Override
	public String Login() {

		String cookie = "";

		try {

			URL url = new URL(loginService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			if (conn.getResponseCode() != 200) {
				System.out.println("\n\nExcedido o limite de usuários da Base BG9PE. HTTP ERROR: "
						+ conn.getResponseCode() + " " + loginService + " " + conn.getResponseMessage() + "\n\n");
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
			throw new RuntimeException("ERRO: Excedido o limite de usuários da Base Bg9PE!!!");
		} else {
			return cookie;
		}
	}

	@Override
	public ArrayList<MediaOrder> GetMediaOrderList() {

		ArrayList<MediaOrder> list = new ArrayList<MediaOrder>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			request.getFilters().add(new Filter("#DataManutencao#", Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
			// request.getFilters().add(new Filter("#PlanilhaNumero#", "16999",
			// 9, 1, 0, false));
			// request.getFilters().add(new Filter("#Numero#", "60084", 9, 1, 0,
			// false));
			request.setFreeFilter("");
			// request.setLimit("50");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegusu(publiCookie);

			URL url = new URL(getMediaOrderService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			Type listType = new TypeToken<ArrayList<MediaOrder>>() {
			}.getType();

			// System.out.println(obj);

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

		return list;
	}

	@Override
	public ArrayList<FixedBudget> GetFixedBudgetList() {

		ArrayList<FixedBudget> list = new ArrayList<FixedBudget>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0, false));
			request.getFilters().add(new Filter("#DataManutencao#", Utils.GetYesterdayDateYYMMDD(), 7, 1, 0, false));
			// request.getFilters().add(new Filter("#Numero#", "11194", 9, 1, 0,
			// false));
			request.setFreeFilter("");
			// request.setLimit("15");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegusu(publiCookie);

			URL url = new URL(getFixedBudgetService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<FixedBudget>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

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
			request.getFilters().add(new Filter("#Orcamento#", Integer.toString(codOC), 9, 1, 0, false));
			// request.getFilters().add(new Filter("DTMANU", "2720", 7, 1, 0,
			// false));
			request.setFreeFilter("");
			// request.setLimit("50");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegusu(publiCookie);

			URL url = new URL(getProductionOrderService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<ProductionOrder>>() {
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
	public Customer GetCustomerById(int id) {

		Customer customer = null;

		try {

			String obj = "";
			Gson gson = new Gson();

			URL url = new URL(getCustomerServiceById + "codigo=" + id + "&IdRegUsu=" + publiCookie);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			customer = gson.fromJson(obj, Customer.class);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return customer;
	}

	@Override
	public Provider GetProviderById(int id) {

		Provider provider = null;

		try {

			String obj = "";
			Gson gson = new Gson();

			URL url = new URL(getProviderServiceById + "codigo=" + id + "&IdRegUsu=" + publiCookie);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			provider = gson.fromJson(obj, Provider.class);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return provider;
	}

	@Override
	public String GetProviderNF(int ppCod) {

		ArrayList<ProductionOrder> list = new ArrayList<ProductionOrder>();

		try {

			String obj = "";
			Gson gson = new Gson();

			PubliGetListParam request = new PubliGetListParam();
			request.getFields().add("*");
			// request.getFilters().add(new Filter("SITUACAO", "L", 9, 1, 0,
			// false));
			request.getFilters().add(new Filter("#Numero#", Integer.toString(ppCod), 9, 1, 0, false));
			// request.getFilters().add(new Filter("DTMANU", "2720", 7, 1, 0,
			// false));
			request.setFreeFilter("");
			// request.setLimit("50");
			request.setOffSet(0);
			request.setOptions("");
			request.setIdRegusu(publiCookie);

			URL url = new URL(getProductionOrderService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			obj = Utils.ConvertInputStreamToJsonString(conn.getInputStream());

			// System.out.println(obj);

			Type listType = new TypeToken<ArrayList<ProductionOrder>>() {
			}.getType();

			list = gson.fromJson(obj, listType);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		if (list != null && !list.isEmpty()) {
			return list.get(0).getNotaFiscalFornecedor();
		} else {
			return null;
		}

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
			request.setIdRegusu(publiCookie);

			URL url = new URL(getStructuredBudgetService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json;charset=UTF-8");

			String input = gson.toJson(request);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
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

}
