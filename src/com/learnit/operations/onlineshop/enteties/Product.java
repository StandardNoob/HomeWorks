package com.learnit.operations.onlineshop.enteties;

public interface Product {

	int getId();

	String getProductName();

	ProductCategory getCategory();
	
	void setCategory(ProductCategory category);
	
	double getPrice();
	
	

}
