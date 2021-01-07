package com.learnit.operations.onlineshop.menu.impl;

import com.learnit.operations.onlineshop.config.ApplicationContext;
import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.menu.Menu;
import com.learnit.operations.onlineshop.services.UserManagementService;
import com.learnit.operations.onlineshop.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		User[] users = userManagementService.getUsers();
		if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			System.out.println();
			System.out.println("Here is a list of all users: ");
			for (User user : users) {
				System.out.println(user);
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println();
		System.out.println("***** USERS *****");
	}

}
