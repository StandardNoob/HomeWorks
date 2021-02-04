package com.learnit.operations.onlineshop.enteties.impl;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public class DefaultProductCategory implements ProductCategory {

	private int categoryId;
	private String categoryName;
	private List<Manufacture> manufacture;

	public DefaultProductCategory() {
		super();
	}

	public DefaultProductCategory(int categoryId, String categoryName, List<Manufacture> manufacture) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.manufacture = manufacture;
	}

	public DefaultProductCategory(String categoryName, List<Manufacture> manufacture) {
		super();
		this.categoryName = categoryName;
		this.manufacture = manufacture;
	}

	public List<Manufacture> getManufacture() {
		return manufacture;
	}

	public void setManufacture(List<Manufacture> manufacture) {
		this.manufacture = manufacture;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public boolean addCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCategoryNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "DefaultProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
