package br.com.sankhya.domain;

public class Provider {
	private boolean Checked;
	private String DataAlteracao;
	private String DataInclusao;
	private String DataManutencao;
	private String GuidAnexo;
	private String HoraAlteracao;
	private int Id;
	private int IdRegUsu;
	private int IdUsuarioAlteracao;
	private int IdUsuarioInclusao;
	private String UId;
	private String UsuarioAlteracao;
	private String UsuarioInclusao;
	private boolean AdicionaComissaoNoPrograma;
	private String AgenciaPagamento;
	private String Apelido;
	private String Bairro;
	private String BairroCobranca;
	private String BancoPagamento;
	private boolean CalculaInss;
	private boolean CalculoArredondamentoMidia;
	private String CentroCustoDespesa;
	private String CentroCustoReceita;
	private String Cep;
	private String CepCobranca;
	private String Classificacao1;
	private String Classificacao2;
	private String Classificacao3;
	private String Classificacao4;
	private String Classificacao5;
	private String Cnpj;
	private String CnpjPagamento;
	private int Codigo;
	private String CodigoAgencia;
	private int CodigoDepara;
	private int CodigoEmpresaImpressaoPedidos;
	private String CodigoIbope;
	private String CodigoIssServico;
	private double CodigoSecom;
	private String CodigoTabela;
	private String CondicaoPedido;
	private String CondicoesFatura;
	private String ContaCorrentePagamento;
	private String ContaCorrenteTipo;
	private String Contato;
	private String Contratos;
	private String CtbContaCliente;
	private String CtbContaDespesa;
	private String CtbContaPassivo;
	private String CtbContaPassivoDespesa;
	private String DataPerfil;
	private String Email;
	private String EmailPagamento;
	private int Empresa;
	private String Endereco;
	private String EnderecoCobranca;
	private String EnderecoEntregaPi;
	private String Estado;
	private String EstadoCobranca;
	private boolean FaturaCalcularImpostosSobreTotal;
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
	private String Fax;
	private String Fj;
	private String Fj_pag;
	private String GrupoBV;
	private String HomePage;
	private String Idade;
	private String Idade2;
	private String Idade3;
	private String Idade4;
	private String Idade5;
	private int ImpostoSobreSelo;
	private boolean ImprimeEnderecoAgencia;
	private boolean ImprimeImpostoSelo;
	private String Indicador;
	private String IndicadorFaturamento;
	private String InscricaoEstadual;
	private String InscricaoMunicipal;
	private String Inss;
	private String LiberacaoPagamento;
	private boolean Mei;
	private String MostraImpostoSelo;
	private String Municipio;
	private String MunicipioCobranca;
	private boolean NaoImprimeLiquido;
	private boolean NaoReterImpostos;
	private String Nome;
	private String NomePagamento;
	private String Observacao;
	private String ObservacaoPerfil;
	private String ObservacoesPlano;
	private boolean OptantePeloSimples;
	private String Pais;
	private double PercentualBV;
	private double PercentualClassificacao1;
	private double PercentualClassificacao2;
	private double PercentualClassificacao3;
	private double PercentualClassificacao4;
	private double PercentualClassificacao5;
	private double PercentualCofins;
	private double PercentualCriancas;
	private double PercentualCsll;
	private double PercentualEncargosSobreTerceiros;
	private double PercentualHomens;
	private double PercentualHonorariosComissao;
	private double PercentualIdade1;
	private double PercentualIdade2;
	private double PercentualIdade3;
	private double PercentualIdade4;
	private double PercentualIdade5;
	private double PercentualImpostoSelo;
	private double PercentualIr;
	private double PercentualIss;
	private double PercentualMulheres;
	private double PercentualPis;
	private String Perfil;
	private boolean PermiteVeicularOutrasPracas;
	private String Pis;
	private String Praca;
	private String PrazoPagamento;
	private String PrazoRecebimento;
	private String Prazos;
	private String PrefixoPedidoMidia;
	private String Produtos;
	private String RazaoSocial;
	private String Rede;
	private String RedeAudiencia;
	private String Representante;
	private boolean ReterCofins;
	private boolean ReterCsll;
	private boolean ReterIrrf;
	private boolean ReterIssRf;
	private boolean ReterPis;
	private String SenhaWS;
	private String SenhaWSOld;
	private String Situacao;
	private String SituacaoDescricao;
	private String Sped;
	private String SpedNaturezaRetencao;
	private String Telefone;
	private String Telex;
	private String Tipo;
	private int TipoCnpj;
	private String TipoIssRetido;

