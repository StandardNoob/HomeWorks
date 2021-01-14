package com.learnit.operations.onlineshop.services;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}