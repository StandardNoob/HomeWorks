package com.itbulls.learnit.riabchenko.operations.onlineshop.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Order;
import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.User;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;

	private static DefaultUserManagementService instance;

	private User[] users;

	{
		users = new User[DEFAULT_USERS_CAPACITY];
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		if (user == null) {
			return NO_ERROR_MESSAGE;
		}
		String errorMassege = checkUniqueEmail(user.getEmail());
		if (errorMassege != null && !errorMassege.isEmpty()) {
			return errorMassege;
		}
		ArrayList<User> listOfUsers = new ArrayList<>(Arrays.asList(users));
		listOfUsers.add(user);
		users = listOfUsers.toArray(User[]::new);
		return NO_ERROR_MESSAGE;
	}

	private String checkUniqueEmail(String email) {
		if (email == null || email.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		for (User user : users) {
			if (user != null && user.getEmail() != null && user.getEmail().equals(email)) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}
		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public User[] getUsers() {		
		ArrayList<User> newlist = new ArrayList<>();
		for (User user : users) {
			if (user != null) {
				newlist.add(user);
			}
		}
		User[] listOfUsersArr = newlist.toArray(User[]::new);
		return listOfUsersArr;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : users) {
			if (user != null && user.getEmail().equals(userEmail)) {
				return user;
			}
		}
		return null;
	}

	void clearServiceState() {
		users = new User[DEFAULT_USERS_CAPACITY];
	}
}
