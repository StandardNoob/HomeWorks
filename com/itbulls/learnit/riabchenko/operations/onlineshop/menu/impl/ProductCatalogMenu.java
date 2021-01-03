package com.itbulls.learnit.riabchenko.operations.onlineshop.menu.impl;

import com.itbulls.learnit.riabchenko.operations.onlineshop.config.ApplicationContext;
import com.itbulls.learnit.riabchenko.operations.onlineshop.menu.Menu;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.ProductManagementService;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
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
