package com.learnit.operations.onlineshop.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.dao.OrdersDao;
import com.learnit.operations.onlineshop.dao.utils.DbUtils;
import com.learnit.operations.onlineshop.enteties.Order;
import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultOrder;

public class DefaultOrdersDao implements OrdersDao {

	@Override
	public boolean addOrder(Order order) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn
						.prepareStatement("INSERT INTO orders (customer_id,credit_card_number) VALUES(?,?)")) {
			ps.setInt(1, order.getCustomerId());
			ps.setString(1, order.getCreditCardNumber());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Order> getOrdersByUserId(User user) {
		List<Order> listOfOrdersForUser = new ArrayList<>();
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM order_product op " + "JOIN orders o ON op.order_id = o.order_id "
								+ "JOIN products p ON op.product_id= p.product_id WHERE o.customer_id = ?")) {
			ps.setInt(1, user.getId());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var order = new DefaultOrder();
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerId(rs.getInt("customer_id"));
					order.setCreditCardNumber(rs.getString("credit_card_number"));
					order.setProducts(new DefaultProductsDao().getProductsByOrderId(order));
					listOfOrdersForUser.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfOrdersForUser;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> listOfOrders = new ArrayList<>();
		try (var conn = DbUtils.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders")) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					var order = new DefaultOrder();
					order.setOrderId(rs.getInt("order_id"));
					order.setCustomerId(rs.getInt("customer_id"));
					order.setCreditCardNumber(rs.getString("credit_card_number"));
					order.setProducts(new DefaultProductsDao().getProductsByOrderId(order));
					listOfOrders.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfOrders;
	}

	@Override
	public boolean deleteOrder(Order order) {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM orders WHERE order_id = ?");
				PreparedStatement ps2 = conn.prepareStatement("DELETE FROM order_product WHERE order_id = ?")) {
			ps.setInt(1, order.getOrderId());
			ps2.setInt(1, order.getOrderId());
			ps.executeUpdate();
			ps2.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllOrders() {
		try (var conn = DbUtils.getConnection();
				PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE orders");
				PreparedStatement ps2 = conn.prepareStatement("TRUNCATE TABLE order_product");) {
			ps.executeUpdate();
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
