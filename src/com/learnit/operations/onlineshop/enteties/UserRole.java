package com.learnit.operations.onlineshop.enteties;

public interface UserRole {	

	boolean addRole(UserRole role);

	boolean deleteRole(UserRole role);

	String getRoleNameById(int id);
	
	int getRoleId();
	
	String getRoleName();
	
	void setRoleName(String roleName);
	
	UserRole getRoleById(int id);

}
