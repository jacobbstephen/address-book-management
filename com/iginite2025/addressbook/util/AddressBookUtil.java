package com.iginite2025.addressbook.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressBookUtil {
	final static String JDBC_DRIVER = "org.h2.Driver";
	static {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		final String JDBC_URL = "jdbc:h2:tcp://localhost/D:/h2-db/learn";
		final String JDBC_USERNAME = "";
		final String JDBC_PASSWORD = "";
		return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
	}
}
