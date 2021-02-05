package com.learnit.operations.onlineshop.enteties.impl;

import com.learnit.operations.onlineshop.enteties.ProductCategory;
import com.learnit.operations.onlineshop.enteties.Product;

public class DefaultProduct implements Product {

	private int id;
	private String productName;
	private double price;
	private ProductCategory category;

	public DefaultProduct() {
	}

	public DefaultProduct(int id, String productName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public DefaultProduct(int id, String productName, ProductCategory category, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
	}

	@Override
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product: id= " + this.id + ", Product Name= " + this.productName + ", Category Name= "
				+ category.getCategoryName() + ", Price= " + this.price;
	}

}