	public Provider() {

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

	public String getGuidAnexo() {
		return GuidAnexo;
	}

	public void setGuidAnexo(String guidAnexo) {
		GuidAnexo = guidAnexo;
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

	public boolean isAdicionaComissaoNoPrograma() {
		return AdicionaComissaoNoPrograma;
	}

	public void setAdicionaComissaoNoPrograma(boolean adicionaComissaoNoPrograma) {
		AdicionaComissaoNoPrograma = adicionaComissaoNoPrograma;
	}

	public String getAgenciaPagamento() {
		return AgenciaPagamento;
	}

	public void setAgenciaPagamento(String agenciaPagamento) {
		AgenciaPagamento = agenciaPagamento;
	}

	public String getApelido() {
		return Apelido;
	}

	public void setApelido(String apelido) {
		Apelido = apelido;
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

	public String getBancoPagamento() {
		return BancoPagamento;
	}

	public void setBancoPagamento(String bancoPagamento) {
		BancoPagamento = bancoPagamento;
	}

	public boolean isCalculaInss() {
		return CalculaInss;
	}

	public void setCalculaInss(boolean calculaInss) {
		CalculaInss = calculaInss;
	}

	public boolean isCalculoArredondamentoMidia() {
		return CalculoArredondamentoMidia;
	}

	public void setCalculoArredondamentoMidia(boolean calculoArredondamentoMidia) {
		CalculoArredondamentoMidia = calculoArredondamentoMidia;
	}

	public String getCentroCustoDespesa() {
		return CentroCustoDespesa;
	}

	public void setCentroCustoDespesa(String centroCustoDespesa) {
		CentroCustoDespesa = centroCustoDespesa;
	}

	public String getCentroCustoReceita() {
		return CentroCustoReceita;
	}

	public void setCentroCustoReceita(String centroCustoReceita) {
		CentroCustoReceita = centroCustoReceita;
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

	public String getClassificacao1() {
		return Classificacao1;
	}

	public void setClassificacao1(String classificacao1) {
		Classificacao1 = classificacao1;
	}

	public String getClassificacao2() {
		return Classificacao2;
	}

	public void setClassificacao2(String classificacao2) {
		Classificacao2 = classificacao2;
	}

	public String getClassificacao3() {
		return Classificacao3;
	}

	public void setClassificacao3(String classificacao3) {
		Classificacao3 = classificacao3;
	}

	public String getClassificacao4() {
		return Classificacao4;
	}

	public void setClassificacao4(String classificacao4) {
		Classificacao4 = classificacao4;
	}

	public String getClassificacao5() {
		return Classificacao5;
	}

	public void setClassificacao5(String classificacao5) {
		Classificacao5 = classificacao5;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public String getCnpjPagamento() {
		return CnpjPagamento;
	}

	public void setCnpjPagamento(String cnpjPagamento) {
		CnpjPagamento = cnpjPagamento;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getCodigoAgencia() {
		return CodigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		CodigoAgencia = codigoAgencia;
	}

	public int getCodigoDepara() {
		return CodigoDepara;
	}

	public void setCodigoDepara(int codigoDepara) {
		CodigoDepara = codigoDepara;
	}

	public int getCodigoEmpresaImpressaoPedidos() {
		return CodigoEmpresaImpressaoPedidos;
	}

	public void setCodigoEmpresaImpressaoPedidos(int codigoEmpresaImpressaoPedidos) {
		CodigoEmpresaImpressaoPedidos = codigoEmpresaImpressaoPedidos;
	}

	public String getCodigoIbope() {
		return CodigoIbope;
	}

	public void setCodigoIbope(String codigoIbope) {
		CodigoIbope = codigoIbope;
	}

	public String getCodigoIssServico() {
		return CodigoIssServico;
	}

	public void setCodigoIssServico(String codigoIssServico) {
		CodigoIssServico = codigoIssServico;
	}

	public double getCodigoSecom() {
		return CodigoSecom;
	}

	public void setCodigoSecom(double codigoSecom) {
		CodigoSecom = codigoSecom;
	}

	public String getCodigoTabela() {
		return CodigoTabela;
	}

	public void setCodigoTabela(String codigoTabela) {
		CodigoTabela = codigoTabela;
	}

	public String getCondicaoPedido() {
		return CondicaoPedido;
	}

	public void setCondicaoPedido(String condicaoPedido) {
		CondicaoPedido = condicaoPedido;
	}

	public String getCondicoesFatura() {
		return CondicoesFatura;
	}

	public void setCondicoesFatura(String condicoesFatura) {
		CondicoesFatura = condicoesFatura;
	}

	public String getContaCorrentePagamento() {
		return ContaCorrentePagamento;
	}

	public void setContaCorrentePagamento(String contaCorrentePagamento) {
		ContaCorrentePagamento = contaCorrentePagamento;
	}

	public String getContaCorrenteTipo() {
		return ContaCorrenteTipo;
	}

	public void setContaCorrenteTipo(String contaCorrenteTipo) {
		ContaCorrenteTipo = contaCorrenteTipo;
	}

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public String getContratos() {
		return Contratos;
	}

	public void setContratos(String contratos) {
		Contratos = contratos;
	}

	public String getCtbContaCliente() {
		return CtbContaCliente;
	}

	public void setCtbContaCliente(String ctbContaCliente) {
		CtbContaCliente = ctbContaCliente;
	}

	public String getCtbContaDespesa() {
		return CtbContaDespesa;
	}

	public void setCtbContaDespesa(String ctbContaDespesa) {
		CtbContaDespesa = ctbContaDespesa;
	}

	public String getCtbContaPassivo() {
		return CtbContaPassivo;
	}

	public void setCtbContaPassivo(String ctbContaPassivo) {
		CtbContaPassivo = ctbContaPassivo;
	}

	public String getCtbContaPassivoDespesa() {
		return CtbContaPassivoDespesa;
	}

	public void setCtbContaPassivoDespesa(String ctbContaPassivoDespesa) {
		CtbContaPassivoDespesa = ctbContaPassivoDespesa;
	}

	public String getDataPerfil() {
		return DataPerfil;
	}

	public void setDataPerfil(String dataPerfil) {
		DataPerfil = dataPerfil;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmailPagamento() {
		return EmailPagamento;
	}

	public void setEmailPagamento(String emailPagamento) {
		EmailPagamento = emailPagamento;
	}

	public int getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(int empresa) {
		Empresa = empresa;
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

	public String getEnderecoEntregaPi() {
		return EnderecoEntregaPi;
	}

	public void setEnderecoEntregaPi(String enderecoEntregaPi) {
		EnderecoEntregaPi = enderecoEntregaPi;
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

	public boolean isFaturaCalcularImpostosSobreTotal() {
		return FaturaCalcularImpostosSobreTotal;
	}

	public void setFaturaCalcularImpostosSobreTotal(boolean faturaCalcularImpostosSobreTotal) {
		FaturaCalcularImpostosSobreTotal = faturaCalcularImpostosSobreTotal;
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

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getFj() {
		return Fj;
	}

	public void setFj(String fj) {
		Fj = fj;
	}

	public String getFj_pag() {
		return Fj_pag;
	}

	public void setFj_pag(String fj_pag) {
		Fj_pag = fj_pag;
	}

	public String getGrupoBV() {
		return GrupoBV;
	}

	public void setGrupoBV(String grupoBV) {
		GrupoBV = grupoBV;
	}

	public String getHomePage() {
		return HomePage;
	}

	public void setHomePage(String homePage) {
		HomePage = homePage;
	}

	public String getIdade() {
		return Idade;
	}

	public void setIdade(String idade) {
		Idade = idade;
	}

	public String getIdade2() {
		return Idade2;
	}

	public void setIdade2(String idade2) {
		Idade2 = idade2;
	}

	public String getIdade3() {
		return Idade3;
	}

	public void setIdade3(String idade3) {
		Idade3 = idade3;
	}

	public String getIdade4() {
		return Idade4;
	}

	public void setIdade4(String idade4) {
		Idade4 = idade4;
	}

	public String getIdade5() {
		return Idade5;
	}

	public void setIdade5(String idade5) {
		Idade5 = idade5;
	}

	public int getImpostoSobreSelo() {
		return ImpostoSobreSelo;
	}

	public void setImpostoSobreSelo(int impostoSobreSelo) {
		ImpostoSobreSelo = impostoSobreSelo;
	}

	public boolean isImprimeEnderecoAgencia() {
		return ImprimeEnderecoAgencia;
	}

	public void setImprimeEnderecoAgencia(boolean imprimeEnderecoAgencia) {
		ImprimeEnderecoAgencia = imprimeEnderecoAgencia;
	}

	public boolean isImprimeImpostoSelo() {
		return ImprimeImpostoSelo;
	}

	public void setImprimeImpostoSelo(boolean imprimeImpostoSelo) {
		ImprimeImpostoSelo = imprimeImpostoSelo;
	}

	public String getIndicador() {
		return Indicador;
	}

	public void setIndicador(String indicador) {
		Indicador = indicador;
	}

	public String getIndicadorFaturamento() {
		return IndicadorFaturamento;
	}

	public void setIndicadorFaturamento(String indicadorFaturamento) {
		IndicadorFaturamento = indicadorFaturamento;
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

	public String getInss() {
		return Inss;
	}

	public void setInss(String inss) {
		Inss = inss;
	}

	public String getLiberacaoPagamento() {
		return LiberacaoPagamento;
	}

	public void setLiberacaoPagamento(String liberacaoPagamento) {
		LiberacaoPagamento = liberacaoPagamento;
	}

	public boolean isMei() {
		return Mei;
	}

	public void setMei(boolean mei) {
		Mei = mei;
	}

	public String getMostraImpostoSelo() {
		return MostraImpostoSelo;
	}

	public void setMostraImpostoSelo(String mostraImpostoSelo) {
		MostraImpostoSelo = mostraImpostoSelo;
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

	public boolean isNaoImprimeLiquido() {
		return NaoImprimeLiquido;
	}

	public void setNaoImprimeLiquido(boolean naoImprimeLiquido) {
		NaoImprimeLiquido = naoImprimeLiquido;
	}

	public boolean isNaoReterImpostos() {
		return NaoReterImpostos;
	}

	public void setNaoReterImpostos(boolean naoReterImpostos) {
		NaoReterImpostos = naoReterImpostos;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getNomePagamento() {
		return NomePagamento;
	}

	public void setNomePagamento(String nomePagamento) {
		NomePagamento = nomePagamento;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public String getObservacaoPerfil() {
		return ObservacaoPerfil;
	}

	public void setObservacaoPerfil(String observacaoPerfil) {
		ObservacaoPerfil = observacaoPerfil;
	}

	public String getObservacoesPlano() {
		return ObservacoesPlano;
	}

	public void setObservacoesPlano(String observacoesPlano) {
		ObservacoesPlano = observacoesPlano;
	}

	public boolean isOptantePeloSimples() {
		return OptantePeloSimples;
	}

	public void setOptantePeloSimples(boolean optantePeloSimples) {
		OptantePeloSimples = optantePeloSimples;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public double getPercentualBV() {
		return PercentualBV;
	}

	public void setPercentualBV(double percentualBV) {
		PercentualBV = percentualBV;
	}

	public double getPercentualClassificacao1() {
		return PercentualClassificacao1;
	}

	public void setPercentualClassificacao1(double percentualClassificacao1) {
		PercentualClassificacao1 = percentualClassificacao1;
	}

	public double getPercentualClassificacao2() {
		return PercentualClassificacao2;
	}

	public void setPercentualClassificacao2(double percentualClassificacao2) {
		PercentualClassificacao2 = percentualClassificacao2;
	}

	public double getPercentualClassificacao3() {
		return PercentualClassificacao3;
	}

	public void setPercentualClassificacao3(double percentualClassificacao3) {
		PercentualClassificacao3 = percentualClassificacao3;
	}

	public double getPercentualClassificacao4() {
		return PercentualClassificacao4;
	}

	public void setPercentualClassificacao4(double percentualClassificacao4) {
		PercentualClassificacao4 = percentualClassificacao4;
	}

	public double getPercentualClassificacao5() {
		return PercentualClassificacao5;
	}

	public void setPercentualClassificacao5(double percentualClassificacao5) {
		PercentualClassificacao5 = percentualClassificacao5;
	}

	public double getPercentualCofins() {
		return PercentualCofins;
	}

	public void setPercentualCofins(double percentualCofins) {
		PercentualCofins = percentualCofins;
	}

	public double getPercentualCriancas() {
		return PercentualCriancas;
	}

	public void setPercentualCriancas(double percentualCriancas) {
		PercentualCriancas = percentualCriancas;
	}

	public double getPercentualCsll() {
		return PercentualCsll;
	}

	public void setPercentualCsll(double percentualCsll) {
		PercentualCsll = percentualCsll;
	}

	public double getPercentualEncargosSobreTerceiros() {
		return PercentualEncargosSobreTerceiros;
	}

	public void setPercentualEncargosSobreTerceiros(double percentualEncargosSobreTerceiros) {
		PercentualEncargosSobreTerceiros = percentualEncargosSobreTerceiros;
	}

	public double getPercentualHomens() {
		return PercentualHomens;
	}

	public void setPercentualHomens(double percentualHomens) {
		PercentualHomens = percentualHomens;
	}

	public double getPercentualHonorariosComissao() {
		return PercentualHonorariosComissao;
	}

	public void setPercentualHonorariosComissao(double percentualHonorariosComissao) {
		PercentualHonorariosComissao = percentualHonorariosComissao;
	}

	public double getPercentualIdade1() {
		return PercentualIdade1;
	}

	public void setPercentualIdade1(double percentualIdade1) {
		PercentualIdade1 = percentualIdade1;
	}

	public double getPercentualIdade2() {
		return PercentualIdade2;
	}

	public void setPercentualIdade2(double percentualIdade2) {
		PercentualIdade2 = percentualIdade2;
	}

	public double getPercentualIdade3() {
		return PercentualIdade3;
	}

	public void setPercentualIdade3(double percentualIdade3) {
		PercentualIdade3 = percentualIdade3;
	}

	public double getPercentualIdade4() {
		return PercentualIdade4;
	}

	public void setPercentualIdade4(double percentualIdade4) {
		PercentualIdade4 = percentualIdade4;
	}

	public double getPercentualIdade5() {
		return PercentualIdade5;
	}

	public void setPercentualIdade5(double percentualIdade5) {
		PercentualIdade5 = percentualIdade5;
	}

	public double getPercentualImpostoSelo() {
		return PercentualImpostoSelo;
	}

	public void setPercentualImpostoSelo(double percentualImpostoSelo) {
		PercentualImpostoSelo = percentualImpostoSelo;
	}

	public double getPercentualIr() {
		return PercentualIr;
	}

	public void setPercentualIr(double percentualIr) {
		PercentualIr = percentualIr;
	}

	public double getPercentualIss() {
		return PercentualIss;
	}

	public void setPercentualIss(double percentualIss) {
		PercentualIss = percentualIss;
	}

	public double getPercentualMulheres() {
		return PercentualMulheres;
	}

	public void setPercentualMulheres(double percentualMulheres) {
		PercentualMulheres = percentualMulheres;
	}

	public double getPercentualPis() {
		return PercentualPis;
	}

	public void setPercentualPis(double percentualPis) {
		PercentualPis = percentualPis;
	}

	public String getPerfil() {
		return Perfil;
	}

	public void setPerfil(String perfil) {
		Perfil = perfil;
	}

	public boolean isPermiteVeicularOutrasPracas() {
		return PermiteVeicularOutrasPracas;
	}

	public void setPermiteVeicularOutrasPracas(boolean permiteVeicularOutrasPracas) {
		PermiteVeicularOutrasPracas = permiteVeicularOutrasPracas;
	}

	public String getPis() {
		return Pis;
	}

	public void setPis(String pis) {
		Pis = pis;
	}

	public String getPraca() {
		return Praca;
	}

	public void setPraca(String praca) {
		Praca = praca;
	}

	public String getPrazoPagamento() {
		return PrazoPagamento;
	}

	public void setPrazoPagamento(String prazoPagamento) {
		PrazoPagamento = prazoPagamento;
	}

	public String getPrazoRecebimento() {
		return PrazoRecebimento;
	}

	public void setPrazoRecebimento(String prazoRecebimento) {
		PrazoRecebimento = prazoRecebimento;
	}

	public String getPrazos() {
		return Prazos;
	}

	public void setPrazos(String prazos) {
		Prazos = prazos;
	}

	public String getPrefixoPedidoMidia() {
		return PrefixoPedidoMidia;
	}

	public void setPrefixoPedidoMidia(String prefixoPedidoMidia) {
		PrefixoPedidoMidia = prefixoPedidoMidia;
	}

	public String getProdutos() {
		return Produtos;
	}

	public void setProdutos(String produtos) {
		Produtos = produtos;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getRede() {
		return Rede;
	}

	public void setRede(String rede) {
		Rede = rede;
	}

	public String getRedeAudiencia() {
		return RedeAudiencia;
	}

	public void setRedeAudiencia(String redeAudiencia) {
		RedeAudiencia = redeAudiencia;
	}

	public String getRepresentante() {
		return Representante;
	}

	public void setRepresentante(String representante) {
		Representante = representante;
	}

	public boolean isReterCofins() {
		return ReterCofins;
	}

	public void setReterCofins(boolean reterCofins) {
		ReterCofins = reterCofins;
	}

	public boolean isReterCsll() {
		return ReterCsll;
	}

	public void setReterCsll(boolean reterCsll) {
		ReterCsll = reterCsll;
	}

	public boolean isReterIrrf() {
		return ReterIrrf;
	}

	public void setReterIrrf(boolean reterIrrf) {
		ReterIrrf = reterIrrf;
	}

	public boolean isReterIssRf() {
		return ReterIssRf;
	}

	public void setReterIssRf(boolean reterIssRf) {
		ReterIssRf = reterIssRf;
	}

	public boolean isReterPis() {
		return ReterPis;
	}

	public void setReterPis(boolean reterPis) {
		ReterPis = reterPis;
	}

	public String getSenhaWS() {
		return SenhaWS;
	}

	public void setSenhaWS(String senhaWS) {
		SenhaWS = senhaWS;
	}

	public String getSenhaWSOld() {
		return SenhaWSOld;
	}

	public void setSenhaWSOld(String senhaWSOld) {
		SenhaWSOld = senhaWSOld;
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

	public String getSped() {
		return Sped;
	}

	public void setSped(String sped) {
		Sped = sped;
	}

	public String getSpedNaturezaRetencao() {
		return SpedNaturezaRetencao;
	}

	public void setSpedNaturezaRetencao(String spedNaturezaRetencao) {
		SpedNaturezaRetencao = spedNaturezaRetencao;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getTelex() {
		return Telex;
	}

	public void setTelex(String telex) {
		Telex = telex;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getTipoCnpj() {
		return TipoCnpj;
	}

	public void setTipoCnpj(int tipoCnpj) {
		TipoCnpj = tipoCnpj;
	}

	public String getTipoIssRetido() {
		return TipoIssRetido;
	}

	public void setTipoIssRetido(String tipoIssRetido) {
		TipoIssRetido = tipoIssRetido;
	}

}
