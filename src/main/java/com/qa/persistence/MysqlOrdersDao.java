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
		this.connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", "root", "QA4312814");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		LOGGER.error(e.getStackTrace());
	}
	
		
	}

	public Order create(Order t) {
			try {
	            Statement statement = connection.createStatement();
	            statement.executeUpdate("insert into orders(price, customer_ID) values(" + t.getPrice()+ ","  + t.getCustomer_ID() + ")" );
	            
	            System.out.println("Orders added complete");
	            LOGGER.info("Order created");
	            connection.close();
				} catch (Exception e) {
					LOGGER.debug(e.getStackTrace());
					LOGGER.error(e.getMessage());
				}
	            //logger.error("error inserting the customer details");
//	        }
			return null;
	    }
		// TODO Auto-generated method stub

	
	
	public ArrayList<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			
			while (resultSet.next()) {
				
				int id = resultSet.getInt("orders_ID");
				Long customer_ID = (long) resultSet.getInt("customer_ID");// ensure that this matches the MySQL table name
				Double price = resultSet.getDouble("price");
				
				
				
				orders.add(new Order(id, price, customer_ID));
						///* email, mobile*/;
				
			}
		} catch (Exception e) {
			LOGGER.error("error displaying the list of orders");
		}
		return orders;
	}
       
	public Order update(Order t) {
		// TODO Auto-generated method stub
		String sql = "UPDATE orders customer_ID = ?, set price = ? where orders_ID = ?";;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, t.getCustomer_ID());
			stmt.setDouble(2, t.getPrice()); // the numbers corresponds to the sql statements "?"
			stmt.setLong(3, t.getId());
			stmt.execute();
			LOGGER.info("Order created");
		} catch (Exception e) {
			LOGGER.error("error inserting the order details");
			
		}
		return null;
	}
	

	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orders WHERE orders_ID = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			System.out.println("Delete complete ");
			connection.close();
		} catch (Exception e) {
			LOGGER.error("Delete failed");
		}
		
	
	}


	
	  public List<Items> itemsDisplay () {
		  ArrayList<Items> items = new ArrayList<Items>();
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", "root", "QA4312814")) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from Items");
				while (resultSet.next()) {
					Long id = (long) resultSet.getInt("id");
					String itemName = resultSet.getString("itemName");
					Double price = resultSet.getDouble("price");
					Items item = new Items(id, itemName, price);
					item.add(items);
				}
			} catch (Exception e) {
				LOGGER.error("error displaying the list of items");
			}
			return items;
		  
	  }

	  public Double itemsPrice(Items c) {
		  String sql = "SELECT price from Items where item_name =?";
		  Double price_per_items = (double)0;
		  try {
				checkConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, c.getItems_name());
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					
					 price_per_items = rs.getDouble("price_per_items");
					
				}
				LOGGER.info("price obtained");
				rs.close();
				connection.close();
		}catch(Exception e) {
			 LOGGER.error("price not obtained");
			 price_per_items= (double) 0;
			 
		 }
		 return price_per_items;
	  }

	private void checkConnection() {
		// TODO Auto-generated method stub
		
	}

	
	public Long getCustomer_ID(Customer v) {
		String sql = "SELECT id from Customer WHERE firstName= ? && lastName= ? && email= ?";
		Long id =(long) 0;
		try {
			checkConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, v.getFirstName());
			stmt.setString(2, v.getLastName());
			stmt.setString(3, v.getEmail());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				 id = (long) rs.getInt("customer_ID");
				
			}if(id==0) {
				LOGGER.error("This customer does not exist in the database");
			}else {
				LOGGER.info("Customerid obtained");
			}
			rs.close();
			connection.close();
	}catch(Exception e) {
		 LOGGER.error("Customerid not obtained");
		 id= (long) 0;
		 
	 }
		LOGGER.info("The customerid is "+id);
		return id;
	}

	public Long getOrder_ID(long customer_ID, double price) {
		String sql = "SELECT id from orders WHERE customer_ID= ? && price= ? ";
		long id =(long) 0;
		try {
			checkConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, customer_ID);
			stmt.setDouble(2,price);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				 id = (long) rs.getInt("customer_ID");
				
			}
			if(id==0) {
				LOGGER.error("This order does not exist in the database");
			}else {
				LOGGER.info("Orderid obtained");
			}
			rs.close();
			connection.close();
	}catch(Exception e) {
		LOGGER.error("Orderid not obtained");
		 id= (long) 0;
		 
	 }
		LOGGER.info("The orderid is "+id);
		return id;
		
	}

	public Long getItem_Id(Items u) {
		String sql = "SELECT id from Items WHERE item_name= ?";
		Long id =(long) 0;
		try {
			checkConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, u.getItems_name());
		
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				 id = (long) rs.getInt("Items_ID");
				
			}
			if(id==0) {
				LOGGER.error("This item does not exist in the database");
			}else {
				LOGGER.info("Itemid obtained");
			}
			rs.close();
			connection.close();
	}catch(Exception e) {
		LOGGER.error("Itemid not obtained");
		 id= (long) 0;
		 
	 }
		LOGGER.info("The itemid is "+id);
		return id;
	}
	
	public List<Order> orderDetailsDisplay(long id) {
		 ArrayList<Order> orders = new ArrayList<Order>();
			try {
				checkConnection();
				String sql= "select * from Orders where customer_ID =? ";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet resultSet = stmt.executeQuery();
				
				while (resultSet.next()) {
					Long idGet = (long) resultSet.getInt("order_ID");
					Long customer_ID = resultSet.getLong("customer_ID");
					Double price = resultSet.getDouble("price");
					Order order = new Order(idGet, price, customer_ID);
					orders.add(order);
				}
			} catch (Exception e) {
				LOGGER.error("error displaying the list of items");
			}
			return orders;
	}
		
		
	}
