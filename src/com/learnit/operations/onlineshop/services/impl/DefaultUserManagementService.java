package com.learnit.operations.onlineshop.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static DefaultUserManagementService instance;

	private List<User> users;

	{
		users = new ArrayList<User>();
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
		users.add(user);
		return NO_ERROR_MESSAGE;
		
//		"INSERT INTO users (first_name, last_name, password, email, role_id) VALUES(?,?,?,?,?)";		
//		(1, user.getFirstName());
//		(2, user.getLastName());
//		(3, user.getPassword());
//		(4, user.getEmail());
//		(5, "SELECT role_id FROM roles WHERE role_name = 'default_user'");
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
//		SELECT first_name, last_name FROM users WHERE email = ?;
//		(1, email);
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public List<User> getUsers() {
		List<User> newlist = new ArrayList<>();
		for (User user : users) {
			if (user != null) {
				newlist.add(user);
			}
		}
		return newlist;
		//SELECT * FROM users
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : users) {
			if (user != null && user.getEmail().equals(userEmail)) {
				return user;
			}
		}
		return null;
//		//SELECT * FROM users WHERE email = ?;
//		(1, user.getEmail());
	}

	void clearServiceState() {
		users.clear();
//		TRUNCATE TABLE users;
	}
}
