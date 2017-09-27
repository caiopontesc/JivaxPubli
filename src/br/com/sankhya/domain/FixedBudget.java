package br.com.sankhya.domain;

import java.util.ArrayList;

public class FixedBudget {

	private boolean Checked;
	private String DataAlteracao;
	private String DataInclusao;
	private String DataManutencao;
	private String HoraAlteracao;
	private String HubClientGroup;
	private int Id;
	private int IdRegusu;
	private int IdUsuarioAlteracao;
	private int IdUsuarioInclusao;
	private int OperacaoAlteracao;
	private String UId;
	private String UsuarioAlteracao;
	private String UsuarioInclusao;
	private String Acabamento;
	private int AgenciaCodigo;
	private String Analista;
	private String AutorizacaoCliente;
	private String AutorizacaoResponsavel;
	private boolean Avisar;
	private String CalculoEncargos;
	private String Campanha;
	private int CodigoCliente;
	private int CodigoClienteOld;
	private String Complemento;
	private String Contato;
	private String Cores;
	private ArrayList<FixedCost> CustosFixos;
	private String DataAprovacao;
	private boolean DefinicaoEncargos;
	private String Descricao;
	private String DescricaoOpcao;
	private int DiasRecebimento;
	private String Emissao;
	private int Empresa;
	private double Encargos;
	private String Especie;
	private String Fatura;
	private int FaturaEmpresa;
	private String Formato;
	private String Historico;
	private double Honorarios;
	private boolean HonorariosSobreLiquido;
	private boolean IsModelo;
	private ArrayList<Item> Itens;
	private double MargemPercentual;
	private String Meio;
	private String Modelo;
	private String Moeda;
	private String Negociacao;
	private String Nfe;
	private String NomeCliente;
	private int Numero;
	private String Opcao;
	private String OrcamentoOpcaoComplemento;
	private int PercentualEncargos;
	private String PercentualHonorarios;
	private String PrazoEntrega;
	private String PrazoPagto;
	private String Produto;
	private String Produtores;
	private String Projeto;
	private String ProjetoOld;
	private String Proposta;
	private String Situacao;
	private String SituacaoObservacao;
	private String SubTipo;
	private String Tipo;
	private String TipoFaturamento;
	private String Titulo;
	private String Totais;
	private TotalFixedBudget TotaisCustoFixo;
	private String Validade;
	private double Valor;
	private double ValorInternos;
	private double ValorTerceiros;
	private double Verba;
	private String Vencimento;

	public boolean isChecked() {
		return Checked;
	}

	public void setChecked(boolean checked) {
		Checked = checked;
	}

	public String getDataAlteracao() {
		return DataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		DataAlteracao = dataAlteracao;
	}

	public String getDataInclusao() {
		return DataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		DataInclusao = dataInclusao;
	}

	public String getDataManutencao() {
		return DataManutencao;
	}

	public void setDataManutencao(String dataManutencao) {
		DataManutencao = dataManutencao;
	}

	/*
	 * public String getGuidAnexo() { return GuidAnexo; }
	 * 
	 * public void setGuidAnexo(String guidAnexo) { GuidAnexo = guidAnexo; }
	 */

	public String getHoraAlteracao() {
		return HoraAlteracao;
	}

	public void setHoraAlteracao(String horaAlteracao) {
		HoraAlteracao = horaAlteracao;
	}

	public String getHubClientGroup() {
		return HubClientGroup;
	}

