package com.learnit.operations.onlineshop.enteties;

import java.util.List;

public interface ProductCategory {

	boolean addCategory(ProductCategory category);

	boolean deleteCategory(ProductCategory category);

	String getCategoryNameById(int id);

	String getCategoryName();

	int getCategoryId();
	
	void setCategoryId(int categoryId);

	List<Manufacture> getManufacture();

	void setManufacture(List<Manufacture> manufacture);

}
