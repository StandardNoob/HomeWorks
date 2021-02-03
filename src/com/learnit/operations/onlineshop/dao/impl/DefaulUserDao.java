package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.UserDao;
import com.learnit.operations.onlineshop.dao.models.UserModel;


public class DefaulUserDao implements UserDao {

	@Override
	public UserModel getUserByID(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE customer_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					var user = new UserModel();
					user.setId(rs.getInt("customer_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
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
	public List<UserModel> getAllUsers() {
		List<UserModel> listOfUsers= new ArrayList<UserModel>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");) {			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var user = new UserModel();
					user.setId(rs.getInt("customer_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
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
	public boolean saveUser(UserModel user) {
		
		return true;
	}

	@Override
	public boolean updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}

}

