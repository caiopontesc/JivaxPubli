package br.com.sankhya.domain;

public class Address {
	private String cep;
	private String codEnd;
	private String codBai;
	private String codCid;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCodEnd() {
		return codEnd;
	}

	public void setCodEnd(String codEnd) {
		this.codEnd = codEnd;
	}

	public String getCodBai() {
		return codBai;
	}

	public void setCodBai(String codBai) {
		this.codBai = codBai;
	}

	public String getCodCid() {
		return codCid;
	}

	public void setCodCid(String codCid) {
		this.codCid = codCid;
	}

}
