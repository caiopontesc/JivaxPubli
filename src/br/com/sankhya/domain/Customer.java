package br.com.sankhya.domain;

import java.util.ArrayList;

public class Customer {
	private boolean Checked;
	private String DataAlteracao;
	private String DataInclusao;
	private String DataManutencao;
	private String HoraAlteracao;
	private int Id;
	private int IdRegUsu;
	private int IdUsuarioAlteracao;
	private int IdUsuarioInclusao;
	private String UsuarioAlteracao;
	private String UsuarioInclusao;
	private boolean AdicionaIssMidia;
	private boolean AdicionaIssProducao;
	private boolean AdicionaIssProducaoGeraReceita;
	private double AdicionaIssProducaoPercentual;
	private int Agencia;
	private String AgenciaCodigo;
	private String AgenciaNome;
	private String AgenciaTipo;
	private String Apelido;
	private String Atendimento;
	private String Atendimento2;
	private String Bairro;
	private String BairroCobranca;
	private int CalculoImpostoFederal;
	private String Campanhas;
	private double CapitalSocial;
	private String Centrocusto;
	private String Cep;
	private String CepCobranca;
	private String Cnpj;
	private int Codigo;
	private int CodigoDePara;
	private double CodigoEmpresaPedido;
	private String CodigoIbope;
	private double Comissao;
	private boolean ComissaoDoVeiculo;
	private boolean ComissaoSobreLiquido;
	private String CondicoesFatura;
	private String CondicoesOrcamento;
	private String CondicoesOrcamentoEletronico;
	private String CondicoesOrcamentoGrafico;
	private String CondicoesOrcamentoPromocao;
	private String CondicoesPI;
	private String CondicoesPP;
	private String CondicoesPPEletronico;
	private String CondicoesPPGrafico;
	private String CondicoesPPPromocao;
	private String CondicoesPlano;
	private String CondicoesSolicitacao;
	private String CondicoesSolicitacaoEletronico;
	private String CondicoesSolicitacaoGrafico;
	private String CondicoesSolicitacaoPromocao;
	private String Contato;
	// private ArrayList<String> Contatos;
	// private ArrayList<String> Contratos;
	private String Cor;
	private String CtbContaCliente;
	private String CtbContaCustoRecuperacao;
	private String CtbContaProducao;
	private String CtbContaVeiculo;
	private String DataCapitalSocial;
	private String DataFundacao;
	private double DescontoPlanoMidia;
	private double DescontoTabelaInternos;
	private int DiasRecebimentoAntes;
	private int DiasVencimentoContrato;
	private String Email;
	private int Empresa;
	private boolean EncargosTotalFaturaMidia;
	private boolean EncargosTotalFaturaProducao;
	private String Endereco;
	private String EnderecoCobranca;
	private ArrayList<String> Enderecos;
	private String Estado;
	private String EstadoCobranca;
	private double FaturaComissaoMidia;
	private double FaturaDescontoMidia;
	private double FaturaDescontoProducao;
	private String FaturaEncargosMidia;
	private double FaturaEncargosProducao;
	private String FaturaEncargosProducaoTipo;
	private double FaturaHonorariosProducao;
	private double FaturaInternosProducao;
	private double FaturaLiquidoMidia;
	private double FaturaLiquidoProducao;
	private boolean FaturaNaoCalculaCOFINS;
	private boolean FaturaNaoCalculaCSLL;
	private boolean FaturaNaoCalculaIR;
	private boolean FaturaNaoCalculaISS;
	private boolean FaturaNaoCalculaPIS;
	private boolean FaturaReterCOFINS;
	private boolean FaturaReterCSLL;
	private boolean FaturaReterIR;
	private boolean FaturaReterISS;
	private boolean FaturaReterPIS;
	private boolean FaturarHonorariosOrcamento;
	private String Fax;
	private boolean GovernoEstadual;
	private String Grupo;
	private String Grupo2;
	private String Homepage;
	private double Honorarios;
	private boolean HonorariosDoFornecedor;
	private boolean HonorariosSobreBruto;
	private boolean HonorariosSobreLiquido;
	private double ISSBaseMinima;
	private boolean ImprimeEnderecoAgenciaPI;
	private boolean ImprimeEnderecoAgenciaPP;
	private boolean ImprimeSacadoAgenciaPI;
	private boolean ImprimeSacadoAgenciaPP;
	private String InscricaoEstadual;
	private String InscricaoMunicipal;
	private String Municipio;
	private String MunicipioCobranca;
	private String Nome;
	private String Observacao;
	private String Pais;
	private boolean PlanoMidiaValorBruto;
	private String PrazoMidia;
	private String PrazoProducao;
	private String Prazos;
	private String Prefixo;
	private String Produtos;
	private String Rateios;
	private String RazaoSocial;
	private String Situacao;
	private String SituacaoDescricao;
	private String Sped_IND_NAT_RET;
	private String SubstituiCliente;
	private String Telefone;
	private int TipoCnpj;
	private int TipoDescontoPlanoMidia;
	private int TipoFaturamentoMidia;
	private int TipoFaturamentoProducao;

