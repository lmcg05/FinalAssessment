package com.qa.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import domain.Items;



public class MYsqlItemsDao implements Dao<Items>{
	public static final Logger LOGGER = Logger.getLogger(MYsqlItemsDao.class);
	private Connection connection;


	public MYsqlItemsDao(String username, String password) {
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://35.225.56.59:3306/customerdomain", username,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error(e.getStackTrace());
		}

	}

	@SuppressWarnings("finally")
	public Items create(Items t) {
		Statement statement = null;
			try {
	            statement = connection.createStatement();
	            statement.executeUpdate("insert into items(items_name, price_per_items) values('" + t.getItems_name()+ "','"  + t.getPrice_per_items() + "')" );
	            
	            System.out.println("Items added complete");
	            LOGGER.info("Items created");
	            connection.close();
				} catch (Exception e) {
					//e.printStackTrace();
					LOGGER.error("error inserting the items details");
				}finally {
					try {
						if (statement != null) {
							statement.close();
						}
					} catch (SQLException e) {
						LOGGER.error(e.getStackTrace());
				}
	            //logger.error("error inserting the customer details");
//	        }
			return null;
	    }
	}
		// TODO Auto-generated method stub

	

	public ArrayList<Items> readAll() {
		ArrayList<Items> items = new ArrayList<Items>();
		Statement statement = null;
		try {
			
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			
			while (resultSet.next()) {
				
				int id = resultSet.getInt("items_ID");
				String items_name = resultSet.getString("items_name");// ensure that this matches the MySQL table name
				Double price_per_items = resultSet.getDouble("price_per_items");
				//String email = resultSet.getString("cust_email");//edit
				//Long mobile = resultSset.getLong("cust_mobile");//edit
				
				
				items.add(new Items(id, items_name, price_per_items));
						///* email, mobile*/;
				
			}
		} catch (Exception e) {
			LOGGER.error("error displaying the list of items");
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getStackTrace());
			}
		}
		return items;
	}
       
	@SuppressWarnings("finally")
	public Items update(long id, Items t) {
		// TODO Auto-generated method stub
		int items_ID = (int)id;
		String sql = "UPDATE items set items_name = ?,price_per_items = ? where items_ID = ?";;
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, t.getItems_name());
//			stmt.setString(2, customer.getLastName());
			stmt.setDouble(2, t.getPrice_per_items()); // the numbers corresponds to the sql statements "?"
			stmt.setLong(3, t.getId());
			stmt.execute();
			if(items_ID==0) {
				LOGGER.error("This item does not exist in the database");
			}else {
				LOGGER.info("Update complete");
			}
		} catch (Exception e) {
			 LOGGER.error("Update failed");
		}finally {
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
		String sql = "DELETE FROM items WHERE items_ID = ?";
		Statement statement = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			System.out.println("Delete complete ");
			connection.close();
		} catch (Exception e) {
		LOGGER.info(e);
		}finally {
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
	public Items update(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}



