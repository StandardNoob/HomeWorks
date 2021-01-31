package com.learnit.operations.onlineshop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUser;

public class TestDBConnection {

	private static final String DB_URL = "jdbc:mysql://192.168.1.206:3306/online_shop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DB_DRIVER);

		DefaultUser user = new DefaultUser("Alexandr", "Riabchenko", "123456", "gmail.com");

//		insertUserIntoDB(user);
//		updateUserInDb(user, "first_name", "Vova");
		getAllUsersFromDB();
//		getUserByID(5);
//		deleteUserByEmail("email.com");

	}

	public static void insertUserIntoDB(User user) {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String insertTableSQL = "INSERT INTO users (first_name, last_name, password, email) VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertTableSQL);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.executeUpdate();
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateUserInDb(User user, String columnToUpdate, String valueToUpdate) {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String updateTableSQL = "UPDATE users SET " + columnToUpdate + " = '" + valueToUpdate + "' WHERE email ='"
					+ user.getEmail() + "'";
			Statement statement = connection.createStatement();
			statement.executeUpdate(updateTableSQL);
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getAllUsersFromDB() {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String selectAllUsers = "SELECT * FROM users";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectAllUsers);
			while (rs.next()) {
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getUserByID(int id) {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String selectUserByID = "SELECT * FROM users WHERE customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(selectUserByID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			DefaultUser defaultUser = null;
			if (rs.next()) {
				defaultUser = new DefaultUser(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("password"), rs.getString("email"));
			}
			connection.close();
			statement.close();
			System.out.println(defaultUser.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteUserByEmail(String emailForDelete) {
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String deleteUserByEmail = "DELETE FROM users WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(deleteUserByEmail);
			statement.setString(1, emailForDelete);
			statement.executeUpdate();
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
