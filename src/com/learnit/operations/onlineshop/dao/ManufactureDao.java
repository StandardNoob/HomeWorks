package com.learnit.operations.onlineshop.dao;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public interface ManufactureDao {

	boolean addManufacture(Manufacture manufacture);

	boolean deleteManufacture(Manufacture manufacture);

	boolean deleteAllManufacture();

	String getManufactureNameById(int id);

	int getIdByManufactureName(String name);

	Manufacture getManufactureById(int id);

	List<Manufacture> getAllManufacture();

	List<Manufacture> getAllManufactureForCategory(int categoryId);

	List<ProductCategory> getAllCategoryForManufacture(int manufactureId);

}
