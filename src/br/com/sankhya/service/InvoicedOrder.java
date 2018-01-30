package br.com.sankhya.service;

public class InvoicedOrder {
	private String docType;
	private String docNumber;
	private String dtSituation;
	private String flagSituation;
	private String company;
	private String invoiceNumber;
	private String invoiceCompany;
	private String invoiceType;
	private String TOP;
	private String NUNOTA;
	private String empresa;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getDtSituation() {
		return dtSituation;
	}

	public void setDtSituation(String dtSituation) {
		this.dtSituation = dtSituation;
	}

	public String getFlagSituation() {
		return flagSituation;
	}

	public void setFlagSituation(String flagSituation) {
		this.flagSituation = flagSituation;
	}

	public String getCompany() {
		String result = "1";
		
		if ("BG9 AL".equals(empresa)) {
			result = "3";
		}

		return result;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceCompany() {
		String result = "1";
		
		if ("BG9 AL".equals(empresa)) {
			result = "3";
		}

		return result;
	}

	public void setInvoiceCompany(String invoiceCompany) {
		this.invoiceCompany = invoiceCompany;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getTOP() {
		return TOP;
	}

	public void setTOP(String tOP) {
		TOP = tOP;
	}

	public String getNUNOTA() {
		return NUNOTA;
	}

	public void setNUNOTA(String nUNOTA) {
		NUNOTA = nUNOTA;
	}

	@Override
	public String toString() {
		return "InvoicedOrder [docType=" + docType + ", docNumber=" + docNumber + ", dtSituation=" + dtSituation
				+ ", flagSituation=" + flagSituation + ", company=" + company + ", invoiceNumber=" + invoiceNumber
				+ ", invoiceCompany=" + invoiceCompany + ", invoiceType=" + invoiceType + ", TOP=" + TOP + ", NUNOTA="
				+ NUNOTA + "]";
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
