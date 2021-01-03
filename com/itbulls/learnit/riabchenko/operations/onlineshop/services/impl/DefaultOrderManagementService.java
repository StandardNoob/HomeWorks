package com.itbulls.learnit.riabchenko.operations.onlineshop.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Order;
import com.itbulls.learnit.riabchenko.operations.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;
	private static DefaultOrderManagementService instance;
	private Order[] orders;

	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {		
		ArrayList<Order> newList = new ArrayList<>(Arrays.asList(orders));		
		if (order != null) {
			newList.add(order);
		}
		orders = newList.toArray(Order[]::new);
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		ArrayList<Order> newList = new ArrayList<>();
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				newList.add(order);
			}
		}
		Order[] listAfterSortArr = newList.toArray(Order[]::new);
		return listAfterSortArr;
	}

	@Override
	public Order[] getOrders() {		
		ArrayList<Order> newlist = new ArrayList<>();
		for (Order order : orders) {
			if (order != null) {
				newlist.add(order);
			}
		}
		Order[] listOfOrdersArr = newlist.toArray(Order[]::new);
		return listOfOrdersArr;
	}

	void clearServiceState() {
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}
}
