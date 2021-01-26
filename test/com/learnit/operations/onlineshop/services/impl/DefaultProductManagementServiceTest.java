package com.learnit.operations.onlineshop.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests DefaultProductManagementService for online shop")
class DefaultProductManagementServiceTest {

	private static DefaultProductManagementService instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = (DefaultProductManagementService) instance.getInstance();
	}

	@Test
	void shouldInitAllProductsFormMethodInitProducts() {
		assertEquals(instance.getProducts().size(), 10);
	}

	@Test
	void shouldReturnAllProducts() {
		assertEquals(instance.getProducts().size(), 10);
	}

	@Test
	void shouldReturnProductById() {
		assertEquals(instance.getProductById(3).getId(), 3);
	}

	@Test
	void shouldReturnNullWhenProductDoesNotExist() {
		assertEquals(instance.getProductById(25), null);
	}

}
