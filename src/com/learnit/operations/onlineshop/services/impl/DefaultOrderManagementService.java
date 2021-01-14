package com.learnit.operations.onlineshop.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {
	
	private static DefaultOrderManagementService instance;
	private List<Order> orders;

	{
		orders = new ArrayList<Order>();
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {				
		if (order != null) {
			orders.add(order);
		}		
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		ArrayList<Order> newList = new ArrayList<>();
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				newList.add(order);
			}
		}		
		return newList;
	}

	@Override
	public List<Order> getOrders() {		
		ArrayList<Order> newlist = new ArrayList<>();
		for (Order order : orders) {
			if (order != null) {
				newlist.add(order);
			}
		}		
		return newlist;
	}

	void clearServiceState() {
		orders = new ArrayList<Order>();
	}
}
