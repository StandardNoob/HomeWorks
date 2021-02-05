package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.UserDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUser;

public class DefaulUserDao implements UserDao {

	@Override
	public boolean registerUser(User user) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO users (first_name, last_name, password, email, role_id) VALUES(?,?,?,?,?)")) {
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole().getRoleId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM users")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					if (rs.getString("email").equals(email)) {
						return false;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<User> getUsers() {
		List<User> listOfUsers = new ArrayList<User>();
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM users")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var user = new DefaultUser();
					user.setId(rs.getInt("customer_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					listOfUsers.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}

	@Override
	public User getUserByEmail(String email) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ?");) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					var user = new DefaultUser();
					user.setId(rs.getInt("customer_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByID(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE customer_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					var user = new DefaultUser();
					user.setId(rs.getInt("customer_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean changeEmail(User user, String newEmail) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE users SET email = ? WHERE customer_id = ?")) {
			ps.setString(1, newEmail);
			ps.setInt(2, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePassword(User user, String newPassword) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE users SET password = ? WHERE customer_id = ?")) {
			ps.setString(1, newPassword);
			ps.setInt(2, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeFirstName(User user, String newFirstName) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE users SET first_name = ? WHERE customer_id = ?")) {
			ps.setString(1, newFirstName);
			ps.setInt(2, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeLastName(User user, String newLastName) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE users SET last_name = ? WHERE customer_id = ?")) {
			ps.setString(1, newLastName);
			ps.setInt(2, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE customer_id = ?")) {
			ps.setInt(1, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllUsers() {
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE users")) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
