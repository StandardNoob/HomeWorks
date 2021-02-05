package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.ProductsDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.Product;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProduct;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProductCategory;

public class DefaultProductsDao implements ProductsDao {

	@Override
	public List<Product> getProducts() {
		List<Product> listOfProducts = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT distinct * FROM products p JOIN categories c ON c.category_id = p.category_id")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var product = new DefaultProduct();
					product.setId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getDouble("price"));
					product.setCategory(new DefaultProductCategory(rs.getInt("category_id"),
							rs.getString("category_name"),
							new DefaultManufactureDao().getAllManufactureForCategory(rs.getInt("category_id"))));
					listOfProducts.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public Product getProductById(int id) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE product_id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				var product = new DefaultProduct();
				if (rs.next()) {
					product.setId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getDouble("price"));
					return product;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addProduct(Product product) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO products (product_name,price,category_id) VALUES(?,?,?)")) {
			ps.setString(1, product.getProductName());
			ps.setDouble(1, product.getPrice());
			ps.setInt(3, product.getCategory().getCategoryId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE product_id = ?")) {
			ps.setInt(1, product.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllProducts() {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE products")) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updPrice(Product product) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE products SET price = ? WHERE product_id = ?")) {
			ps.setDouble(1, product.getPrice());
			ps.setInt(2, product.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updProductName(Product product) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("UPDATE products SET product_name = ? WHERE product_id = ?")) {
			ps.setString(1, product.getProductName());
			ps.setInt(2, product.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getProductsByOrderId(Order order) {
		List<Product> listOfProducts = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM order_product op JOIN orders o ON op.order_id = o.order_id JOIN products p ON op.product_id= p.product_id")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					if (order.getOrderId() == rs.getInt("order_id")) {
						var product = new DefaultProduct();
						product.setId(rs.getInt("product_id"));
						product.setProductName(rs.getString("product_name"));
						product.setPrice(rs.getDouble("price"));
						listOfProducts.add(product);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
	}
}
