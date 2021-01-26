package com.learnit.operations.onlineshop.enteties.impl;

import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.enteties.Cart;
import com.learnit.operations.onlineshop.enteties.Product;

public class DefaultCart implements Cart {

	private List<Product> products;

	{
		products = new ArrayList<Product>();
	}

	public boolean isEmpty() {
		if (products.size() == 0 || products == null) {
			return true;
		}
		for (Product product : products) {
			if (product != null) {
				return false;
			}
		}
		return true;
	}

	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		products.add(product);

	}

	public List<Product> getProducts() {
		List<Product> newList = new ArrayList<>();
		for (Product product : products) {
			if (product != null) {
				newList.add(product);
			}
		}
		return newList;
	}

	public void clear() {
		products.clear();
	}

}