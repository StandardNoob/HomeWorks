package com.itbulls.learnit.riabchenko.operations.onlineshop.services;

import com.itbulls.learnit.riabchenko.operations.onlineshop.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}