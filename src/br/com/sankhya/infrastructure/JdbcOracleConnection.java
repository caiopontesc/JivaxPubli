package br.com.sankhya.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcOracleConnection {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@jiva.grupoduca.com.br:1521:XE";
	private static final String DB_USER = "jiva";
	private static final String DB_PASSWORD = "7BNdnvqR";

	public static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		return dbConnection;

	}

}