	public Customer() {

	}

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

	public String getHoraAlteracao() {
		return HoraAlteracao;
	}

	public void setHoraAlteracao(String horaAlteracao) {
		HoraAlteracao = horaAlteracao;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getIdRegUsu() {
		return IdRegUsu;
	}

	public void setIdRegUsu(int idRegUsu) {
		IdRegUsu = idRegUsu;
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

	public boolean isAdicionaIssMidia() {
		return AdicionaIssMidia;
	}

	public void setAdicionaIssMidia(boolean adicionaIssMidia) {
		AdicionaIssMidia = adicionaIssMidia;
	}

	public boolean isAdicionaIssProducao() {
		return AdicionaIssProducao;
	}

	public void setAdicionaIssProducao(boolean adicionaIssProducao) {
		AdicionaIssProducao = adicionaIssProducao;
	}

	public boolean isAdicionaIssProducaoGeraReceita() {
		return AdicionaIssProducaoGeraReceita;
	}

	public void setAdicionaIssProducaoGeraReceita(boolean adicionaIssProducaoGeraReceita) {
		AdicionaIssProducaoGeraReceita = adicionaIssProducaoGeraReceita;
	}

	public double getAdicionaIssProducaoPercentual() {
		return AdicionaIssProducaoPercentual;
	}

	public void setAdicionaIssProducaoPercentual(double adicionaIssProducaoPercentual) {
		AdicionaIssProducaoPercentual = adicionaIssProducaoPercentual;
	}

	public int getAgencia() {
		return Agencia;
	}

	public void setAgencia(int agencia) {
		Agencia = agencia;
	}

	public String getAgenciaCodigo() {
		return AgenciaCodigo;
	}

	public void setAgenciaCodigo(String agenciaCodigo) {
		AgenciaCodigo = agenciaCodigo;
	}

	public String getAgenciaNome() {
		return AgenciaNome;
	}

	public void setAgenciaNome(String agenciaNome) {
		AgenciaNome = agenciaNome;
	}

	public String getAgenciaTipo() {
		return AgenciaTipo;
	}

	public void setAgenciaTipo(String agenciaTipo) {
		AgenciaTipo = agenciaTipo;
	}

	public String getApelido() {
		return Apelido;
	}

	public void setApelido(String apelido) {
		Apelido = apelido;
	}

	public String getAtendimento() {
		return Atendimento;
	}

	public void setAtendimento(String atendimento) {
		Atendimento = atendimento;
	}

	public String getAtendimento2() {
		return Atendimento2;
	}

	public void setAtendimento2(String atendimento2) {
		Atendimento2 = atendimento2;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getBairroCobranca() {
		return BairroCobranca;
	}

	public void setBairroCobranca(String bairroCobranca) {
		BairroCobranca = bairroCobranca;
	}

	public int getCalculoImpostoFederal() {
		return CalculoImpostoFederal;
	}

	public void setCalculoImpostoFederal(int calculoImpostoFederal) {
		CalculoImpostoFederal = calculoImpostoFederal;
	}

	public String getCampanhas() {
		return Campanhas;
	}

	public void setCampanhas(String campanhas) {
		Campanhas = campanhas;
	}

	public double getCapitalSocial() {
		return CapitalSocial;
	}

	public void setCapitalSocial(double capitalSocial) {
		CapitalSocial = capitalSocial;
	}

	public String getCentrocusto() {
		return Centrocusto;
	}

	public void setCentrocusto(String centrocusto) {
		Centrocusto = centrocusto;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getCepCobranca() {
		return CepCobranca;
	}

	public void setCepCobranca(String cepCobranca) {
		CepCobranca = cepCobranca;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public int getCodigoDePara() {
		return CodigoDePara;
	}

	public void setCodigoDePara(int codigoDePara) {
		CodigoDePara = codigoDePara;
	}

	public double getCodigoEmpresaPedido() {
		return CodigoEmpresaPedido;
	}

	public void setCodigoEmpresaPedido(double codigoEmpresaPedido) {
		CodigoEmpresaPedido = codigoEmpresaPedido;
	}

	public String getCodigoIbope() {
		return CodigoIbope;
	}

	public void setCodigoIbope(String codigoIbope) {
		CodigoIbope = codigoIbope;
	}

	public double getComissao() {
		return Comissao;
	}

	public void setComissao(double comissao) {
		Comissao = comissao;
	}

	public boolean getComissaoDoVeiculo() {
		return ComissaoDoVeiculo;
	}

	public void setComissaoDoVeiculo(boolean comissaoDoVeiculo) {
		ComissaoDoVeiculo = comissaoDoVeiculo;
	}

	public boolean isComissaoSobreLiquido() {
		return ComissaoSobreLiquido;
	}

	public void setComissaoSobreLiquido(boolean comissaoSobreLiquido) {
		ComissaoSobreLiquido = comissaoSobreLiquido;
	}

	public String getCondicoesFatura() {
		return CondicoesFatura;
	}

	public void setCondicoesFatura(String condicoesFatura) {
		CondicoesFatura = condicoesFatura;
	}

	public String getCondicoesOrcamento() {
		return CondicoesOrcamento;
	}

	public void setCondicoesOrcamento(String condicoesOrcamento) {
		CondicoesOrcamento = condicoesOrcamento;
	}

	public String getCondicoesOrcamentoEletronico() {
		return CondicoesOrcamentoEletronico;
	}

	public void setCondicoesOrcamentoEletronico(String condicoesOrcamentoEletronico) {
		CondicoesOrcamentoEletronico = condicoesOrcamentoEletronico;
	}

	public String getCondicoesOrcamentoGrafico() {
		return CondicoesOrcamentoGrafico;
	}

	public void setCondicoesOrcamentoGrafico(String condicoesOrcamentoGrafico) {
		CondicoesOrcamentoGrafico = condicoesOrcamentoGrafico;
	}

	public String getCondicoesOrcamentoPromocao() {
		return CondicoesOrcamentoPromocao;
	}

	public void setCondicoesOrcamentoPromocao(String condicoesOrcamentoPromocao) {
		CondicoesOrcamentoPromocao = condicoesOrcamentoPromocao;
	}

	public String getCondicoesPI() {
		return CondicoesPI;
	}

	public void setCondicoesPI(String condicoesPI) {
		CondicoesPI = condicoesPI;
	}

	public String getCondicoesPP() {
		return CondicoesPP;
	}

	public void setCondicoesPP(String condicoesPP) {
		CondicoesPP = condicoesPP;
	}

	public String getCondicoesPPEletronico() {
		return CondicoesPPEletronico;
	}

	public void setCondicoesPPEletronico(String condicoesPPEletronico) {
		CondicoesPPEletronico = condicoesPPEletronico;
	}

	public String getCondicoesPPGrafico() {
		return CondicoesPPGrafico;
	}

	public void setCondicoesPPGrafico(String condicoesPPGrafico) {
		CondicoesPPGrafico = condicoesPPGrafico;
	}

	public String getCondicoesPPPromocao() {
		return CondicoesPPPromocao;
	}

	public void setCondicoesPPPromocao(String condicoesPPPromocao) {
		CondicoesPPPromocao = condicoesPPPromocao;
	}

	public String getCondicoesPlano() {
		return CondicoesPlano;
	}

	public void setCondicoesPlano(String condicoesPlano) {
		CondicoesPlano = condicoesPlano;
	}

	public String getCondicoesSolicitacao() {
		return CondicoesSolicitacao;
	}

	public void setCondicoesSolicitacao(String condicoesSolicitacao) {
		CondicoesSolicitacao = condicoesSolicitacao;
	}

	public String getCondicoesSolicitacaoEletronico() {
		return CondicoesSolicitacaoEletronico;
	}

	public void setCondicoesSolicitacaoEletronico(String condicoesSolicitacaoEletronico) {
		CondicoesSolicitacaoEletronico = condicoesSolicitacaoEletronico;
	}

	public String getCondicoesSolicitacaoGrafico() {
		return CondicoesSolicitacaoGrafico;
	}

	public void setCondicoesSolicitacaoGrafico(String condicoesSolicitacaoGrafico) {
		CondicoesSolicitacaoGrafico = condicoesSolicitacaoGrafico;
	}

	public String getCondicoesSolicitacaoPromocao() {
		return CondicoesSolicitacaoPromocao;
	}

	public void setCondicoesSolicitacaoPromocao(String condicoesSolicitacaoPromocao) {
		CondicoesSolicitacaoPromocao = condicoesSolicitacaoPromocao;
	}

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	/*
	 * public ArrayList<String> getContatos() { return Contatos; }
	 * 
	 * public void setContatos(ArrayList<String> contatos) { Contatos =
	 * contatos; }
	 * 
	 * public ArrayList<String> getContratos() { return Contratos; }
	 * 
	 * public void setContratos(ArrayList<String> contratos) { Contratos =
	 * contratos; }
	 */

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getCtbContaCliente() {
		return CtbContaCliente;
	}

	public void setCtbContaCliente(String ctbContaCliente) {
		CtbContaCliente = ctbContaCliente;
	}

	public String getCtbContaCustoRecuperacao() {
		return CtbContaCustoRecuperacao;
	}

	public void setCtbContaCustoRecuperacao(String ctbContaCustoRecuperacao) {
		CtbContaCustoRecuperacao = ctbContaCustoRecuperacao;
	}

	public String getCtbContaProducao() {
		return CtbContaProducao;
	}

	public void setCtbContaProducao(String ctbContaProducao) {
		CtbContaProducao = ctbContaProducao;
	}

	public String getCtbContaVeiculo() {
		return CtbContaVeiculo;
	}

	public void setCtbContaVeiculo(String ctbContaVeiculo) {
		CtbContaVeiculo = ctbContaVeiculo;
	}

	public String getDataCapitalSocial() {
		return DataCapitalSocial;
	}

	public void setDataCapitalSocial(String dataCapitalSocial) {
		DataCapitalSocial = dataCapitalSocial;
	}

	public String getDataFundacao() {
		return DataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		DataFundacao = dataFundacao;
	}

	public double getDescontoPlanoMidia() {
		return DescontoPlanoMidia;
	}

	public void setDescontoPlanoMidia(double descontoPlanoMidia) {
		DescontoPlanoMidia = descontoPlanoMidia;
	}

	public double getDescontoTabelaInternos() {
		return DescontoTabelaInternos;
	}

	public void setDescontoTabelaInternos(double descontoTabelaInternos) {
		DescontoTabelaInternos = descontoTabelaInternos;
	}

	public int getDiasRecebimentoAntes() {
		return DiasRecebimentoAntes;
	}

	public void setDiasRecebimentoAntes(int diasRecebimentoAntes) {
		DiasRecebimentoAntes = diasRecebimentoAntes;
	}

	public int getDiasVencimentoContrato() {
		return DiasVencimentoContrato;
	}

	public void setDiasVencimentoContrato(int diasVencimentoContrato) {
		DiasVencimentoContrato = diasVencimentoContrato;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(int empresa) {
		Empresa = empresa;
	}

	public boolean isEncargosTotalFaturaMidia() {
		return EncargosTotalFaturaMidia;
	}

	public void setEncargosTotalFaturaMidia(boolean encargosTotalFaturaMidia) {
		EncargosTotalFaturaMidia = encargosTotalFaturaMidia;
	}

	public boolean isEncargosTotalFaturaProducao() {
		return EncargosTotalFaturaProducao;
	}

	public void setEncargosTotalFaturaProducao(boolean encargosTotalFaturaProducao) {
		EncargosTotalFaturaProducao = encargosTotalFaturaProducao;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getEnderecoCobranca() {
		return EnderecoCobranca;
	}

	public void setEnderecoCobranca(String enderecoCobranca) {
		EnderecoCobranca = enderecoCobranca;
	}

	public ArrayList<String> getEnderecos() {
		return Enderecos;
	}

	public void setEnderecos(ArrayList<String> enderecos) {
		Enderecos = enderecos;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getEstadoCobranca() {
		return EstadoCobranca;
	}

	public void setEstadoCobranca(String estadoCobranca) {
		EstadoCobranca = estadoCobranca;
	}

	public double getFaturaComissaoMidia() {
		return FaturaComissaoMidia;
	}

	public void setFaturaComissaoMidia(double faturaComissaoMidia) {
		FaturaComissaoMidia = faturaComissaoMidia;
	}

	public double getFaturaDescontoMidia() {
		return FaturaDescontoMidia;
	}

	public void setFaturaDescontoMidia(double faturaDescontoMidia) {
		FaturaDescontoMidia = faturaDescontoMidia;
	}

	public double getFaturaDescontoProducao() {
		return FaturaDescontoProducao;
	}

	public void setFaturaDescontoProducao(double faturaDescontoProducao) {
		FaturaDescontoProducao = faturaDescontoProducao;
	}

	public String getFaturaEncargosMidia() {
		return FaturaEncargosMidia;
	}

	public void setFaturaEncargosMidia(String faturaEncargosMidia) {
		FaturaEncargosMidia = faturaEncargosMidia;
	}

	public double getFaturaEncargosProducao() {
		return FaturaEncargosProducao;
	}

	public void setFaturaEncargosProducao(double faturaEncargosProducao) {
		FaturaEncargosProducao = faturaEncargosProducao;
	}

	public String getFaturaEncargosProducaoTipo() {
		return FaturaEncargosProducaoTipo;
	}

	public void setFaturaEncargosProducaoTipo(String faturaEncargosProducaoTipo) {
		FaturaEncargosProducaoTipo = faturaEncargosProducaoTipo;
	}

	public double getFaturaHonorariosProducao() {
		return FaturaHonorariosProducao;
	}

	public void setFaturaHonorariosProducao(double faturaHonorariosProducao) {
		FaturaHonorariosProducao = faturaHonorariosProducao;
	}

	public double getFaturaInternosProducao() {
		return FaturaInternosProducao;
	}

	public void setFaturaInternosProducao(double faturaInternosProducao) {
		FaturaInternosProducao = faturaInternosProducao;
	}

	public double getFaturaLiquidoMidia() {
		return FaturaLiquidoMidia;
	}

	public void setFaturaLiquidoMidia(double faturaLiquidoMidia) {
		FaturaLiquidoMidia = faturaLiquidoMidia;
	}

	public double getFaturaLiquidoProducao() {
		return FaturaLiquidoProducao;
	}

	public void setFaturaLiquidoProducao(double faturaLiquidoProducao) {
		FaturaLiquidoProducao = faturaLiquidoProducao;
	}

	public boolean isFaturaNaoCalculaCOFINS() {
		return FaturaNaoCalculaCOFINS;
	}

	public void setFaturaNaoCalculaCOFINS(boolean faturaNaoCalculaCOFINS) {
		FaturaNaoCalculaCOFINS = faturaNaoCalculaCOFINS;
	}

	public boolean isFaturaNaoCalculaCSLL() {
		return FaturaNaoCalculaCSLL;
	}

	public void setFaturaNaoCalculaCSLL(boolean faturaNaoCalculaCSLL) {
		FaturaNaoCalculaCSLL = faturaNaoCalculaCSLL;
	}

	public boolean isFaturaNaoCalculaIR() {
		return FaturaNaoCalculaIR;
	}

	public void setFaturaNaoCalculaIR(boolean faturaNaoCalculaIR) {
		FaturaNaoCalculaIR = faturaNaoCalculaIR;
	}

	public boolean isFaturaNaoCalculaISS() {
		return FaturaNaoCalculaISS;
	}

	public void setFaturaNaoCalculaISS(boolean faturaNaoCalculaISS) {
		FaturaNaoCalculaISS = faturaNaoCalculaISS;
	}

	public boolean isFaturaNaoCalculaPIS() {
		return FaturaNaoCalculaPIS;
	}

	public void setFaturaNaoCalculaPIS(boolean faturaNaoCalculaPIS) {
		FaturaNaoCalculaPIS = faturaNaoCalculaPIS;
	}

	public boolean isFaturaReterCOFINS() {
		return FaturaReterCOFINS;
	}

	public void setFaturaReterCOFINS(boolean faturaReterCOFINS) {
		FaturaReterCOFINS = faturaReterCOFINS;
	}

	public boolean isFaturaReterCSLL() {
		return FaturaReterCSLL;
	}

	public void setFaturaReterCSLL(boolean faturaReterCSLL) {
		FaturaReterCSLL = faturaReterCSLL;
	}

	public boolean isFaturaReterIR() {
		return FaturaReterIR;
	}

	public void setFaturaReterIR(boolean faturaReterIR) {
		FaturaReterIR = faturaReterIR;
	}

	public boolean isFaturaReterISS() {
		return FaturaReterISS;
	}

	public void setFaturaReterISS(boolean faturaReterISS) {
		FaturaReterISS = faturaReterISS;
	}

	public boolean isFaturaReterPIS() {
		return FaturaReterPIS;
	}

	public void setFaturaReterPIS(boolean faturaReterPIS) {
		FaturaReterPIS = faturaReterPIS;
	}

	public boolean isFaturarHonorariosOrcamento() {
		return FaturarHonorariosOrcamento;
	}

	public void setFaturarHonorariosOrcamento(boolean faturarHonorariosOrcamento) {
		FaturarHonorariosOrcamento = faturarHonorariosOrcamento;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public boolean isGovernoEstadual() {
		return GovernoEstadual;
	}

	public void setGovernoEstadual(boolean governoEstadual) {
		GovernoEstadual = governoEstadual;
	}

	public String getGrupo() {
		return Grupo;
	}

	public void setGrupo(String grupo) {
		Grupo = grupo;
	}

	public String getGrupo2() {
		return Grupo2;
	}

	public void setGrupo2(String grupo2) {
		Grupo2 = grupo2;
	}

	public String getHomepage() {
		return Homepage;
	}

	public void setHomepage(String homepage) {
		Homepage = homepage;
	}

	public double getHonorarios() {
		return Honorarios;
	}

	public void setHonorarios(double honorarios) {
		Honorarios = honorarios;
	}

	public boolean isHonorariosDoFornecedor() {
		return HonorariosDoFornecedor;
	}

	public void setHonorariosDoFornecedor(boolean honorariosDoFornecedor) {
		HonorariosDoFornecedor = honorariosDoFornecedor;
	}

	public boolean isHonorariosSobreBruto() {
		return HonorariosSobreBruto;
	}

	public void setHonorariosSobreBruto(boolean honorariosSobreBruto) {
		HonorariosSobreBruto = honorariosSobreBruto;
	}

	public boolean isHonorariosSobreLiquido() {
		return HonorariosSobreLiquido;
	}

	public void setHonorariosSobreLiquido(boolean honorariosSobreLiquido) {
		HonorariosSobreLiquido = honorariosSobreLiquido;
	}

	public double getISSBaseMinima() {
		return ISSBaseMinima;
	}

	public void setISSBaseMinima(double iSSBaseMinima) {
		ISSBaseMinima = iSSBaseMinima;
	}

	public boolean isImprimeEnderecoAgenciaPI() {
		return ImprimeEnderecoAgenciaPI;
	}

	public void setImprimeEnderecoAgenciaPI(boolean imprimeEnderecoAgenciaPI) {
		ImprimeEnderecoAgenciaPI = imprimeEnderecoAgenciaPI;
	}

	public boolean isImprimeEnderecoAgenciaPP() {
		return ImprimeEnderecoAgenciaPP;
	}

	public void setImprimeEnderecoAgenciaPP(boolean imprimeEnderecoAgenciaPP) {
		ImprimeEnderecoAgenciaPP = imprimeEnderecoAgenciaPP;
	}

	public boolean isImprimeSacadoAgenciaPI() {
		return ImprimeSacadoAgenciaPI;
	}

	public void setImprimeSacadoAgenciaPI(boolean imprimeSacadoAgenciaPI) {
		ImprimeSacadoAgenciaPI = imprimeSacadoAgenciaPI;
	}

	public boolean isImprimeSacadoAgenciaPP() {
		return ImprimeSacadoAgenciaPP;
	}

	public void setImprimeSacadoAgenciaPP(boolean imprimeSacadoAgenciaPP) {
		ImprimeSacadoAgenciaPP = imprimeSacadoAgenciaPP;
	}

	public String getInscricaoEstadual() {
		return InscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		InscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return InscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		InscricaoMunicipal = inscricaoMunicipal;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	public String getMunicipioCobranca() {
		return MunicipioCobranca;
	}

	public void setMunicipioCobranca(String municipioCobranca) {
		MunicipioCobranca = municipioCobranca;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public boolean isPlanoMidiaValorBruto() {
		return PlanoMidiaValorBruto;
	}

	public void setPlanoMidiaValorBruto(boolean planoMidiaValorBruto) {
		PlanoMidiaValorBruto = planoMidiaValorBruto;
	}

	public String getPrazoMidia() {
		return PrazoMidia;
	}

	public void setPrazoMidia(String prazoMidia) {
		PrazoMidia = prazoMidia;
	}

	public String getPrazoProducao() {
		return PrazoProducao;
	}

	public void setPrazoProducao(String prazoProducao) {
		PrazoProducao = prazoProducao;
	}

	public String getPrazos() {
		return Prazos;
	}

	public void setPrazos(String prazos) {
		Prazos = prazos;
	}

	public String getPrefixo() {
		return Prefixo;
	}

	public void setPrefixo(String prefixo) {
		Prefixo = prefixo;
	}

	public String getProdutos() {
		return Produtos;
	}

	public void setProdutos(String produtos) {
		Produtos = produtos;
	}

	public String getRateios() {
		return Rateios;
	}

	public void setRateios(String rateios) {
		Rateios = rateios;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getSituacao() {
		return Situacao;
	}

	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public String getSituacaoDescricao() {
		return SituacaoDescricao;
	}

	public void setSituacaoDescricao(String situacaoDescricao) {
		SituacaoDescricao = situacaoDescricao;
	}

	public String getSped_IND_NAT_RET() {
		return Sped_IND_NAT_RET;
	}

	public void setSped_IND_NAT_RET(String sped_IND_NAT_RET) {
		Sped_IND_NAT_RET = sped_IND_NAT_RET;
	}

	public String getSubstituiCliente() {
		return SubstituiCliente;
	}

	public void setSubstituiCliente(String substituiCliente) {
		SubstituiCliente = substituiCliente;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public int getTipoCnpj() {
		return TipoCnpj;
	}

	public void setTipoCnpj(int tipoCnpj) {
		TipoCnpj = tipoCnpj;
	}

	public int getTipoDescontoPlanoMidia() {
		return TipoDescontoPlanoMidia;
	}

	public void setTipoDescontoPlanoMidia(int tipoDescontoPlanoMidia) {
		TipoDescontoPlanoMidia = tipoDescontoPlanoMidia;
	}

	public int getTipoFaturamentoMidia() {
		return TipoFaturamentoMidia;
	}

	public void setTipoFaturamentoMidia(int tipoFaturamentoMidia) {
		TipoFaturamentoMidia = tipoFaturamentoMidia;
	}

	public int getTipoFaturamentoProducao() {
		return TipoFaturamentoProducao;
	}

	public void setTipoFaturamentoProducao(int tipoFaturamentoProducao) {
		TipoFaturamentoProducao = tipoFaturamentoProducao;
	}

}
