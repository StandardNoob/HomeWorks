package com.learnit.operations.onlineshop.enteties.impl;

import com.learnit.operations.onlineshop.enteties.UserRole;

public class DefaultUserRole implements UserRole {

	private int roleId;
	private String roleName;

	public DefaultUserRole() {
	}

	public DefaultUserRole(String roleName) {
		this.roleName = roleName;
	}

	public DefaultUserRole(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public boolean addRole(UserRole role) {
		return false;
	}

	@Override
	public boolean deleteRole(UserRole role) {
		return false;
	}

	@Override
	public String getRoleNameById(int id) {
		return null;
	}

	@Override
	public UserRole getRoleById(int id) {
		return null;
	}

	@Override
	public String toString() {
		return "DefaultUserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
