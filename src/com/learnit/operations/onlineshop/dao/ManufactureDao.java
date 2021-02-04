package com.learnit.operations.onlineshop.dao;

import java.util.List;


import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public interface ManufactureDao {

	boolean addManufacture(Manufacture manufacture);

	boolean deleteManufacture(Manufacture manufacture);

	String getManufactureNameById(int id);

	int getIdByManufactureName(String name);

	List<Manufacture> getAllManufacture();

	Manufacture getManufactureById(int id);

	boolean deleteAllManufacture();
	
	List<Manufacture> getAllManufactureForCategory(int categoryId);
	
	List<ProductCategory> getAllCategoryForManufacture(int manufactureId);

}
