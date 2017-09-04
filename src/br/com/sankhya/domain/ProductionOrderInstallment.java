package br.com.sankhya.domain;

public class ProductionOrderInstallment {

	public ProductionOrderInstallment() {

	}

	private int CodigoCliente;
	private int CodigoFornecedor;
	private String Complemento;
	private String Fatura;
	private int FaturaEmpresa;
	private int Id;
	private String IdFat;
	private String NomeCliente;
	private String NomeFornecedor;
	private double Percentual;
	private String PrazoPagamento;
	private String Situacao;
	private String Tag;
	private double Valor;

	public int getCodigoCliente() {
		return CodigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		CodigoCliente = codigoCliente;
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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getIdFat() {
		return IdFat;
	}

	public void setIdFat(String idFat) {
		IdFat = idFat;
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

	public double getPercentual() {
		return Percentual;
	}

	public void setPercentual(double percentual) {
		Percentual = percentual;
	}

	public String getPrazoPagamento() {
		return PrazoPagamento;
	}

	public void setPrazoPagamento(String prazoPagamento) {
		PrazoPagamento = prazoPagamento;
	}

	public String getSituacao() {
		return Situacao;
	}

	public void setSituacao(String situacao) {
		Situacao = situacao;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

}
