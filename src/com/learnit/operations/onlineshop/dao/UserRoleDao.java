package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.UserRole;

public interface UserRoleDao {
	
	boolean addRole(UserRole role);
	
	boolean deleteRole(UserRole role);
	
	String getRoleNameById(int id);	
	
	UserRole getRoleById(int id);
	
	int getRoleIdByName(String roleName);
	
	List<UserRole> getAllRoles();
	
	boolean deleteAllRoles();
}
