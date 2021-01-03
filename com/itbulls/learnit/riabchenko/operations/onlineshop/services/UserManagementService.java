package com.itbulls.learnit.riabchenko.operations.onlineshop.services;

import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}