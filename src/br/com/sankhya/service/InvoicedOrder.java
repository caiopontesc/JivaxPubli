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
		return company;
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
		return invoiceCompany;
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

}
