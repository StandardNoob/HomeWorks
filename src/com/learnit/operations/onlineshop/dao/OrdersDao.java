package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.User;

public interface OrdersDao {
	
	boolean addOrder(Order order);
	
	List<Order> getOrdersByUserId(User user);
	
	List<Order> getOrders();
	
	boolean deleteOrder(Order order); 
	
	boolean deleteAllOrders();

}
