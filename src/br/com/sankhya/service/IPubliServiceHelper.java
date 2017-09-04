package br.com.sankhya.service;

import java.util.ArrayList;

import br.com.sankhya.domain.Customer;
import br.com.sankhya.domain.FixedBudget;
import br.com.sankhya.domain.MediaOrder;
import br.com.sankhya.domain.ProductionOrder;
import br.com.sankhya.domain.Provider;
import br.com.sankhya.domain.StructuredBudget;

public interface IPubliServiceHelper {

	/**
	 * Efetua login no WebService Publi
	 * 
	 * @return Token do Publi
	 */
	public String Login();

	/**
	 * Pega lista de Pedidos de Mídia com Status = Liberado para Faturamento
	 * 
	 * @return Lista de Pedidos de Mídia do Publi
	 * @throws Exception
	 */
	public ArrayList<MediaOrder> GetMediaOrderList() throws Exception;

	/**
	 * Pega a Lista de OCs Fixas com Status = Liberado para Faturamento
	 * 
	 * @return Lista de Orçamentos Fixos do Publi
	 * @throws Exception
	 */
	public ArrayList<FixedBudget> GetFixedBudgetList() throws Exception;

	/**
	 * Pega a Lista de OCs Estrtuturadas com Status = Liberado para Faturamento
	 * 
	 * @return Lista de Orçamentos Estruturados do Publi
	 */
	public ArrayList<StructuredBudget> GetStructuredBudgetList();

	/**
	 * Pega a Lista de PPs relacionadas a uma OC
	 * 
	 * @param codOC
	 * @return Lista de Pedidos de Produção do do Publi Filtros: Status = "L"
	 *         (Liberado para Faturamento) e Data de Aprovação = Hoje
	 */
	public ArrayList<ProductionOrder> GetProductionOrderList(int codOC);

	/**
	 * Pega Cliente pelo Cód
	 * 
	 * @param id
	 * @return Cliente pesquisado no Publi pelo Código/Id
	 */
	public Customer GetCustomerById(int id);

	/**
	 * Pega Fornecedor pelo Cód
	 * 
	 * @param id
	 * @return Fornecedor pesquisado no Publi pelo Código/Id
	 */
	public Provider GetProviderById(int id);

	public String GetProviderNF(int ppCod);

}
