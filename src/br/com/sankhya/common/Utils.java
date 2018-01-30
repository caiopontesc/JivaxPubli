package br.com.sankhya.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

	/**
	 * Pega da atual no formato yyyy-MM-dd
	 * 
	 * @return String com data no formato yyyy-MM-dd
	 */
	public static String GetDateTimeNowYYYYMMDD() {

		String validDate = "";
		Date dateobj = new Date();

		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			validDate = df.format(dateobj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return validDate;
	}

	/**
	 * Pega data atual
	 * 
	 * @return Retorna a String com data atual em formato YYYYMMDD
	 */
	public static String GetYesterdayDateYYYYMMDD() {

		String validDate = "";
		Date dateobj;

		try {

			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);

			dateobj = cal.getTime();

			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

			validDate = df.format(dateobj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return validDate;

	}

	/**
	 * Pega data de ontem
	 * 
	 * @return Retorna a String com data de ontem em formato YYMMDD
	 */
	public static String GetYesterdayDateYYMMDD() {

		String validDate = "";
		Date dateobj;

		try {

			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -7);

			dateobj = cal.getTime();

			DateFormat df = new SimpleDateFormat("yyMMdd");

			validDate = df.format(dateobj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return validDate;

	}

	/**
	 * Converte Microsoft JSON Date para dd/MM/yyyy
	 * 
	 * @param msDate
	 * @return Converte Microsoft JSON Date para o formato dd/MM/yyyy
	 */
	public static String ConvertMSJSONDateToDate(String msDate) {
		
		String date = "";

		try {

			long milliSeconds = 0;

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			if (msDate != null && !msDate.isEmpty()) {

				if (msDate.substring(6).equalsIgnoreCase("-")) {
					milliSeconds = Long.parseLong(msDate.substring(7, 20));
				} else {
					milliSeconds = Long.parseLong(msDate.substring(6, 19));
				}

			}

			TimeZone.setDefault(TimeZone.getTimeZone("America/Brasilia"));
			Calendar calendar = Calendar.getInstance();

			calendar.setTimeInMillis(milliSeconds);

			date = formatter.format(calendar.getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * Remove caracteres especiais
	 * 
	 * @param initial
	 * @return Remove caracteres especiais de uma string
	 */
	public static String RemoveSpecialCharacters(String initial) {

		String result = "";

		try {

			if (initial != null && !initial.isEmpty()) {
				// result = initial.replaceAll("[-+.^:,/()]", "");
				result = initial.replaceAll("[^a-zA-Z0-9]", "");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result.trim();
	}

	/**
	 * Converte HTTP Response InputStream para uma String JSON
	 * 
	 * @param input
	 * @return String JSON
	 */
	public static String ConvertInputStreamToJsonString(InputStream input) {

		String output = "";
		String json = "";

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(input));

			while ((output = br.readLine()) != null) {

				if (!output.isEmpty()) {
					json += output;
				} else {
					json = output;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}

	public static String CalculatesComission(Double liquidVal, Double percentual) {

		String commission = "";

		try {

			Double coefficient = liquidVal + ((liquidVal * 25) / 100);
			commission = Double.toString(((coefficient * percentual) / 100));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return commission;
	}

	public static String RemoveLeftZeros(String initial) {

		String result = "";

		try {

			result = Integer.toString(Integer.parseInt(initial.replaceAll("[a-zA-Z]", "")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public static String removeInvalidXMLCharacters(String s) {
		StringBuilder out = new StringBuilder();

		int codePoint;
		int i = 0;

		while (i < s.length()) {
			// This is the unicode code of the character.
			codePoint = s.codePointAt(i);
			if ((codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
					|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
					|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
					|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF))) {
				out.append(Character.toChars(codePoint));
			}
			i += Character.charCount(codePoint);
		}

		// System.out.println(out.toString());
		return out.toString();
	}

	public static Date GetInvoicedOrderIntervalDateDDMMYYYY() {

		String validDate = "";
		Date dateobj = null;

		try {

			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -5);

			dateobj = cal.getTime();

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			validDate = df.format(dateobj);

			dateobj = df.parse(validDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateobj;
	}

	public static Date GetDateTimeNowDDMMYYY() {

		String validDate = "";
		Date dateobj = new Date();

		try {

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			validDate = df.format(dateobj);

			dateobj = df.parse(validDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateobj;
	}

}
