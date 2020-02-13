package com.qa.persistence;

import java.util.List;

import org.apache.log4j.Logger;

import domain.OrderLine;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MysqlOrderLineDao implements OrderLineDao<OrderLine>{
	
	public static final Logger LOGGER = Logger.getLogger(MysqlOrderLineDao.class);
	private Connection connection;

	public MysqlOrderLineDao(String username, String password)  {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getStackTrace());
		}

		
	}
		

	public List<OrderLine> readAll() {
		ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from OrderLine");
			
			
			while (resultSet.next()) {
				Long id = (long) resultSet.getInt("id");
				long orders_ID = (long)resultSet.getInt("order_ID");
				long items_ID = (long)resultSet.getInt("order_ID");
				int quantity =  resultSet.getInt("quantity");
			OrderLine orderLine = new OrderLine(id, orders_ID, items_ID, quantity);
				orderLineList.add(orderLine);
			}
		} catch (Exception e) {
			LOGGER.error("error displaying the list of items");
		}
		return orderLineList;
	}

	public void create(OrderLine t) {
		try {
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orderline(orders_ID, items_ID, quantity) values('" + t.getOrders_ID() + "','" +t.getItems_ID()+ "','"+t.getQuantity()+ "')" );
			LOGGER.info("Orderline created");
		} catch (Exception e) {
			LOGGER.error("error inserting to orderline table");
		} 
	}



	@Override
	public void update(long id, OrderLine t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderLine t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getOrderIdForOrderLine(long custId, double price) {
		// TODO Auto-generated method stub
		return 0;
	
	}

	
}


