package com.learnit.operations.onlineshop.services;

import com.learnit.operations.onlineshop.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}