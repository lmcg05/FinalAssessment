package com.qa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.qa.services.CrudServices;

import com.qa.services.OrderService;

import Utils.Utils;
import domain.Customer;
import domain.Items;
import domain.Order;
import domain.OrderLine;

public class OrderController implements CrudController<Order> {
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
		for (Order orders : order) {
			LOGGER.info(orders.toString());
		}
		return order;
	}

	public Order create() {
		LOGGER.info("Enter customer id:");
		Long id = Long.valueOf(Utils.getInput());
		Double totalPrice = 0.00;
		Long totalQuantity = 0L;
		ArrayList<Long> items = new ArrayList<Long>();
		ArrayList<Long> quantity = new ArrayList<Long>();
		ArrayList<Double> price = new ArrayList<Double>();
		while (true) {
			LOGGER.info("Please enter item id or enter 0 if order is complete:");
			Long l = Long.valueOf(Utils.getInput());
			items.add(l);
			if (l == 0) {
				break;
			}
			LOGGER.info("Please enter quantity of item");
			Long i = Long.valueOf(Utils.getInput());
			quantity.add(i);
			LOGGER.info("Please enter price of item");
			Double j = Double.valueOf(Utils.getInput());
			price.add(j);
		}
		for (int k = 0; k < quantity.size(); k++) {
			Double price1 = (quantity.get(k)) * (price.get(k));
			totalPrice = totalPrice + price1;
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

}


