package br.com.sankhya.domain;

import java.util.ArrayList;

public class PubliGetListParam {

	private ArrayList<String> Fields;
	private ArrayList<Filter> Filters;
	private String FreeFilter;
	private String Limit;
	private int OffSet;
	private String Options;
	private String IdRegusu;

	public PubliGetListParam() {
		this.setFields(new ArrayList<String>());
		this.setFilters(new ArrayList<Filter>());
	}

	public String getIdRegUsu() {
		return IdRegusu;
	}

	public void setIdRegUsu(String idRegUsu) {
		IdRegusu = idRegUsu;
	}

	public ArrayList<String> getFields() {
		return Fields;
	}

	public void setFields(ArrayList<String> fields) {
		Fields = fields;
	}

	public ArrayList<Filter> getFilters() {
		return Filters;
	}

	public void setFilters(ArrayList<Filter> filters) {
		Filters = filters;
	}

	public String getFreeFilter() {
		return FreeFilter;
	}

	public void setFreeFilter(String freeFilter) {
		FreeFilter = freeFilter;
	}

	public String getLimit() {
		return Limit;
	}

	public void setLimit(String limit) {
		Limit = limit;
	}

	public int getOffSet() {
		return OffSet;
	}

	public void setOffSet(int offSet) {
		OffSet = offSet;
	}

	public String getOptions() {
		return Options;
	}

	public void setOptions(String options) {
		Options = options;
	}

}
