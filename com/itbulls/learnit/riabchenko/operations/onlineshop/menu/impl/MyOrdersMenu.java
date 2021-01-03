package com.itbulls.learnit.riabchenko.operations.onlineshop.menu.impl;

import com.itbulls.learnit.riabchenko.operations.onlineshop.config.ApplicationContext;
import com.itbulls.learnit.riabchenko.operations.onlineshop.menu.Menu;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
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
