package com.qa.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import domain.Customer;

public class MYsqlCustomerDao implements Dao<Customer> {
	public static final Logger LOGGER = Logger.getLogger(MYsqlCustomerDao.class);

	private Connection connection;

	public MYsqlCustomerDao(String username, String password) {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", username,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getStackTrace());
		}

	}

	public Customer create(Customer t) {
		Statement statement = null;
		try {

			statement = connection.createStatement();
			statement.executeUpdate("insert into customer(email, firstName, lastName) values('" + t.getEmail() + "','"
					+ t.getFirstName() + "','" + t.getLastName() + "')");
			// logger.info("Customer created");
			System.out.println("Customer added complete");
			LOGGER.info("Customer created");
			connection.close();
		} catch (Exception e) {
			// e.printStackTrace();
			LOGGER.error("error inserting the customer details");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
			}
		}
		return t;
	}
	// TODO Auto-generated method stub

	@SuppressWarnings("finally")
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");

			while (resultSet.next()) {

				long id = resultSet.getInt("customer_ID");
				String firstName = resultSet.getString("firstName");// ensure that this matches the MySQL table name
				String lastName = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				// String email = resultSet.getString("cust_email");//edit
				// Long mobile = resultSet.getLong("cust_mobile");//edit

				customers.add(new Customer(id, firstName, lastName, email));
				/// * email, mobile*/;
			}
		} catch (Exception e) {
			LOGGER.error("error inserting the customer details");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
			}
			return customers;
		}
	}

	@SuppressWarnings("finally")
	public Customer update(long id, Customer t) {
		// TODO Auto-generated method stub
		int customer_ID = (int) id;
		String sql = "UPDATE customer set email = ?,firstName = ?,lastName= ? where customer_ID = ?";
		;
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getEmail());
			stmt.setString(2, t.getFirstName()); // the numbers corresponds to the sql statements "?"
			stmt.setString(3, t.getLastName());
			stmt.setLong(4, t.getId());
			stmt.execute();
			if (customer_ID == 0) {
				LOGGER.error("This customer does not exist in the database");
			} else {
				LOGGER.info("Update complete");
			}
			connection.close();
		} catch (Exception e) {
			LOGGER.error("Update failed");
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
		String sql = "DELETE FROM customer WHERE customer_ID = ?";
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			System.out.println("Delete complete ");
			connection.close();
		} catch (Exception e) {
			LOGGER.error("Delete failed");// logger.info(e);
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

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	// CRUD with customers

}
// public class MysqlOrdersDao implements Dao<Orders>;




