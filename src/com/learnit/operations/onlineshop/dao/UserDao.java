package com.learnit.operations.onlineshop.dao;

import java.util.List;
import com.learnit.operations.onlineshop.enteties.User;

public interface UserDao {

	boolean registerUser(User user);

	boolean checkUniqueEmail(String email);

	boolean changeEmail(User user, String newEmail);

	boolean changePassword(User user, String newPassword);

	boolean changeFirstName(User user, String newFirstName);

	boolean changeLastName(User user, String newLastName);

	boolean deleteUser(User user);

	boolean deleteAllUsers();

	User getUserByEmail(String email);

	User getUserByID(int id);

	List<User> getUsers();

}
