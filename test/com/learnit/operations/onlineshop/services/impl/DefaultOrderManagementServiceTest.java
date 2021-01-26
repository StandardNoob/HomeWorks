package com.learnit.operations.onlineshop.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultOrder;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUser;

@DisplayName("Tests DefaultOrderManagementService for online shop")
class DefaultOrderManagementServiceTest {

	private static DefaultOrderManagementService instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = (DefaultOrderManagementService) instance.getInstance();
		instance.clearServiceState();
	}

	@Test
	void shouldAddOrderWhenOderIsNotNull() {
		Order order = new DefaultOrder();
		instance.addOrder(order);
		assertEquals(instance.getOrders().size(), 1);
	}

	@Test
	void shouldDontAddOrderWhenOderIsNull() {
		Order order = null;
		instance.addOrder(order);
		assertEquals(instance.getOrders().size(), 0);
	}

	@Test
	void shouldGetOrdersByUserId() {
		Order order = new DefaultOrder();
		Order order2 = new DefaultOrder();
		Order order3 = new DefaultOrder();
		User user = new DefaultUser();
		order2.setCustomerId(user.getId());
		order3.setCustomerId(user.getId());
		instance.addOrder(order);
		instance.addOrder(order2);
		instance.addOrder(order3);
		List<Order> list = new ArrayList<Order>();
		list.add(order2);
		list.add(order3);
		assertEquals(instance.getOrdersByUserId(user.getId()).containsAll(list)
				&& instance.getOrdersByUserId(user.getId()).size() == list.size(), true);
	}

	@Test
	void shouldReturnAllOrders() {
		Order order = new DefaultOrder();
		Order order2 = new DefaultOrder();
		Order order3 = new DefaultOrder();
		instance.addOrder(order);
		instance.addOrder(order2);
		instance.addOrder(order3);
		List<Order> list = new ArrayList<Order>();
		list.add(order);
		list.add(order2);
		list.add(order3);
		assertEquals(instance.getOrders().containsAll(list) && instance.getOrders().size() == list.size(), true);
	}
	
	@Test
	void shouldClearServiceState() {
		Order order = new DefaultOrder();
		Order order2 = new DefaultOrder();
		Order order3 = new DefaultOrder();
		instance.addOrder(order);
		instance.addOrder(order2);
		instance.addOrder(order3);
		instance.clearServiceState();
		assertEquals(instance.getOrders().size(), 0);
	}
}
