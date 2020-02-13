package com.qa.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


import com.qa.services.CrudServices;
import com.qa.services.GetCustomerId;
import com.qa.services.GetItemId;
import com.qa.services.GetOrderDetails;

import com.qa.services.OrderService;

import Utils.Utils;
import domain.Customer;
import domain.Items;
import domain.Order;
import domain.OrderLine;

public class OrderController implements CrudController<Order>{
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	String getInput() {
		return Utils.getInput();
	}
	public List<Order> readAll() {
		List<Order> order = orderService.readAll();
		for(Order orders: order) {
			LOGGER.info(orders.toString());
		}
		return order;
		}
	public Order create(){
		LOGGER.info("Enter customer id:");
		Long id =Long.valueOf(Utils.getInput());
		Double totalPrice = 0.00;
		Long totalQuantity = 0L;
		ArrayList<Long> items = new ArrayList<Long>();
		ArrayList<Long> quantity = new ArrayList<Long>();
		ArrayList<Double> price = new ArrayList<Double>();
		while (true) {
			LOGGER.info("Please enter item id or enter 0 if order is complete:"  );
			Long l = Long.valueOf(Utils.getInput());
			items.add(l);
			if(l==0) {
				break;
			}
			LOGGER.info("Please enter quantity of item");
			Long i = Long.valueOf(Utils.getInput());
			quantity.add(i);
			LOGGER.info("Please enter price of item");
			Double j = Double.valueOf(Utils.getInput());
			price.add(j);
			}
			for(int k=0; k<quantity.size();k++) {
				Double price1 =(quantity.get(k))* (price.get(k));
				totalPrice= totalPrice+price1;
				totalQuantity += quantity.get(k);
			}
			orderService.create((new Order(id, totalQuantity, totalPrice)));
			LOGGER.info("Order created successfully");
			return null;
		}
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = Long.valueOf(Utils.getInput());
		LOGGER.info("Please enter customer id");
		Long customerId = Long.valueOf(Utils.getInput());
		LOGGER.info("Please enter totalQuantity");
		Long totalQuantity = Long.valueOf(Utils.getInput());
		LOGGER.info("Please enter totalPrice");
		Double actualPrice = Double.valueOf(Utils.getInput());
		orderService.update(new Order(customerId, totalQuantity, actualPrice));
		LOGGER.info("Order updated successfully");
		return null;
	}
	public void delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = Long.valueOf(Utils.getInput());
		orderService.delete(id);
	}

////	private CrudServices<Order> orderService;
//	
//	String getInput() {
//		return Utils.getInput();
//	}
//
//	public List<Order> readAll() {
//		// TODO Auto-generated method stub
//		List<Order> order = OrderService.readAll();
//		for (@SuppressWarnings("unused") Order orders : order) {
//			LOGGER.info(order.toString());
//		}
////		return order;

	

//	
//	public Order create() {
//		ArrayList<Long> listId = new ArrayList<Long>();
//		ArrayList<Integer> quantityList = new ArrayList<Integer>();
//		double totalPrice = 0.00;
//		long customer_ID = getCustomer_ID();
//		itemsDisplay();
//		while(true) {
//			LOGGER.info("Please enter the item name. Enter submit to complete purchase ");
//			itemName = Utils.getInput();
//			if(itemName.equalsIgnoreCase("submit")) {
//				LOGGER.info("Order submitted");
//				break;
//			}
//			long id = getItem_ID();
//			listId.add(id);
//			double price = getOrderDetails.itemPrice(new Items(itemName, totalPrice));
//			LOGGER.info("Enter the quantity");
//			String quantity = Utils.getInput();
//			int parseInteger = Integer.parseInt(quantity);
//			quantityList.add(parseInteger);
//			double totalPriceForEachItem = parseInteger * price;
//			totalPrice = totalPrice + totalPriceForEachItem;
//		}
//		orderService.create(new Order((long) totalPrice,customer_ID));
//		LOGGER.info("\nShoppingCart Total :" + totalPrice);
//		try {
//			TimeUnit.SECONDS.sleep(30);
//		}catch (InterruptedException e) {
//			LOGGER.info(e);
//		}
//		DecimalFormat df = new DecimalFormat("0.00");
//		double total = Double.parseDouble(df.format(totalPrice));
//		long result = getOrder_ID(customer_ID,total);
//		LOGGER.info("order id = " + result);
//		if(result !=0) {
//			for(int i=0; i<quantityList.size(); i++) {
//				LOGGER.info("List of id" + listId.get(i));
//				LOGGER.info("list of quantity" + quantityList.get(i));
//				orderLineCreate1(result, listId.get(i), quantityList.get(i));
//			}
//		}
//		return null;
//	}
//	public Order update() {
//		LOGGER.info("Please enter the ID of the order you want to update");
//		String id = Utils.getInput();
//		long num = Long.parseLong(id);
//		LOGGER.info("Please enter the updated customer ID");
//		String customer_ID = Utils.getInput();
//		long custId = Long.parseLong(customer_ID);
//		LOGGER.info("Please enter the updated order cost");
//		String cost = Utils.getInput();
//		float floatCost = Float.parseFloat(cost);
//		return orderService.update(new Order(custId, floatCost));
	

