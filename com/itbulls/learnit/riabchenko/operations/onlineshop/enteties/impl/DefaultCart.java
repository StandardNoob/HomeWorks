package com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Cart;
import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Product;

public class DefaultCart implements Cart {
	
	private Product[] products;
	private static final int DEFAULT_PRODUCT_CAPACITY = 10;

	{
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

	public boolean isEmpty() {
		ArrayList<Product> listOfProducts = new ArrayList<>(Arrays.asList(products));
		if (listOfProducts.size() == 0 || listOfProducts == null) {
			return true;
		}
		for (Product product : listOfProducts) {
			if (product != null) {
				return false;
			}
		}
		return true;
	}

	public void addProduct(Product product) {
		ArrayList<Product> listOfProducts = new ArrayList<>(Arrays.asList(products));
		if (product == null) {
			return;
		}
		listOfProducts.add(product);
		products = listOfProducts.toArray(Product[]::new);
	}

	public Product[] getProducts() {		
		ArrayList<Product> newList = new ArrayList<>();
		for (Product product : products) {
			if (product != null) {
				newList.add(product);
			}
		}
		Product[] productsArr = newList.toArray(Product[]::new);
		return productsArr;
	}

	public void clear() {
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

}