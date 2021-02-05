package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.UserRole;

public interface UserRoleDao {

	boolean addRole(UserRole role);

	boolean deleteRole(UserRole role);

	boolean deleteAllRoles();

	String getRoleNameById(int id);

	int getRoleIdByName(String roleName);

	UserRole getRoleById(int id);

	List<UserRole> getAllRoles();

}
