package com.learnit.operations.onlineshop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	private static final String DB_URL = "jdbc:mysql://192.168.1.206:3306/online_shop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		try {
			Class.forName(DB_DRIVER);
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
