package com.learnit.operations.onlineshop.enteties.impl;

import java.util.Arrays;

import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		boolean isCreditCardNumberValid = (creditCardNumber.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER)
				&& creditCardNumber.matches("\\d+") ? true : false;
		return isCreditCardNumberValid;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "Order for cardholder number= " + this.creditCardNumber +", Products= "
				+ Arrays.toString(this.products);
	}

}