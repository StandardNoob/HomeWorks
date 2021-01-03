package com.itbulls.learnit.riabchenko.operations.onlineshop.services;

import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
