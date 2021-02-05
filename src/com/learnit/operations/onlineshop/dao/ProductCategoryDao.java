package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public interface ProductCategoryDao {

	boolean addCategory(ProductCategory category);

	boolean deleteCategory(ProductCategory category);

	boolean deleteAllCategories();

	String getCategoryNameById(int id);

	int getIdByCategoryName(String name);

	ProductCategory getCategoryById(int id);

	List<ProductCategory> getAllCategory();

	List<Manufacture> getAllManufactureForCategory(int categoryId);

}
