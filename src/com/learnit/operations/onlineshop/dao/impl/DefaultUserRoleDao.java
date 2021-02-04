package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.UserRoleDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.UserRole;
import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUser;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUserRole;

public class DefaultUserRoleDao implements UserRoleDao {

	@Override
	public boolean addRole(UserRole role) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO roles (role_name) VALUES(?)")) {
			ps.setString(1, role.getRoleName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRole(UserRole role) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM roles WHERE role_id = ?")) {
			ps.setInt(1, role.getRoleId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getRoleNameById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles WHERE role_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getString("role_name");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserRole getRoleById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles WHERE role_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				var role = new DefaultUserRole();
				if (rs.next()) {
					role.setRoleId(rs.getInt("role_id"));
					role.setRoleName(rs.getString("role_name"));
					return role;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserRole> getAllRoles() {
		List<UserRole> listOfRoles = new ArrayList<>();
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var role = new DefaultUserRole();
					role.setRoleId(rs.getInt("role_id"));
					role.setRoleName(rs.getString("role_name"));
					listOfRoles.add(role);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfRoles;
	}

	@Override
	public int getRoleIdByName(String roleName) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM roles WHERE role_name = ?");) {
			ps.setString(1, roleName);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("role_id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deleteAllRoles() {
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE roles")) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
