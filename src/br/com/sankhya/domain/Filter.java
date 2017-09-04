package br.com.sankhya.domain;

public class Filter {

	private String Field;
	private String Value;
	private int Comparative;
	private int Connective;
	private int Parenteses;
	private boolean Conditional;

	public Filter() {

	}

	public Filter(String field, String value, int comparative, int connective, int parenteses, boolean conditional) {
		Field = field;
		Value = value;
		Comparative = comparative;
		Connective = connective;
		Parenteses = parenteses;
		Conditional = conditional;

	}

	public String getField() {
		return Field;
	}

	public void setField(String field) {
		Field = field;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public int getComparative() {
		return Comparative;
	}

	public void setComparative(int comparative) {
		Comparative = comparative;
	}

	public int getConnective() {
		return Connective;
	}

	public void setConnective(int connective) {
		Connective = connective;
	}

	public int getParenteses() {
		return Parenteses;
	}

	public void setParenteses(int parenteses) {
		Parenteses = parenteses;
	}

	public boolean isConditional() {
		return Conditional;
	}

	public void setConditional(boolean conditional) {
		Conditional = conditional;
	}

}