	public void setHubClientGroup(String hubClientGroup) {
		HubClientGroup = hubClientGroup;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getIdRegUsu() {
		return IdRegusu;
	}

	public void setIdRegUsu(int idRegUsu) {
		IdRegusu = idRegUsu;
	}

	public int getIdUsuarioAlteracao() {
		return IdUsuarioAlteracao;
	}

	public void setIdUsuarioAlteracao(int idUsuarioAlteracao) {
		IdUsuarioAlteracao = idUsuarioAlteracao;
	}

	public int getIdUsuarioInclusao() {
		return IdUsuarioInclusao;
	}

	public void setIdUsuarioInclusao(int idUsuarioInclusao) {
		IdUsuarioInclusao = idUsuarioInclusao;
	}

	/*
	 * public boolean isIgnoreValidate() { return IgnoreValidate; }
	 * 
	 * public void setIgnoreValidate(boolean ignoreValidate) { IgnoreValidate =
	 * ignoreValidate; }
	 * 
	 * public boolean isIgnoreWarnings() { return IgnoreWarnings; }
	 * 
	 * public void setIgnoreWarnings(boolean ignoreWarnings) { IgnoreWarnings =
	 * ignoreWarnings; }
	 */

	/*
	 * public String getMotivo() { return Motivo; }
	 * 
	 * public void setMotivo(String motivo) { Motivo = motivo; }
	 */

	public int getOperacaoAlteracao() {
		return OperacaoAlteracao;
	}

	public void setOperacaoAlteracao(int operacaoAlteracao) {
		OperacaoAlteracao = operacaoAlteracao;
	}

	/*
	 * public int getSisManuAlteracao() { return SisManuAlteracao; }
	 * 
	 * public void setSisManuAlteracao(int sisManuAlteracao) { SisManuAlteracao
	 * = sisManuAlteracao; }
	 */

	public String getUId() {
		return UId;
	}

	public void setUId(String uId) {
		UId = uId;
	}

	public String getUsuarioAlteracao() {
		return UsuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		UsuarioAlteracao = usuarioAlteracao;
	}

	public String getUsuarioInclusao() {
		return UsuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		UsuarioInclusao = usuarioInclusao;
	}

	public String getAcabamento() {
		return Acabamento;
	}

	public void setAcabamento(String acabamento) {
		Acabamento = acabamento;
	}

	public int getAgenciaCodigo() {
		return AgenciaCodigo;
	}

	public void setAgenciaCodigo(int agenciaCodigo) {
		AgenciaCodigo = agenciaCodigo;
	}

	/*
	 * public String getAgenciaNome() { return AgenciaNome; }
	 * 
	 * public void setAgenciaNome(String agenciaNome) { AgenciaNome =
	 * agenciaNome; }
	 */

	public String getAnalista() {
		return Analista;
	}

	public void setAnalista(String analista) {
		Analista = analista;
	}

	public String getAutorizacaoCliente() {
		return AutorizacaoCliente;
	}

	public void setAutorizacaoCliente(String autorizacaoCliente) {
		AutorizacaoCliente = autorizacaoCliente;
	}

	/*
	 * public String getAutorizacaoData() { return AutorizacaoData; }
	 * 
	 * public void setAutorizacaoData(String autorizacaoData) { AutorizacaoData
	 * = autorizacaoData; }
	 */

	public String getAutorizacaoResponsavel() {
		return AutorizacaoResponsavel;
	}

	public void setAutorizacaoResponsavel(String autorizacaoResponsavel) {
		AutorizacaoResponsavel = autorizacaoResponsavel;
	}

	public boolean isAvisar() {
		return Avisar;
	}

	public void setAvisar(boolean avisar) {
		Avisar = avisar;
	}

	public String getCalculoEncargos() {
		return CalculoEncargos;
	}

	public void setCalculoEncargos(String calculoEncargos) {
		CalculoEncargos = calculoEncargos;
	}

	public String getCampanha() {
		return Campanha;
	}

	public void setCampanha(String campanha) {
		Campanha = campanha;
	}

	/*
	 * public String getCampoExtra() { return CampoExtra; }
	 * 
	 * public void setCampoExtra(String campoExtra) { CampoExtra = campoExtra; }
	 * 
	 * public String getCamposXml() { return CamposXml; }
	 * 
	 * public void setCamposXml(String camposXml) { CamposXml = camposXml; }
	 */

	public int getCodigoCliente() {
		return CodigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		CodigoCliente = codigoCliente;
	}

	public int getCodigoClienteOld() {
		return CodigoClienteOld;
	}

	public void setCodigoClienteOld(int codigoClienteOld) {
		CodigoClienteOld = codigoClienteOld;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public String getCores() {
		return Cores;
	}

	public void setCores(String cores) {
		Cores = cores;
	}

	public ArrayList<FixedCost> getCustosFixos() {
		return CustosFixos;
	}

	public void setCustosFixos(ArrayList<FixedCost> custosFixos) {
		CustosFixos = custosFixos;
	}

	public String getDataAprovacao() {
		return DataAprovacao;
	}

	public void setDataAprovacao(String dataAprovacao) {
		DataAprovacao = dataAprovacao;
	}

	/*
	 * public String getDataSituacao() { return DataSituacao; }
	 * 
	 * public void setDataSituacao(String dataSituacao) { DataSituacao =
	 * dataSituacao; }
	 */

	public boolean isDefinicaoEncargos() {
		return DefinicaoEncargos;
	}

	public void setDefinicaoEncargos(boolean definicaoEncargos) {
		DefinicaoEncargos = definicaoEncargos;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getDescricaoOpcao() {
		return DescricaoOpcao;
	}

	public void setDescricaoOpcao(String descricaoOpcao) {
		DescricaoOpcao = descricaoOpcao;
	}

	public int getDiasRecebimento() {
		return DiasRecebimento;
	}

	public void setDiasRecebimento(int diasRecebimento) {
		DiasRecebimento = diasRecebimento;
	}

	public String getEmissao() {
		return Emissao;
	}

	public void setEmissao(String emissao) {
		Emissao = emissao;
	}

	public int getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(int empresa) {
		Empresa = empresa;
	}

	public double getEncargos() {
		return Encargos;
	}

	public void setEncargos(double encargos) {
		Encargos = encargos;
	}

	/*
	 * public String getEntryMessages() { return EntryMessages; }
	 * 
	 * public void setEntryMessages(String entryMessages) { EntryMessages =
	 * entryMessages; }
	 */

	public String getEspecie() {
		return Especie;
	}

	public void setEspecie(String especie) {
		Especie = especie;
	}

	public String getFatura() {
		return Fatura;
	}

	public void setFatura(String fatura) {
		Fatura = fatura;
	}

	public int getFaturaEmpresa() {
		return FaturaEmpresa;
	}

	public void setFaturaEmpresa(int faturaEmpresa) {
		FaturaEmpresa = faturaEmpresa;
	}

	/*
	 * public String getFaturamentos() { return Faturamentos; }
	 * 
	 * public void setFaturamentos(String faturamentos) { Faturamentos =
	 * faturamentos; }
	 */

	public String getFormato() {
		return Formato;
	}

	public void setFormato(String formato) {
		Formato = formato;
	}

	public String getHistorico() {
		return Historico;
	}

	public void setHistorico(String historico) {
		Historico = historico;
	}

	public double getHonorarios() {
		return Honorarios;
	}

	public void setHonorarios(double honorarios) {
		Honorarios = honorarios;
	}

	public boolean isHonorariosSobreLiquido() {
		return HonorariosSobreLiquido;
	}

	public void setHonorariosSobreLiquido(boolean honorariosSobreLiquido) {
		HonorariosSobreLiquido = honorariosSobreLiquido;
	}

	/*
	 * public int getIdFat() { return IdFat; }
	 * 
	 * public void setIdFat(int idFat) { IdFat = idFat; }
	 */

	public boolean isIsModelo() {
		return IsModelo;
	}

	public void setIsModelo(boolean isModelo) {
		IsModelo = isModelo;
	}

	public ArrayList<Item> getItens() {
		return Itens;
	}

	public void setItens(ArrayList<Item> itens) {
		Itens = itens;
	}

	public double getMargemPercentual() {
		return MargemPercentual;
	}

	public void setMargemPercentual(double margemPercentual) {
		MargemPercentual = margemPercentual;
	}

	public String getMeio() {
		return Meio;
	}

	public void setMeio(String meio) {
		Meio = meio;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getMoeda() {
		return Moeda;
	}

	public void setMoeda(String moeda) {
		Moeda = moeda;
	}

	public String getNegociacao() {
		return Negociacao;
	}

	public void setNegociacao(String negociacao) {
		Negociacao = negociacao;
	}

	public String getNfe() {
		return Nfe;
	}

	public void setNfe(String nfe) {
		Nfe = nfe;
	}

	public String getNomeCliente() {
		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getOpcao() {
		return Opcao;
	}

	public void setOpcao(String opcao) {
		Opcao = opcao;
	}

	public String getOrcamentoOpcaoComplemento() {
		return OrcamentoOpcaoComplemento;
	}

	public void setOrcamentoOpcaoComplemento(String orcamentoOpcaoComplemento) {
		OrcamentoOpcaoComplemento = orcamentoOpcaoComplemento;
	}

	public int getPercentualEncargos() {
		return PercentualEncargos;
	}

	public void setPercentualEncargos(int percentualEncargos) {
		PercentualEncargos = percentualEncargos;
	}

	public String getPercentualHonorarios() {
		return PercentualHonorarios;
	}

	public void setPercentualHonorarios(String percentualHonorarios) {
		PercentualHonorarios = percentualHonorarios;
	}

	public String getPrazoEntrega() {
		return PrazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		PrazoEntrega = prazoEntrega;
	}

	public String getPrazoPagto() {
		return PrazoPagto;
	}

	public void setPrazoPagto(String prazoPagto) {
		PrazoPagto = prazoPagto;
	}

	public String getProduto() {
		return Produto;
	}

	public void setProduto(String produto) {
		Produto = produto;
	}

	public String getProdutores() {
		return Produtores;
	}

	public void setProdutores(String produtores) {
		Produtores = produtores;
	}

	public String getProjeto() {
		return Projeto;
	}

	public void setProjeto(String projeto) {
		Projeto = projeto;
	}

	public String getProjetoOld() {
		return ProjetoOld;
	}

	public void setProjetoOld(String projetoOld) {
		ProjetoOld = projetoOld;
	}

	public String getProposta() {
		return Proposta;
	}

	public void setProposta(String proposta) {
		Proposta = proposta;
	}

	public String getSituacao() {
		return Situacao;
	}

	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public String getSituacaoObservacao() {
		return SituacaoObservacao;
	}

	public void setSituacaoObservacao(String situacaoObservacao) {
		SituacaoObservacao = situacaoObservacao;
	}

	public String getSubTipo() {
		return SubTipo;
	}

	public void setSubTipo(String subTipo) {
		SubTipo = subTipo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getTipoFaturamento() {
		return TipoFaturamento;
	}

	public void setTipoFaturamento(String tipoFaturamento) {
		TipoFaturamento = tipoFaturamento;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getTotais() {
		return Totais;
	}

	public void setTotais(String totais) {
		Totais = totais;
	}

	public TotalFixedBudget getTotaisCustoFixo() {
		return TotaisCustoFixo;
	}

	public void setTotaisCustoFixo(TotalFixedBudget totaisCustoFixo) {
		TotaisCustoFixo = totaisCustoFixo;
	}

	public String getValidade() {
		return Validade;
	}

	public void setValidade(String validade) {
		Validade = validade;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public double getValorInternos() {
		return ValorInternos;
	}

	public void setValorInternos(double valorInternos) {
		ValorInternos = valorInternos;
	}

	public double getValorTerceiros() {
		return ValorTerceiros;
	}

	public void setValorTerceiros(double valorTerceiros) {
		ValorTerceiros = valorTerceiros;
	}

	public String getVencimento() {
		return Vencimento;
	}

	public void setVencimento(String vencimento) {
		Vencimento = vencimento;
	}

	public double getVerba() {
		return Verba;
	}

	public void setVerba(double verba) {
		Verba = verba;
	}

	public FixedBudget() {

	}

}
