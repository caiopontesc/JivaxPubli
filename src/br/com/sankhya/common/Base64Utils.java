package br.com.sankhya.common;

import java.nio.charset.StandardCharsets;

import javax.xml.bind.DatatypeConverter;

public class Base64Utils {

	private Base64Utils() {
	}

	public static String encode(String value) throws Exception {
		return DatatypeConverter.printBase64Binary(value.getBytes(StandardCharsets.UTF_8)); // use "utf-8" if java 6
	}

	public static String decode(String value) throws Exception {
		byte[] decodedValue = DatatypeConverter.parseBase64Binary(value);
		return new String(decodedValue, StandardCharsets.UTF_8); // use "utf-8" if java 6
	}
}
