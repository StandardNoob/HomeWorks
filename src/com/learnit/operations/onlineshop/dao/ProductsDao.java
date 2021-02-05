package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.Product;

public interface ProductsDao {

	boolean addProduct(Product product);

	boolean deleteProduct(Product product);

	boolean updPrice(Product product);

	boolean updProductName(Product product);

	boolean deleteAllProducts();

	Product getProductById(int id);

	List<Product> getProducts();

	List<Product> getProductsByOrderId(Order order);

}
