package com.learnit.operations.onlineshop.enteties.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.enteties.Product;

@DisplayName("Tests DefaultCart for online shop")
class DefaultCartTest {

	private static DefaultCart instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = new DefaultCart();
	}

	@Test
	void shouldReturnTrueWhenCartEmpty() {
		assertEquals(instance.getProducts().size() == 0 || instance.getProducts() == null, instance.isEmpty());
	}

	@Test
	void shouldReturnFalseWhenCartNonEmpty() {
		instance.addProduct(new DefaultProduct());
		assertEquals(instance.getProducts().size() > 0, !instance.isEmpty());
	}

	@Test
	void shouldAddProductWhenProductNonNull() {
		instance.addProduct(new DefaultProduct());
		assertEquals(instance.getProducts().size(), 1);
	}

	@Test
	void shouldDontAddProductWhenProductIsNull() {
		Product product = new DefaultProduct();
		Product product2 = new DefaultProduct();
		Product product3 = new DefaultProduct();
		instance.addProduct(product);
		instance.addProduct(product2);
		instance.addProduct(product3);
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		list.add(product2);
		list.add(product3);
		assertEquals(instance.getProducts().containsAll(list) && instance.getProducts().size() == list.size(), true);
	}

	@Test
	void shouldReturnAllProductsFromCart() {
		Product product = null;
		instance.addProduct(product);
		assertEquals(instance.getProducts().size(), 0);
	}

	@Test
	void shouldClearCart() {
		Product product = new DefaultProduct();
		Product product2 = new DefaultProduct();
		Product product3 = new DefaultProduct();
		instance.addProduct(product);
		instance.addProduct(product2);
		instance.addProduct(product3);
		instance.clear();
		assertEquals(instance.getProducts().size(), 0);
	}
}
