package br.com.sankhya;

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
import br.com.sankhya.service.PubliServiceHelper;

public class ImportPubliOrders implements AcaoRotinaJava, ScheduledAction {

	private static final PubliServiceHelper publiServices = new PubliServiceHelper();
	private static final String jivaCookie = JivaServiceHelper.LogIn();
	private static final int publi = 1;

	@Override
	public void onTime(ScheduledActionContext ctx) {

		try {

			ctx.log("Inicio da importação de Pedidos...");

			InsertPublicationAuth();
			//InsertMediaOrders();
			//InsertFixedBudgets();

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

		Publi();

	}

	public static void Publi() throws Exception {

		InsertFixedBudgets();
		InsertPublicationAuth();

		// ctx.setMensagemRetorno("Processo de Importação Finalizado!");

	}

	/**
	 * Insere as Planilhas/Autorizações de Publicação no Portal de Vendas
	 */
	public static void InsertPublicationAuth() {

		try {

			ArrayList<MediaOrder> mediaOrderList = publiServices.GetMediaOrderList();
			//System.out.println(mediaOrderList.size());
			for (MediaOrder item : mediaOrderList) {

				Customer customer = publiServices.GetCustomerById(item.getCodigoCliente());

				Provider provider = publiServices.GetProviderById(item.getCodigoFornecedor());

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
					
					item.setEmpresa(RelationCompany(item.getEmpresa()));

					ArrayList<MediaOrderInstallment> pesqParcelaLista = item.getParcelas();  
					
					for(MediaOrderInstallment parcela : pesqParcelaLista) {
						if (!Utils.ValidaParcela(parcela)) {
							continue;
						}
						
						//System.out.println(item.getPlanilhaNumero());

						if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA(Integer.toString( item.getPlanilhaNumero()),
								                                                             jivaCookie, 
								                                                             "P", 
								                                                             item.getEmpresa(), 
								                                                             parcela.getComplemento()) == false) {

							JivaServiceHelper.InsertPublicationAuth( item, 
									                                 jivaCookie, 
									                                 customerId, 
									                                 providerId,
									                                 provider.getCnpj(), 
									                                 parcela );

						}
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

			ArrayList<MediaOrder> mediaOrderList = publiServices.GetMediaOrderList();

			for (MediaOrder item : mediaOrderList) {

				Provider provider = publiServices.GetProviderById(item.getCodigoFornecedor());

				Customer customer = publiServices.GetCustomerById(item.getCodigoCliente());

				String providerId = "";

				String customerId = "";

				if (!provider.getSituacao().isEmpty()) {

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
	 * Insere as OCs (Producao) no Portal de Vendas
	 */
	public static void InsertFixedBudgets() {

		try {

			ArrayList<FixedBudget> budgetList = publiServices.GetFixedBudgetList();

			for (FixedBudget item : budgetList) {
				
				Customer customer = new Customer();

				customer = publiServices.GetCustomerById(item.getCodigoCliente());
				
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

					//System.out.println(item.getNumero());

					if (JivaServiceHelper.VerifyIfOrderExistsByNUMNOTA( Integer.toString(item.getNumero()), jivaCookie,
							                                            "P", 
							                                            RelationCompany(item.getEmpresa()), 
							                                            item.getComplemento()) == false) {

						item.setEmpresa(RelationCompany(item.getEmpresa()));

						JivaServiceHelper.InsertFixedBudget(item, jivaCookie, customerId, publiServices);

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

			ArrayList<ProductionOrder> productionOrderList = publiServices.GetProductionOrderList(numeroOc);

			for (ProductionOrder item2 : productionOrderList) {

				Provider provider = publiServices.GetProviderById(item2.getCodigoFornecedor());

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

		if (codPubli == publi) {

			codJiva = 4;

		} else {

			codJiva = 5;

		}

		return codJiva;
	}

}
