package com.learnit.operations.onlineshop.enteties.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.enteties.Order;

@DisplayName("Tests DefaultOrder for online shop")
class DefaultOrderTest {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private Order order;

	@BeforeEach
	void setUp() throws Exception {
		order = new DefaultOrder();
	}

	@Test
	void shouldCheckIfCreditCardNumberValidOrInvalid() {
		String validCreditCardNumber = "1234567891234567";
		String invalidCreditCardNumber = "123456789 23456";

		assertEquals(
				validCreditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER
						&& !validCreditCardNumber.contains(" ") && Long.parseLong(validCreditCardNumber) > 0,
				order.isCreditCardNumberValid(validCreditCardNumber));
		assertEquals(
				invalidCreditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER
						&& !invalidCreditCardNumber.contains(" ") && Long.parseLong(invalidCreditCardNumber) > 0,
				order.isCreditCardNumberValid(invalidCreditCardNumber));
	}

}
