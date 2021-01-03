package com.itbulls.learnit.riabchenko.operations.onlineshop.menu.impl;

import com.itbulls.learnit.riabchenko.operations.onlineshop.config.ApplicationContext;
import com.itbulls.learnit.riabchenko.operations.onlineshop.menu.Menu;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.UserManagementService;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
	}

}