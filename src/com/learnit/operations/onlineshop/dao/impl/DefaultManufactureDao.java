package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.ManufactureDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;
import com.learnit.operations.onlineshop.enteties.impl.DefaultManufacture;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProductCategory;

public class DefaultManufactureDao implements ManufactureDao {

	@Override
	public boolean addManufacture(Manufacture manufacture) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO manufacturers (manufacturers_name) VALUES(?)")) {
			ps.setString(1, manufacture.getManufactureName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteManufacture(Manufacture manufacture) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM manufacturers WHERE manufacturers_id = ?")) {
			ps.setInt(1, manufacture.getManufactureId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getManufactureNameById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM manufacturers WHERE manufacturers_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getString("manufacturers_name");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getIdByManufactureName(String name) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM manufacturers WHERE manufacturers_name = ?");) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("manufacturers_id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Manufacture> getAllManufacture() {
		List<Manufacture> listOfManufacturers = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM manufacturers")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var manufacturers = new DefaultManufacture();
					manufacturers.setManufactureId(rs.getInt("manufacturers_id"));
					manufacturers.setManufactureName(rs.getString("manufacturers_name"));
					listOfManufacturers.add(manufacturers);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfManufacturers;
	}

	@Override
	public Manufacture getManufactureById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM manufacturers WHERE manufacturers_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					var manufacture = new DefaultManufacture();
					manufacture.setManufactureId(rs.getInt("manufacturers_id"));
					manufacture.setManufactureName(rs.getString("manufacturers_name"));
					return manufacture;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAllManufacture() {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE manufacturers")) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Manufacture> getAllManufactureForCategory(int categoryId) {
		List<Manufacture> listOfManufacturersForCategory = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT distinct * FROM categories_munufacturers cm JOIN categories c ON cm.category_id = c.category_id "
								+ "JOIN manufacturers m ON m.manufacturers_id = cm.manufacturers_id")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					if (categoryId == rs.getInt("category_id")) {
						var manufacturers = new DefaultManufacture();
						manufacturers.setManufactureId(rs.getInt("manufacturers_id"));
						manufacturers.setManufactureName(rs.getString("manufacturers_name"));
						listOfManufacturersForCategory.add(manufacturers);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfManufacturersForCategory;
	}

	@Override
	public List<ProductCategory> getAllCategoryForManufacture(int manufactureId) {
		List<ProductCategory> listOfProductCategoryForManufacture = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT DISTINCT * FROM categories_munufacturers cm JOIN categories c ON cm.category_id = c.category_id "
								+ "JOIN manufacturers m ON m.manufacturers_id = cm.manufacturers_id")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					if (manufactureId == rs.getInt("manufacturers_id")) {
						var productCategory = new DefaultProductCategory();
						productCategory.setCategoryId(rs.getInt("category_id"));
						productCategory.setCategoryName(rs.getString("category_name"));
						productCategory.setManufacture(
								new DefaultManufactureDao().getAllManufactureForCategory(rs.getInt("category_id")));
						listOfProductCategoryForManufacture.add(productCategory);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProductCategoryForManufacture;
	}

}
