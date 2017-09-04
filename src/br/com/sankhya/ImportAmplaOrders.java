package br.com.sankhya;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.cuckoo.core.ScheduledAction;
import org.cuckoo.core.ScheduledActionContext;

import br.com.sankhya.common.Utils;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.service.JivaServiceHelper;
import br.com.sankhya.service.PubliAmplaServiceHelper;

public class ImportAmplaOrders implements AcaoRotinaJava, ScheduledAction {

	private static final PubliAmplaServiceHelper amplaServices = new PubliAmplaServiceHelper();
	private static final String jivaCookie = JivaServiceHelper.LogIn();
	private static final int amplaPE = 1;

	@Override
	public void onTime(ScheduledActionContext ctx) {

		try {

			ctx.log("Inicio da importação de Pedidos...");

			InsertPublicationAuth();
			InsertMediaOrders();
			InsertFixedBudgets();

			ctx.log("...Finalização da importação de Pedidos.");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Executa ação do Botão de Ação
	 */
	@Override
	public void doAction(ContextoAcao ctx) throws Exception {

		try {

			Ampla(ctx);
			ImportBg9ALOrders.Bg9AL();
			ImportBg9PEOrders.Bg9PE();

		} catch (Exception e) {
			ctx.mostraErro(e.getMessage());
		}

	}

	public static void Ampla(ContextoAcao ctx) throws Exception {

		try {

			ctx.confirmar("Importar Processos Ampla",
					"Ao clicar em OK o integrador efetuará a importação dos processos da Ampla. Deseja continuar?", 1);

			InsertPublicationAuth();
			InsertFixedBudgets();
			// InsertMediaOrders();

			ctx.setMensagemRetorno("Processo de Importação Finalizado!");

		} catch (Exception e) {

			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			System.out.println(errors.toString());
			ctx.mostraErro(errors.toString());

		}

	}

	/**
	 * Insere as Planilhas/Autorizações de Publicação no Portal de Vendas
	 */
	public static void InsertPublicationAuth() {

		try {

			ArrayList<MediaOrder> mediaOrderList = amplaServices.GetMediaOrderList();

			for (MediaOrder item : mediaOrderList) {

				Customer customer = amplaServices.GetCustomerById(item.getCodigoCliente());

				Provider provider = amplaServices.GetProviderById(item.getCodigoFornecedor());

				String providerId = "";

				String customerId = "";

				if (!customer.getSituacao().isEmpty()) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo())) == false) {

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

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"P", RelationCompany(item.getEmpresa())) == false) {

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
	 * Insere Pedidos de Mídia no Portal de Compras
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

				if (!provider.getSituacao().isEmpty()) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo())) == false) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));
						;

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
	 * Insere as OCs no Portal de Vendas
	 */
	public static void InsertFixedBudgets() {

		try {

			ArrayList<FixedBudget> budgetList = amplaServices.GetFixedBudgetList();

			for (FixedBudget item : budgetList) {

				Customer customer = new Customer();

				customer = amplaServices.GetCustomerById(item.getCodigoCliente());

				String customerId = "";

				if (!customer.getSituacao().isEmpty()) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(
							Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
							Integer.toString(customer.getCodigo())) == false) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));
						;

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(
								Utils.RemoveSpecialCharacters(customer.getCnpj()), jivaCookie,
								Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"P", RelationCompany(item.getEmpresa())) == false) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						JivaServiceHelper.InsertFixedBudget(item, jivaCookie, customerId, amplaServices);

						// InsertProductionOrders(item.getNumero(),
						// item.getTipoFaturamento(), customerId);

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Insere Pedidos de Produção no Portal de Compras
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

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item2.getNumero()), jivaCookie,
							"C", RelationCompany(item2.getEmpresa())) == false) {

						item2.setEmpresa(RelationCompany(item2.getEmpresa()));

						JivaServiceHelper.InsertProductionOrder(item2, jivaCookie, providerId, tipoFat, customerId);

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Relaciona o Cód da Empresa no Publi com o do Jiva
	 * 
	 * @param codPubli
	 * @return
	 */
	public static int RelationCompany(int codPubli) {

		int codJiva = 0;

		if (codPubli == amplaPE) {

			codJiva = 2;

		} else {

			codJiva = 3;

		}

		return codJiva;
	}

}
