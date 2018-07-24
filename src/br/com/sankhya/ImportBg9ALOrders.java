package br.com.sankhya;

import static br.com.sankhya.common.Utils.RemoveSpecialCharacters;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.cuckoo.core.ScheduledAction;
import org.cuckoo.core.ScheduledActionContext;

import br.com.sankhya.common.Utils;
import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.MediaOrderInstallment;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.service.JivaServiceHelper;
import br.com.sankhya.service.PubliBg9ALServiceHelper;

public class ImportBg9ALOrders implements AcaoRotinaJava, ScheduledAction {

	private static final PubliBg9ALServiceHelper bg9ALServices = new PubliBg9ALServiceHelper();
	private static final String jivaCookie = JivaServiceHelper.LogIn();
	private static final int bg9PE = 1;

	@Override
	public void onTime(ScheduledActionContext ctx) {

		try {

			ctx.log("Inicio da importação de Pedidos...");

			// InsertPublicationA Iuth();
			// InsertMediaOrders();
			// InsertFixedBudgets();

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

		Bg9AL();
	}

	public static void Bg9AL() throws Exception {

		try {

			InsertPublicationAuth();
			InsertFixedBudgets();

		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			System.out.println(errors.toString());

		}

	}

	/**
	 * Insere as Planilhas/Autorizações de Publicação no Portal de Vendas
	 */
	public static void InsertPublicationAuth() {

		try {

			ArrayList<MediaOrder> mediaOrderList = bg9ALServices.GetMediaOrderList();

			for (MediaOrder item : mediaOrderList) {

				Customer customer = bg9ALServices.GetCustomerById(item.getCodigoCliente());

				Provider provider = bg9ALServices.GetProviderById(item.getCodigoFornecedor());

				String providerId = "";

				String customerId = "";

				if (!customer.getSituacao().isEmpty()) {

					// Verifica Cliente
					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
							jivaCookie, Integer.toString(customer.getCodigo()))) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
								jivaCookie, Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
								jivaCookie, Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					// Verifica Fornecedor
					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
							jivaCookie, Integer.toString(provider.getCodigo()))) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
								jivaCookie, Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
								jivaCookie, Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					item.setEmpresa(RelationCompany(item.getEmpresa()));

					ArrayList<MediaOrderInstallment> pesqParcelaLista = item.getParcelas();

					for (MediaOrderInstallment parcela : pesqParcelaLista) {
						if (!Utils.ValidaParcela(parcela)) {
							continue;
						}

						if (!JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getPlanilhaNumero()),
								jivaCookie, "P", item.getEmpresa(), parcela.getComplemento())) {

							JivaServiceHelper.InsertPublicationAuth(item, jivaCookie, customerId, providerId,
									provider.getCnpj(), parcela);

						}
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

			ArrayList<FixedBudget> budgetList = bg9ALServices.GetFixedBudgetList();

			for (FixedBudget item : budgetList) {

				Customer customer = bg9ALServices.GetCustomerById(item.getCodigoCliente());

				String customerId = "";

				if (!customer.getSituacao().isEmpty()) {

					if (!JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
							jivaCookie, Integer.toString(customer.getCodigo()))) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
								jivaCookie, Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
								jivaCookie, Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (!JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"P", RelationCompany(item.getEmpresa()), item.getComplemento())) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						JivaServiceHelper.InsertFixedBudget(item, jivaCookie, customerId, bg9ALServices);

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
	 * Insere Pedidos de Mídia no Portal de Compras
	 *
	 * @param publiCookie
	 * @param jivaCookie
	 */
	public static void InsertMediaOrders() {

		try {

			ArrayList<MediaOrder> mediaOrderList = bg9ALServices.GetMediaOrderList();

			for (MediaOrder item : mediaOrderList) {

				Provider provider = bg9ALServices.GetProviderById(item.getCodigoFornecedor());

				Customer customer = bg9ALServices.GetCustomerById(item.getCodigoCliente());

				String providerId = "";

				String customerId = "";

				if (!provider.getSituacao().isEmpty()) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
							jivaCookie, Integer.toString(customer.getCodigo())) == false) {

						JivaServiceHelper.InsertCustomer(customer, jivaCookie, Integer.toString(customer.getCodigo()));

					} else {

						customerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(customer.getCnpj()),
								jivaCookie, Integer.toString(customer.getCodigo()));

						JivaServiceHelper.UpdateCustomer(customer, customerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
							jivaCookie, Integer.toString(provider.getCodigo())) == false) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
								jivaCookie, Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item.getNumero()), jivaCookie,
							"C", RelationCompany(item.getEmpresa()), null) == false) {

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
	 * Insere Pedidos de Produção no Portal de Compras
	 * 
	 * @param jivaCookie
	 * @param numeroOc
	 * @param tipoFat
	 * @param customerId
	 */
	public static void InsertProductionOrders(int numeroOc, String tipoFat, String customerId) {

		try {

			ArrayList<ProductionOrder> productionOrderList = bg9ALServices.GetProductionOrderList(numeroOc);

			for (ProductionOrder item2 : productionOrderList) {

				Provider provider = bg9ALServices.GetProviderById(item2.getCodigoFornecedor());

				String providerId = "";

				if (!provider.getSituacao().equals("")) {

					if (JivaServiceHelper.VerifyIfCustomerExistsByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
							jivaCookie, Integer.toString(provider.getCodigo())) == false) {

						JivaServiceHelper.InsertProvider(provider, jivaCookie, Integer.toString(provider.getCodigo()));

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
								jivaCookie, Integer.toString(provider.getCodigo()));

					} else {

						providerId = JivaServiceHelper.GetCustomerIdByCNPJ(RemoveSpecialCharacters(provider.getCnpj()),
								jivaCookie, Integer.toString(provider.getCodigo()));

						JivaServiceHelper.UpdateProvider(provider, providerId, jivaCookie);

					}

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString(item2.getNumero()), jivaCookie,
							"C", RelationCompany(item2.getEmpresa()), null) == false) {

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

		if (codPubli == bg9PE) {

			codJiva = 4;

		} else {

			codJiva = 5;

		}

		return codJiva;
	}

}
