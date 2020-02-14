package com.qa.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import domain.Items;
import domain.Order;
import domain.Customer;

public class MysqlOrdersDao implements Dao<Order> {
	public static final Logger LOGGER = Logger.getLogger(MysqlOrdersDao.class);
	private Connection connection;


	public MysqlOrdersDao(String username, String password) {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", username,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getStackTrace());
		}

	}

	public Order create(Order t) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(
					"insert into orders(price, customer_ID) values(" + t.getPrice() + "," + t.getCustomer_ID() + ")");

			System.out.println("Orders added complete");
			LOGGER.info("Order created");
			connection.close();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
			}
		}
		return null;
	}
	// TODO Auto-generated method stub

	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");

			while (resultSet.next()) {

				int id = resultSet.getInt("orders_ID");
				Long customer_ID = (long) resultSet.getInt("customer_ID");// ensure that this matches the MySQL table
																			// name
				Double price = resultSet.getDouble("price");

				orders.add(new Order(id, price, customer_ID));
				/// * email, mobile*/;

			}
		} catch (Exception e) {
			LOGGER.error("error displaying the list of orders");
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
		
			}
		}
		return orders;
	}

	@SuppressWarnings("finally")
	public Order update(Order t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE orders customer_ID = ?, set price = ? where orders_ID = ?";
		;
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, t.getCustomer_ID());
			stmt.setDouble(2, t.getPrice()); // the numbers corresponds to the sql statements "?"
			stmt.setLong(3, t.getId());
			stmt.execute();
			LOGGER.info("Order created");
		} catch (Exception e) {
			LOGGER.error("error inserting the order details");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
		}
		return null;
	}
	}
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orders WHERE orders_ID = ?";
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			System.out.println("Delete complete ");
			connection.close();
		} catch (Exception e) {
			LOGGER.error("Delete failed");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());

	
			}
		}
	}
}

