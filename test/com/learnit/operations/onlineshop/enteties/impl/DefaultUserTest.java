package com.learnit.operations.onlineshop.enteties.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.enteties.User;

@DisplayName("Tests DefaultUser for online shop")
class DefaultUserTest {
	
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new DefaultUser();
	}

	@Test
	void shouldSetPasswordWhenPasswordIsNotNull() {		 
		String password = "123";
		user.setPassword(password);
		assertEquals(user.getPassword(), password);
	}
	
	@Test
	void shouldSetEmailWhenEmailIsNotNull() {		
		String email = "email";
		user.setEmail(email);
		assertEquals(user.getEmail(), email);
	}
}
