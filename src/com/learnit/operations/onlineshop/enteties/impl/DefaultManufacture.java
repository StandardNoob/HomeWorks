package com.learnit.operations.onlineshop.enteties.impl;

import java.util.List;

import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;

public class DefaultManufacture implements Manufacture {

	private int manufactureId;
	private String manufactureName;
	private List<ProductCategory> listOfProductCategory;

	public DefaultManufacture() {
	}

	public DefaultManufacture(int manufactureId, String manufactureName, List<ProductCategory> listOfProductCategory) {
		this.manufactureId = manufactureId;
		this.manufactureName = manufactureName;
		this.listOfProductCategory = listOfProductCategory;
	}

	public List<ProductCategory> getListOfProductCategory() {
		return listOfProductCategory;
	}

	public void setListOfProductCategory(List<ProductCategory> listOfProductCategory) {
		this.listOfProductCategory = listOfProductCategory;
	}

	public DefaultManufacture(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public String getManufactureName() {
		return manufactureName;
	}

	public void setManufactureName(String manufactureName) {
		this.manufactureName = manufactureName;
	}

	@Override
	public boolean addCategory(Manufacture manufacture) {
		return false;
	}

	@Override
	public boolean deleteCategory(Manufacture manufacture) {
		return false;
	}

	@Override
	public String toString() {
		return "DefaultManufacture [manufactureId=" + manufactureId + ", manufactureName=" + manufactureName + "]";
	}

}
