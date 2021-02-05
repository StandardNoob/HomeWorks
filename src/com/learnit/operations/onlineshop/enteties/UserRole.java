package com.learnit.operations.onlineshop.enteties;

public interface UserRole {

	boolean addRole(UserRole role);

	boolean deleteRole(UserRole role);

	String getRoleNameById(int id);

	String getRoleName();

	int getRoleId();

	void setRoleName(String roleName);

	UserRole getRoleById(int id);

}
