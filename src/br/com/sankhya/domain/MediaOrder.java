package br.com.sankhya.domain;

import java.util.ArrayList;

public class MediaOrder {

	public MediaOrder() {

	}

	private boolean Checked;
	private String DataAlteracao;
	private String DataInclusao;
	private String DataManutencao;
	private String HoraAlteracao;
	private int Id;
	private int IdUsuarioAlteracao;
	private int IdUsuarioInclusao;
	private String Motivo;
	private String OperacaoAlteracao;
	private String UId;
	private String UsuarioAlteracao;
	private String UsuarioInclusao;
	private int BVEmpresa;
	private String BVFatura;
	private String BVForma;
	private double BVValor;
	private String Campanha;
	private int CodigoCliente;
	private int CodigoClienteOld;
	private int CodigoFornecedor;
	private String Complemento;
	private String ComplementoOriginal;
	private String DataAprovacao;
	private String DataSituacao;
	private String Emissao;
	private int Empresa;
	private String Especie;
	private String Fatura;
	private int FaturaEmpresa;
	private String IdFat;
	private String IdFatBv;
	private String IdFatCr;
	private int Lancamento;
	private String MotivoSituacao;
	private int NfCodigoFornecedor;
	private double NfCofinsRf;
	private double NfCsllRf;
	private String NfDataChegada;
	private double NfDesconto;
	private String NfEmissao;
	private int NfEmpresa;
	private double NfInssRf;
	private double NfIrRf;
	private double NfIssRf;
	private String NfNomeFornecedor;
	private String NfNumero;
	private String NfObservacao;
	private double NfPisRf;
	private String NfSerie;
	private String NfSituacao;
	private String NfTipoDocumento;
	private double NfValor;
	private String NomeCliente;
	private String NomeFornecedor;
	private String NotaDebito;
	private int Numero;
	private String OrcOpcao;
	private int Orcamento;
	private String OrcamentoOpcao;
	private String PrazoEntrega;
	private String PrazoPagto;
	private String Produto;
	private String Projeto;
	private String ProjetoOld;
	private String Situacao;
	private String SituacaoOld;
	private String Tipo;
	private String TipoFaturamento;
	private double Valor;
	private String Vencimento;
	private String Acabamento;
	private int AgenciaCodigo;
	private String AutorizacaoCliente;
	private String AutorizacaoData;
	private String AutorizacaoResponsavel;
	private boolean Avisar;
	private String Bv;
	private boolean CfgGerarContasAPagarNoPedido;
	private boolean ContasAPagarGravado;
	private String Cores;
	private double Desconto;
	private String Descricao;
	private int Destino;
	private int DiasRecebimento;
	private double Encargos;
	private String Estudo;
	private double GRP;
	private double Grp_pa1;
	private double Grp_pa2;
	private double Grp_pa3;
	private String Iap_data;
	private double Imp_selo;
	private String Meio;
	private double MetaGrp;
	private double MetaReaplicacao;
	private double MetaValor;
	private int MetaVezes;
	private String Moeda;
	private String Natureza;
	private String NfCofinst;
	private String NfIrt;
	private String NfIsst;
	private String NfTipoDoc;
	private String Nf_csllt;
	private String Nf_insst;
	private String Nf_pist;
	private String Nfe;
	private String NomeRepresentante;
	private String Notadebito;
	private int NumPlano;
	private String ObservacaoCheckin;
	private String ObservacaoCliente;
	private String ObservacaoGera;
	private String ObservacaoVeiculo;
	private int Origem;
	private ArrayList<MediaOrderInstallment> Parcelas;
	private double PercentualHonorarios;
	private String PeriodoVeiculacao;
	private String Pesquisa;
	private int Plan_copia;
	private int PlanilhaNumero;
	private String Plano;
	private String Praca;
	private String PracaSigla;
	private String PracaUF;
	private String ProjetoGrupoCliente;
	private String Ptcl_dt_1;
	private String Ptcl_dt_2;
	private String Ptcl_dt_3;
	private String Ptcl_nr_1;
	private String Ptcl_nr_2;
	private String Ptcl_nr_3;
	private int QuantidadeParcelas;
	private String Revisao;
	private String Seq_expor;
	private String SituacaoCheckin;
	private String SituacaoDB;
	private String SpotData;
	private String SpotSit;
	private String TabelaPrecos;
	private ArrayList<FreeText> TextosLivres;
	private int TipoDesconto;
	private String Trg0;
	private String Trg0descr;
	private int Trg0pop;
	private String Trg1;
	private String Trg1descr;
	private int Trg1pop;
	private String Trg2;
	private String Trg2descr;
	private int Trg2pop;
	private String Trg3;
	private String Trg3descr;
	private int Trg3pop;
	private int Vezes;

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

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}

	public String getOperacaoAlteracao() {
		return OperacaoAlteracao;
	}

	public void setOperacaoAlteracao(String operacaoAlteracao) {
		OperacaoAlteracao = operacaoAlteracao;
	}

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

	public int getBVEmpresa() {
		return BVEmpresa;
	}

	public void setBVEmpresa(int bVEmpresa) {
		BVEmpresa = bVEmpresa;
	}

	public String getBVFatura() {
		return BVFatura;
	}

	public void setBVFatura(String bVFatura) {
		BVFatura = bVFatura;
	}

	public String getBVForma() {
		return BVForma;
	}

	public void setBVForma(String bVForma) {
		BVForma = bVForma;
	}

	public double getBVValor() {
		return BVValor;
	}

	public void setBVValor(double bVValor) {
		BVValor = bVValor;
	}

	public String getCampanha() {
		return Campanha;
	}

	public void setCampanha(String campanha) {
		Campanha = campanha;
	}

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

	public int getCodigoFornecedor() {
		return CodigoFornecedor;
	}

	public void setCodigoFornecedor(int codigoFornecedor) {
		CodigoFornecedor = codigoFornecedor;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getComplementoOriginal() {
		return ComplementoOriginal;
	}

	public void setComplementoOriginal(String complementoOriginal) {
		ComplementoOriginal = complementoOriginal;
	}

	public String getDataAprovacao() {
		return DataAprovacao;
	}

	public void setDataAprovacao(String dataAprovacao) {
		DataAprovacao = dataAprovacao;
	}

	public String getDataSituacao() {
		return DataSituacao;
	}

	public void setDataSituacao(String dataSituacao) {
		DataSituacao = dataSituacao;
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

	public String getIdFat() {
		return IdFat;
	}

	public void setIdFat(String idFat) {
		IdFat = idFat;
	}

	public String getIdFatBv() {
		return IdFatBv;
	}

	public void setIdFatBv(String idFatBv) {
		IdFatBv = idFatBv;
	}

	public String getIdFatCr() {
		return IdFatCr;
	}

	public void setIdFatCr(String idFatCr) {
		IdFatCr = idFatCr;
	}

	public int getLancamento() {
		return Lancamento;
	}

	public void setLancamento(int lancamento) {
		Lancamento = lancamento;
	}

	public String getMotivoSituacao() {
		return MotivoSituacao;
	}

	public void setMotivoSituacao(String motivoSituacao) {
		MotivoSituacao = motivoSituacao;
	}

	public int getNfCodigoFornecedor() {
		return NfCodigoFornecedor;
	}

	public void setNfCodigoFornecedor(int nfCodigoFornecedor) {
		NfCodigoFornecedor = nfCodigoFornecedor;
	}

	public double getNfCofinsRf() {
		return NfCofinsRf;
	}

	public void setNfCofinsRf(double nfCofinsRf) {
		NfCofinsRf = nfCofinsRf;
	}

	public double getNfCsllRf() {
		return NfCsllRf;
	}

	public void setNfCsllRf(double nfCsllRf) {
		NfCsllRf = nfCsllRf;
	}

	public String getNfDataChegada() {
		return NfDataChegada;
	}

	public void setNfDataChegada(String nfDataChegada) {
		NfDataChegada = nfDataChegada;
	}

	public double getNfDesconto() {
		return NfDesconto;
	}

	public void setNfDesconto(double nfDesconto) {
		NfDesconto = nfDesconto;
	}

	public String getNfEmissao() {
		return NfEmissao;
	}

	public void setNfEmissao(String nfEmissao) {
		NfEmissao = nfEmissao;
	}

	public int getNfEmpresa() {
		return NfEmpresa;
	}

	public void setNfEmpresa(int nfEmpresa) {
		NfEmpresa = nfEmpresa;
	}

	public double getNfInssRf() {
		return NfInssRf;
	}

	public void setNfInssRf(double nfInssRf) {
		NfInssRf = nfInssRf;
	}

	public double getNfIrRf() {
		return NfIrRf;
	}

	public void setNfIrRf(double nfIrRf) {
		NfIrRf = nfIrRf;
	}

	public double getNfIssRf() {
		return NfIssRf;
	}

	public void setNfIssRf(double nfIssRf) {
		NfIssRf = nfIssRf;
	}

	public String getNfNomeFornecedor() {
		return NfNomeFornecedor;
	}

	public void setNfNomeFornecedor(String nfNomeFornecedor) {
		NfNomeFornecedor = nfNomeFornecedor;
	}

	public String getNfNumero() {
		return NfNumero;
	}

	public void setNfNumero(String nfNumero) {
		NfNumero = nfNumero;
	}

	public String getNfObservacao() {
		return NfObservacao;
	}

	public void setNfObservacao(String nfObservacao) {
		NfObservacao = nfObservacao;
	}

	public double getNfPisRf() {
		return NfPisRf;
	}

	public void setNfPisRf(double nfPisRf) {
		NfPisRf = nfPisRf;
	}

	public String getNfSerie() {
		return NfSerie;
	}

	public void setNfSerie(String nfSerie) {
		NfSerie = nfSerie;
	}

	public String getNfSituacao() {
		return NfSituacao;
	}

	public void setNfSituacao(String nfSituacao) {
		NfSituacao = nfSituacao;
	}

	public String getNfTipoDocumento() {
		return NfTipoDocumento;
	}

	public void setNfTipoDocumento(String nfTipoDocumento) {
		NfTipoDocumento = nfTipoDocumento;
	}

	public double getNfValor() {
		return NfValor;
	}

	public void setNfValor(double nfValor) {
		NfValor = nfValor;
	}

	public String getNomeCliente() {
		return NomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}

	public String getNomeFornecedor() {
		return NomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		NomeFornecedor = nomeFornecedor;
	}

	public String getNotaDebito() {
		return NotaDebito;
	}

	public void setNotaDebito(String notaDebito) {
		NotaDebito = notaDebito;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getOrcOpcao() {
		return OrcOpcao;
	}

	public void setOrcOpcao(String orcOpcao) {
		OrcOpcao = orcOpcao;
	}

	public int getOrcamento() {
		return Orcamento;
	}

	public void setOrcamento(int orcamento) {
		Orcamento = orcamento;
	}

	public String getOrcamentoOpcao() {
		return OrcamentoOpcao;
	}

	public void setOrcamentoOpcao(String orcamentoOpcao) {
		OrcamentoOpcao = orcamentoOpcao;
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

	public String getSituacao() {
		return Situacao;
	}

	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public String getSituacaoOld() {
		return SituacaoOld;
	}

	public void setSituacaoOld(String situacaoOld) {
		SituacaoOld = situacaoOld;
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

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public String getVencimento() {
		return Vencimento;
	}

	public void setVencimento(String vencimento) {
		Vencimento = vencimento;
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

	public String getAutorizacaoCliente() {
		return AutorizacaoCliente;
	}

	public void setAutorizacaoCliente(String autorizacaoCliente) {
		AutorizacaoCliente = autorizacaoCliente;
	}

	public String getAutorizacaoData() {
		return AutorizacaoData;
	}

	public void setAutorizacaoData(String autorizacaoData) {
		AutorizacaoData = autorizacaoData;
	}

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

	public String getBv() {
		return Bv;
	}

	public void setBv(String bv) {
		Bv = bv;
	}

	public boolean isCfgGerarContasAPagarNoPedido() {
		return CfgGerarContasAPagarNoPedido;
	}

	public void setCfgGerarContasAPagarNoPedido(boolean cfgGerarContasAPagarNoPedido) {
		CfgGerarContasAPagarNoPedido = cfgGerarContasAPagarNoPedido;
	}

	public boolean isContasAPagarGravado() {
		return ContasAPagarGravado;
	}

	public void setContasAPagarGravado(boolean contasAPagarGravado) {
		ContasAPagarGravado = contasAPagarGravado;
	}

	public String getCores() {
		return Cores;
	}

	public void setCores(String cores) {
		Cores = cores;
	}

	public double getDesconto() {
		return Desconto;
	}

	public void setDesconto(double desconto) {
		Desconto = desconto;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getDestino() {
		return Destino;
	}

	public void setDestino(int destino) {
		Destino = destino;
	}

	public int getDiasRecebimento() {
		return DiasRecebimento;
	}

	public void setDiasRecebimento(int diasRecebimento) {
		DiasRecebimento = diasRecebimento;
	}

	public double getEncargos() {
		return Encargos;
	}

	public void setEncargos(double encargos) {
		Encargos = encargos;
	}

	public String getEstudo() {
		return Estudo;
	}

	public void setEstudo(String estudo) {
		Estudo = estudo;
	}

	/*
	 * public String getFlagsTotais() { return FlagsTotais; }
	 * 
	 * public void setFlagsTotais(String flagsTotais) { FlagsTotais =
	 * flagsTotais; }
	 */

	public double getGRP() {
		return GRP;
	}

	public void setGRP(double gRP) {
		GRP = gRP;
	}

	public double getGrp_pa1() {
		return Grp_pa1;
	}

	public void setGrp_pa1(double grp_pa1) {
		Grp_pa1 = grp_pa1;
	}

	public double getGrp_pa2() {
		return Grp_pa2;
	}

	public void setGrp_pa2(double grp_pa2) {
		Grp_pa2 = grp_pa2;
	}

	public double getGrp_pa3() {
		return Grp_pa3;
	}

	public void setGrp_pa3(double grp_pa3) {
		Grp_pa3 = grp_pa3;
	}

	public String getIap_data() {
		return Iap_data;
	}

	public void setIap_data(String iap_data) {
		Iap_data = iap_data;
	}

	public double getImp_selo() {
		return Imp_selo;
	}

	public void setImp_selo(double imp_selo) {
		Imp_selo = imp_selo;
	}

	public String getMeio() {
		return Meio;
	}

	public void setMeio(String meio) {
		Meio = meio;
	}

	public double getMetaGrp() {
		return MetaGrp;
	}

	public void setMetaGrp(double metaGrp) {
		MetaGrp = metaGrp;
	}

	public double getMetaReaplicacao() {
		return MetaReaplicacao;
	}

	public void setMetaReaplicacao(double metaReaplicacao) {
		MetaReaplicacao = metaReaplicacao;
	}

	public double getMetaValor() {
		return MetaValor;
	}

	public void setMetaValor(double metaValor) {
		MetaValor = metaValor;
	}

	public int getMetaVezes() {
		return MetaVezes;
	}

	public void setMetaVezes(int metaVezes) {
		MetaVezes = metaVezes;
	}

	public String getMoeda() {
		return Moeda;
	}

	public void setMoeda(String moeda) {
		Moeda = moeda;
	}

	public String getNatureza() {
		return Natureza;
	}

	public void setNatureza(String natureza) {
		Natureza = natureza;
	}

	public String getNfCofinst() {
		return NfCofinst;
	}

	public void setNfCofinst(String nfCofinst) {
		NfCofinst = nfCofinst;
	}

	public String getNfIrt() {
		return NfIrt;
	}

	public void setNfIrt(String nfIrt) {
		NfIrt = nfIrt;
	}

	public String getNfIsst() {
		return NfIsst;
	}

	public void setNfIsst(String nfIsst) {
		NfIsst = nfIsst;
	}

	public String getNfTipoDoc() {
		return NfTipoDoc;
	}

	public void setNfTipoDoc(String nfTipoDoc) {
		NfTipoDoc = nfTipoDoc;
	}

	public String getNf_csllt() {
		return Nf_csllt;
	}

	public void setNf_csllt(String nf_csllt) {
		Nf_csllt = nf_csllt;
	}

	public String getNf_insst() {
		return Nf_insst;
	}

	public void setNf_insst(String nf_insst) {
		Nf_insst = nf_insst;
	}

	public String getNf_pist() {
		return Nf_pist;
	}

	public void setNf_pist(String nf_pist) {
		Nf_pist = nf_pist;
	}

	public String getNfe() {
		return Nfe;
	}

	public void setNfe(String nfe) {
		Nfe = nfe;
	}

	public String getNomeRepresentante() {
		return NomeRepresentante;
	}

	public void setNomeRepresentante(String nomeRepresentante) {
		NomeRepresentante = nomeRepresentante;
	}

	public String getNotadebito() {
		return Notadebito;
	}

	public void setNotadebito(String notadebito) {
		Notadebito = notadebito;
	}

	public int getNumPlano() {
		return NumPlano;
	}

	public void setNumPlano(int numPlano) {
		NumPlano = numPlano;
	}

	public String getObservacaoCheckin() {
		return ObservacaoCheckin;
	}

	public void setObservacaoCheckin(String observacaoCheckin) {
		ObservacaoCheckin = observacaoCheckin;
	}

	public String getObservacaoCliente() {
		return ObservacaoCliente;
	}

	public void setObservacaoCliente(String observacaoCliente) {
		ObservacaoCliente = observacaoCliente;
	}

	public String getObservacaoGera() {
		return ObservacaoGera;
	}

	public void setObservacaoGera(String observacaoGera) {
		ObservacaoGera = observacaoGera;
	}

	public String getObservacaoVeiculo() {
		return ObservacaoVeiculo;
	}

	public void setObservacaoVeiculo(String observacaoVeiculo) {
		ObservacaoVeiculo = observacaoVeiculo;
	}

	public int getOrigem() {
		return Origem;
	}

	public void setOrigem(int origem) {
		Origem = origem;
	}

	public ArrayList<MediaOrderInstallment> getParcelas() {
		return Parcelas;
	}

	public void setParcelas(ArrayList<MediaOrderInstallment> parcelas) {
		Parcelas = parcelas;
	}

	/*
	 * public String getPecas() { return Pecas; }
	 * 
	 * public void setPecas(String pecas) { Pecas = pecas; }
	 */

	public double getPercentualHonorarios() {
		return PercentualHonorarios;
	}

	public void setPercentualHonorarios(double percentualHonorarios) {
		PercentualHonorarios = percentualHonorarios;
	}

	public String getPeriodoVeiculacao() {
		return PeriodoVeiculacao;
	}

	public void setPeriodoVeiculacao(String periodoVeiculacao) {
		PeriodoVeiculacao = periodoVeiculacao;
	}

	public String getPesquisa() {
		return Pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		Pesquisa = pesquisa;
	}

	public int getPlan_copia() {
		return Plan_copia;
	}

	public void setPlan_copia(int plan_copia) {
		Plan_copia = plan_copia;
	}

	public int getPlanilhaNumero() {
		return PlanilhaNumero;
	}

	public void setPlanilhaNumero(int planilhaNumero) {
		PlanilhaNumero = planilhaNumero;
	}

	public String getPlano() {
		return Plano;
	}

	public void setPlano(String plano) {
		Plano = plano;
	}

	public String getPraca() {
		return Praca;
	}

	public void setPraca(String praca) {
		Praca = praca;
	}

	public String getPracaSigla() {
		return PracaSigla;
	}

	public void setPracaSigla(String pracaSigla) {
		PracaSigla = pracaSigla;
	}

	public String getPracaUF() {
		return PracaUF;
	}

	public void setPracaUF(String pracaUF) {
		PracaUF = pracaUF;
	}

	/*
	 * public String getProgramas() { return Programas; }
	 * 
	 * public void setProgramas(String programas) { Programas = programas; }
	 */

	public String getProjetoGrupoCliente() {
		return ProjetoGrupoCliente;
	}

	public void setProjetoGrupoCliente(String projetoGrupoCliente) {
		ProjetoGrupoCliente = projetoGrupoCliente;
	}

	public String getPtcl_dt_1() {
		return Ptcl_dt_1;
	}

	public void setPtcl_dt_1(String ptcl_dt_1) {
		Ptcl_dt_1 = ptcl_dt_1;
	}

	public String getPtcl_dt_2() {
		return Ptcl_dt_2;
	}

	public void setPtcl_dt_2(String ptcl_dt_2) {
		Ptcl_dt_2 = ptcl_dt_2;
	}

	public String getPtcl_dt_3() {
		return Ptcl_dt_3;
	}

	public void setPtcl_dt_3(String ptcl_dt_3) {
		Ptcl_dt_3 = ptcl_dt_3;
	}

	public String getPtcl_nr_1() {
		return Ptcl_nr_1;
	}

	public void setPtcl_nr_1(String ptcl_nr_1) {
		Ptcl_nr_1 = ptcl_nr_1;
	}

	public String getPtcl_nr_2() {
		return Ptcl_nr_2;
	}

	public void setPtcl_nr_2(String ptcl_nr_2) {
		Ptcl_nr_2 = ptcl_nr_2;
	}

	public String getPtcl_nr_3() {
		return Ptcl_nr_3;
	}

	public void setPtcl_nr_3(String ptcl_nr_3) {
		Ptcl_nr_3 = ptcl_nr_3;
	}

	public int getQuantidadeParcelas() {
		return QuantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		QuantidadeParcelas = quantidadeParcelas;
	}

	public String getRevisao() {
		return Revisao;
	}

	public void setRevisao(String revisao) {
		Revisao = revisao;
	}

	public String getSeq_expor() {
		return Seq_expor;
	}

	public void setSeq_expor(String seq_expor) {
		Seq_expor = seq_expor;
	}

	public String getSituacaoCheckin() {
		return SituacaoCheckin;
	}

	public void setSituacaoCheckin(String situacaoCheckin) {
		SituacaoCheckin = situacaoCheckin;
	}

	public String getSituacaoDB() {
		return SituacaoDB;
	}

	public void setSituacaoDB(String situacaoDB) {
		SituacaoDB = situacaoDB;
	}

	public String getSpotData() {
		return SpotData;
	}

	public void setSpotData(String spotData) {
		SpotData = spotData;
	}

	public String getSpotSit() {
		return SpotSit;
	}

	public void setSpotSit(String spotSit) {
		SpotSit = spotSit;
	}

	public String getTabelaPrecos() {
		return TabelaPrecos;
	}

	public void setTabelaPrecos(String tabelaPrecos) {
		TabelaPrecos = tabelaPrecos;
	}

	/*
	 * public String getTargetsPlano() { return TargetsPlano; }
	 * 
	 * public void setTargetsPlano(String targetsPlano) { TargetsPlano =
	 * targetsPlano; }
	 */

	/*
	 * public String getTextosLivres() { return TextosLivres; }
	 * 
	 * public void setTextosLivres(String textosLivres) { TextosLivres =
	 * textosLivres; }
	 */

	public int getTipoDesconto() {
		return TipoDesconto;
	}

	public void setTipoDesconto(int tipoDesconto) {
		TipoDesconto = tipoDesconto;
	}

	public String getTrg0() {
		return Trg0;
	}

	public void setTrg0(String trg0) {
		Trg0 = trg0;
	}

	public String getTrg0descr() {
		return Trg0descr;
	}

	public void setTrg0descr(String trg0descr) {
		Trg0descr = trg0descr;
	}

	public int getTrg0pop() {
		return Trg0pop;
	}

	public void setTrg0pop(int trg0pop) {
		Trg0pop = trg0pop;
	}

	public String getTrg1() {
		return Trg1;
	}

	public void setTrg1(String trg1) {
		Trg1 = trg1;
	}

	public String getTrg1descr() {
		return Trg1descr;
	}

	public void setTrg1descr(String trg1descr) {
		Trg1descr = trg1descr;
	}

	public int getTrg1pop() {
		return Trg1pop;
	}

	public void setTrg1pop(int trg1pop) {
		Trg1pop = trg1pop;
	}

	public String getTrg2() {
		return Trg2;
	}

	public void setTrg2(String trg2) {
		Trg2 = trg2;
	}

	public String getTrg2descr() {
		return Trg2descr;
	}

	public void setTrg2descr(String trg2descr) {
		Trg2descr = trg2descr;
	}

	public int getTrg2pop() {
		return Trg2pop;
	}

	public void setTrg2pop(int trg2pop) {
		Trg2pop = trg2pop;
	}

	public String getTrg3() {
		return Trg3;
	}

	public void setTrg3(String trg3) {
		Trg3 = trg3;
	}

	public String getTrg3descr() {
		return Trg3descr;
	}

	public void setTrg3descr(String trg3descr) {
		Trg3descr = trg3descr;
	}

	public int getTrg3pop() {
		return Trg3pop;
	}

	public void setTrg3pop(int trg3pop) {
		Trg3pop = trg3pop;
	}

	public int getVezes() {
		return Vezes;
	}

	public void setVezes(int vezes) {
		Vezes = vezes;
	}

	public ArrayList<FreeText> getTextosLivres() {
		return TextosLivres;
	}

	public void setTextosLivres(ArrayList<FreeText> textosLivres) {
		TextosLivres = textosLivres;
	}

}
