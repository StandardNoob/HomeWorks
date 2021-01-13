package com.learnit.operations.onlineshop.services;

import com.learnit.operations.onlineshop.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}