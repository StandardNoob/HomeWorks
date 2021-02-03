package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.dao.impl.DefaulUserDao;
import com.learnit.operations.onlineshop.dao.models.UserModel;

public class Main {

	public static void main(String[] args) {

		UserDao userDao = new DefaulUserDao();
		UserModel userByID = userDao.getUserByID(1);
		List<UserModel> allUsers = userDao.getAllUsers();
		for (UserModel userModel : allUsers) {
			System.out.println(userModel.toString());
		}
	}
}