package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.dao.models.UserModel;

public interface UserDao {

	UserModel getUserByID(int id);

	List<UserModel> getAllUsers();

	boolean saveUser(UserModel user);

	boolean updateUser(UserModel user);

}
