package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.ProductCategoryDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.ProductCategory;
import com.learnit.operations.onlineshop.enteties.UserRole;
import com.learnit.operations.onlineshop.enteties.impl.DefaultManufacture;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProductCategory;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUserRole;

public class DefaultProductCategoryDao implements ProductCategoryDao {

	@Override
	public boolean addCategory(ProductCategory category) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO categories (category_name) VALUES(?)")) {
			ps.setString(1, category.getCategoryName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCategory(ProductCategory category) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM categories WHERE category_id = ?")) {
			ps.setInt(1, category.getCategoryId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getCategoryNameById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories WHERE category_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getString("category_name");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getIdByCategoryName(String name) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories WHERE category_name = ?");) {
			ps.setString(1, name);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("category_id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		List<ProductCategory> listOfCategory = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var category = new DefaultProductCategory();
					category.setCategoryId(rs.getInt("category_id"));
					category.setCategoryName(rs.getString("category_name"));
					listOfCategory.add(category);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfCategory;
	}

	@Override
	public ProductCategory getCategoryById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories WHERE category_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					var category = new DefaultProductCategory();
					category.setCategoryId(rs.getInt("category_id"));
					category.setCategoryName(rs.getString("category_name"));
					return category;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAllCategories() {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE categories")) {
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
}