////	public Order update() {
//		// TODO Auto-generated method stub
//		LOGGER.info("Please enter the ID of the order you would like to update");
//		Long id = Long.valueOf(getInput());
//		LOGGER.info("Please enter the ID of the customer you would like to update");
//		Long customer_ID = Long.valueOf(getInput());
//		LOGGER.info("Please enter a price_per_items");
//		Double price = Double.valueOf(getInput());
//		Order order = OrderService.update(new Order(id, price, customer_ID));
//		LOGGER.info("order List Updated");
////		return order;
	}
//	public void delete() {
//		LOGGER.info("Please enter the order ID");
//		String id = Utils.getInput();
//		long num = Long.parseLong(id);
//		orderService.delete(num);
//	}
//	public CrudServices<Order> getOrderService() {
//		return orderService;
//	}
//	public void setOrderService(CrudServices<Order> orderService) {
//		this.orderService = orderService;
//	}
//	public List<Order> orderDetailsDisplay1(long id) {
//		List<Order> orders = new ArrayList<Order>();
//		orders = getOrderDetails.orderDetailsDisplay(id);
//		return orders;
//	}
//	public long getItemId() {
//		long itemId = getItemId.getItem_ID(new Items(itemName, null));
//		 return itemId;
//	}
//	public long getCustomerId() {
//		LOGGER.info("Please enter your first name");
//		String firstName = Utils.getInput();
//		while (firstName.matches(".*\\d.*")) {
//			LOGGER.info("Please enter your first name");
//			firstName = Utils.getInput();
//		}
//		LOGGER.info("Please enter your last name");
//		String lastName = Utils.getInput();
//		while (firstName.matches(".*\\d.*")) {
//			LOGGER.info("Please enter your last name");
//			lastName = Utils.getInput();
//		}
//		long customerId = getCustomerId.getCustomer_ID(new Customer(firstName,lastName));
//		return customerId;
//	}
//	public void itemDisplay() {
//		for (Items items : getOrderDetails.itemsDisplay()) {
//			LOGGER.info(items.toString());
//		}
//	}
//	public GetOrderDetails<Order, Items, Customer> getGetOrderDetails() {
//		return getOrderDetails;
//	}
//	public void setGetOrderDetails(GetOrderDetails<Order, Items, Customer> getOrderDetails) {
//		this.getOrderDetails = getOrderDetails;
//	}
//	public GetCustomerId<Customer> getGetCustomerId() {
//		return getCustomerId;
//	}
//	public void setGetCustomerId(GetCustomerId<Customer> getCustomerId) {
//		this.getCustomerId = getCustomerId;
//	}
//	public GetItemId<Items> getGetItemId() {
//		return getItemId;
//	}
//	public void setGetItemId(GetItemId<Items> getItemId) {
//		this.getItemId = getItemId;
//	}
//	
//	public void orderLineCreate1(long orderID, long itemId, int quantity) {
//		orderLineService.create(new OrderLine(orderID, itemId, quantity));
//	}

////	public void delete() {
//		// TODO Auto-generated method stub
//		LOGGER.info("Please enter the ID of the item you would like to delete");
//		Long id = Long.valueOf(getInput());
////		OrderService.delete(id);
	

////	@Override
//	public Order create() {
//		// TODO Auto-generated method stub
//		return null;
////	}

	
	


