package br.com.sankhya.domain;

import java.util.ArrayList;

public class ProductionOrder {

	public ProductionOrder() {

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
	private String Formato;
	private boolean GerarContasAPagar;
	private String Historico;
	private String HoraEntrega;
	private String LocalEntrega;
	private String Meio;
	private String Moeda;
	private String NFFornecedorField;
	private String NfCofinsTipoRetencao;
	private String NfCsllTipoRetencao;
	private String NfInssTipoRetencao;
	private String NfIrTipoRetencao;
	private String NfIssTipoRetencao;
	private String NfPisTipoRetencao;
	private String Nfe;
	private String NfeChave;
	private String NomeBv;
	private String NossaFatura;
	private String NotaFiscalFornecedor;
	private String NumeroOrcamentoOpcaoComplemento;
	private String NumeroPedidoComplemento;
	private String OrcamentoFornecedor;
	private String OrcamentoTr;
	private int Origem;
	private String Pagina;
	private String Papel;
	private ArrayList<ProductionOrderInstallment> Parcelas;
	private double PercentualHonorarios;
	private String Quantidade;
	private String Servico;
	private int SolicitacaoOrcamento;
	private String SubTipo;
	private String SubstituiPedido;
	private String TipoValorOperacao;
	private String Titulo;
	private String Trabalho;
	private String ValidadeImagem;
	private double ValorBruto;
	private double ValorDisponivel;
	private double ValorLiquido;
	private double ValorLiquidoOriginal;
	private double ValorUnitario;
	private String Versao;

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

	public void setVencimento(String Vencimento) {
		this.Vencimento = Vencimento;
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

	public String getFormato() {
		return Formato;
	}

	public void setFormato(String formato) {
		Formato = formato;
	}

	public boolean isGerarContasAPagar() {
		return GerarContasAPagar;
	}

	public void setGerarContasAPagar(boolean gerarContasAPagar) {
		GerarContasAPagar = gerarContasAPagar;
	}

	public String getHistorico() {
		return Historico;
	}

	public void setHistorico(String historico) {
		Historico = historico;
	}

	public String getHoraEntrega() {
		return HoraEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		HoraEntrega = horaEntrega;
	}

	public String getLocalEntrega() {
		return LocalEntrega;
	}

	public void setLocalEntrega(String localEntrega) {
		LocalEntrega = localEntrega;
	}

	public String getMeio() {
		return Meio;
	}

	public void setMeio(String meio) {
		Meio = meio;
	}

	public String getMoeda() {
		return Moeda;
	}

	public void setMoeda(String moeda) {
		Moeda = moeda;
	}

	public String getNFFornecedorField() {
		return NFFornecedorField;
	}

	public void setNFFornecedorField(String nFFornecedorField) {
		NFFornecedorField = nFFornecedorField;
	}

	public String getNfCofinsTipoRetencao() {
		return NfCofinsTipoRetencao;
	}

	public void setNfCofinsTipoRetencao(String nfCofinsTipoRetencao) {
		NfCofinsTipoRetencao = nfCofinsTipoRetencao;
	}

	public String getNfCsllTipoRetencao() {
		return NfCsllTipoRetencao;
	}

	public void setNfCsllTipoRetencao(String nfCsllTipoRetencao) {
		NfCsllTipoRetencao = nfCsllTipoRetencao;
	}

	public String getNfInssTipoRetencao() {
		return NfInssTipoRetencao;
	}

	public void setNfInssTipoRetencao(String nfInssTipoRetencao) {
		NfInssTipoRetencao = nfInssTipoRetencao;
	}

	public String getNfIrTipoRetencao() {
		return NfIrTipoRetencao;
	}

	public void setNfIrTipoRetencao(String nfIrTipoRetencao) {
		NfIrTipoRetencao = nfIrTipoRetencao;
	}

	public String getNfIssTipoRetencao() {
		return NfIssTipoRetencao;
	}

	public void setNfIssTipoRetencao(String nfIssTipoRetencao) {
		NfIssTipoRetencao = nfIssTipoRetencao;
	}

	public String getNfPisTipoRetencao() {
		return NfPisTipoRetencao;
	}

	public void setNfPisTipoRetencao(String nfPisTipoRetencao) {
		NfPisTipoRetencao = nfPisTipoRetencao;
	}

	public String getNfe() {
		return Nfe;
	}

	public void setNfe(String nfe) {
		Nfe = nfe;
	}

	public String getNfeChave() {
		return NfeChave;
	}

	public void setNfeChave(String nfeChave) {
		NfeChave = nfeChave;
	}

	public String getNomeBv() {
		return NomeBv;
	}

	public void setNomeBv(String nomeBv) {
		NomeBv = nomeBv;
	}

	public String getNossaFatura() {
		return NossaFatura;
	}

	public void setNossaFatura(String nossaFatura) {
		NossaFatura = nossaFatura;
	}

	public String getNotaFiscalFornecedor() {
		return NotaFiscalFornecedor;
	}

	public void setNotaFiscalFornecedor(String notaFiscalFornecedor) {
		NotaFiscalFornecedor = notaFiscalFornecedor;
	}

	public String getNumeroOrcamentoOpcaoComplemento() {
		return NumeroOrcamentoOpcaoComplemento;
	}

	public void setNumeroOrcamentoOpcaoComplemento(String numeroOrcamentoOpcaoComplemento) {
		NumeroOrcamentoOpcaoComplemento = numeroOrcamentoOpcaoComplemento;
	}

	public String getNumeroPedidoComplemento() {
		return NumeroPedidoComplemento;
	}

	public void setNumeroPedidoComplemento(String numeroPedidoComplemento) {
		NumeroPedidoComplemento = numeroPedidoComplemento;
	}

	public String getOrcamentoFornecedor() {
		return OrcamentoFornecedor;
	}

	public void setOrcamentoFornecedor(String orcamentoFornecedor) {
		OrcamentoFornecedor = orcamentoFornecedor;
	}

	public String getOrcamentoTr() {
		return OrcamentoTr;
	}

	public void setOrcamentoTr(String orcamentoTr) {
		OrcamentoTr = orcamentoTr;
	}

	public int getOrigem() {
		return Origem;
	}

	public void setOrigem(int origem) {
		Origem = origem;
	}

	public String getPagina() {
		return Pagina;
	}

	public void setPagina(String pagina) {
		Pagina = pagina;
	}

	public String getPapel() {
		return Papel;
	}

	public void setPapel(String papel) {
		Papel = papel;
	}

	public ArrayList<ProductionOrderInstallment> getParcelas() {
		return Parcelas;
	}

	public void setParcelas(ArrayList<ProductionOrderInstallment> parcelas) {
		Parcelas = parcelas;
	}

	public double getPercentualHonorarios() {
		return PercentualHonorarios;
	}

	public void setPercentualHonorarios(double percentualHonorarios) {
		PercentualHonorarios = percentualHonorarios;
	}

	public String getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(String quantidade) {
		Quantidade = quantidade;
	}

	public String getServico() {
		return Servico;
	}

	public void setServico(String servico) {
		Servico = servico;
	}

	public int getSolicitacaoOrcamento() {
		return SolicitacaoOrcamento;
	}

	public void setSolicitacaoOrcamento(int solicitacaoOrcamento) {
		SolicitacaoOrcamento = solicitacaoOrcamento;
	}

	public String getSubTipo() {
		return SubTipo;
	}

	public void setSubTipo(String subTipo) {
		SubTipo = subTipo;
	}

	public String getSubstituiPedido() {
		return SubstituiPedido;
	}

	public void setSubstituiPedido(String substituiPedido) {
		SubstituiPedido = substituiPedido;
	}

	public String getTipoValorOperacao() {
		return TipoValorOperacao;
	}

	public void setTipoValorOperacao(String tipoValorOperacao) {
		TipoValorOperacao = tipoValorOperacao;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getTrabalho() {
		return Trabalho;
	}

	public void setTrabalho(String trabalho) {
		Trabalho = trabalho;
	}

	public String getValidadeImagem() {
		return ValidadeImagem;
	}

	public void setValidadeImagem(String validadeImagem) {
		ValidadeImagem = validadeImagem;
	}

	public double getValorBruto() {
		return ValorBruto;
	}

	public void setValorBruto(double valorBruto) {
		ValorBruto = valorBruto;
	}

	public double getValorDisponivel() {
		return ValorDisponivel;
	}

	public void setValorDisponivel(double valorDisponivel) {
		ValorDisponivel = valorDisponivel;
	}

	public double getValorLiquido() {
		return ValorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		ValorLiquido = valorLiquido;
	}

	public double getValorLiquidoOriginal() {
		return ValorLiquidoOriginal;
	}

	public void setValorLiquidoOriginal(double valorLiquidoOriginal) {
		ValorLiquidoOriginal = valorLiquidoOriginal;
	}

	public double getValorUnitario() {
		return ValorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		ValorUnitario = valorUnitario;
	}

	public String getVersao() {
		return Versao;
	}

	public void setVersao(String versao) {
		Versao = versao;
	}

}
