package br.com.sankhya;

import java.util.ArrayList;

import br.com.sankhya.common.Utils;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.service.JivaServiceHelper;
import br.com.sankhya.service.PubliAmplaServiceHelper;

public class Main {

	private static final PubliAmplaServiceHelper amplaServices = new PubliAmplaServiceHelper();
	private static final String jivaCookie = JivaServiceHelper.LogIn();
	private static final int amplaPE = 1;

	public static void main(String[] args) {

		try {

			System.out.println("Iniciar processo de importação...\n\n");
			
			Ampla();
//			ImportBg9PEOrders.Bg9PE();
//			ImportBg9ALOrders.Bg9AL();
			
			System.out.println("\n\n...Processo Finalizado.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void Ampla() throws Exception {

		try {

			InsertFixedBudgets();
			InsertPublicationAuth();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void InsertPublicationAuth() {

		try {

			ArrayList<MediaOrder> mediaOrderList = amplaServices.GetMediaOrderList();
			
			for (MediaOrder item : mediaOrderList) {

				Customer customer = amplaServices.GetCustomerById(item.getCodigoCliente());

				Provider provider = amplaServices.GetProviderById(item.getCodigoFornecedor());

				String providerId = "";

				String customerId = "";

				if (customer != null && !customer.getSituacao().isEmpty()) {

					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo()))) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
							Integer.toString(provider.getCodigo()))) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
								Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
								Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					if (!JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getPlanilhaNumero()),
							jivaCookie, "P", RelationCompany(item.getEmpresa()))) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						JivaServiceHelper.InsertPublicationAuth(item, jivaCookie, customerId, providerId,
								provider.getCnpj());

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere as OCs no Portal de Vendas
	 */
	public static void InsertFixedBudgets() {

		try {

			ArrayList<FixedBudget> budgetList = amplaServices.GetFixedBudgetList();
			
			for (FixedBudget item : budgetList) {
				Customer customer = amplaServices.GetCustomerById(item.getCodigoCliente());

				String customerId = "";

				if (customer != null && !customer.getSituacao().isEmpty()) {

					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo()))) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (!JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"P", RelationCompany(item.getEmpresa()))) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						InsertProductionOrders(item.getNumero(), item.getTipoFaturamento(), customerId);

						JivaServiceHelper.InsertFixedBudget(item, jivaCookie, customerId, amplaServices);

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere Pedidos de Midia no Portal de Compras
	 *
	 * @param publiCookie
	 * @param jivaCookie
	 */
	public static void InsertMediaOrders() {

		try {

			ArrayList<MediaOrder> mediaOrderList = amplaServices.GetMediaOrderList();

			for (MediaOrder item : mediaOrderList) {

				Provider provider = amplaServices.GetProviderById(item.getCodigoFornecedor());

				Customer customer = amplaServices.GetCustomerById(item.getCodigoCliente());

				String providerId = "";

				String customerId = "";

				if (provider != null && !provider.getSituacao().isEmpty()) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo())) == false) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
							Integer.toString(provider.getCodigo())) == false) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
								Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"C", RelationCompany(item.getEmpresa())) == false) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						JivaServiceHelper.InsertMediaOrder(item, jivaCookie, providerId,
								customer.getTipoFaturamentoMidia(), customerId);

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insere Pedidos de Producao no Portal de Compras
	 * 
	 * @param jivaCookie
	 * @param numeroOc
	 * @param tipoFat
	 * @param customerId
	 */
	public static void InsertProductionOrders(int numeroOc, String tipoFat, String customerId) {

		try {

			ArrayList<ProductionOrder> productionOrderList = amplaServices.GetProductionOrderList(numeroOc);

			for (ProductionOrder item2 : productionOrderList) {

				Provider provider = amplaServices.GetProviderById(item2.getCodigoFornecedor());

				String providerId = "";

				if (!provider.getSituacao().equals("")) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
							Integer.toString(provider.getCodigo())) == false) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
								Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(provider.getCnpj()), jivaCookie,
								Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					/*
					 * if
					 * (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.
					 * toString(item2.getNumero()), jivaCookie, "C") == false) {
					 * 
					 * item2.setEmpresa(RelationCompany(item2.getEmpresa()));
					 * 
					 * JivaServiceHelper.InsertProductionOrder(item2,
					 * jivaCookie, providerId, tipoFat, customerId);
					 * 
					 * }
					 */
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Relaciona o Cod da Empresa no Publi com o do Jiva
	 * 
	 * @param codPubli
	 * @return
	 */
	public static int RelationCompany(int codPubli) {
		if (codPubli == amplaPE)
			return 2;
		
		return 3;
	}

}