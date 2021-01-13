package com.learnit.operations.onlineshop.enteties.impl;

import com.learnit.operations.onlineshop.enteties.Product;

public class DefaultProduct implements Product {

	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct() {
	}

	public DefaultProduct(int id, String productName, String categoryName, double price) {
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product: id= " + this.id + ", Product Name= " + this.productName + ", Category Name= "
				+ this.categoryName + ", Price= " + this.price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

}