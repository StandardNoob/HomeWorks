package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public interface ProductCategoryDao {

	boolean addCategory(ProductCategory category);

	boolean deleteCategory(ProductCategory category);

	String getCategoryNameById(int id);

	int getIdByCategoryName(String name);

	List<ProductCategory> getAllCategory();

	ProductCategory getCategoryById(int id);

	boolean deleteAllCategories();

	List<Manufacture> getAllManufactureForCategory(int categoryId);

}
