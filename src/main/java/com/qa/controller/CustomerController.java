package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.services.CrudServices;

import Utils.Utils;
import domain.Customer;

public class CustomerController implements CrudController<Customer> {

	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	public List<Customer> readAll() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerService.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;

	}

	public Customer create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String lastName = getInput();
		LOGGER.info("Please enter an email");
		String email = getInput();
		Customer customer = customerService.create(new Customer(firstName, lastName, email));
		LOGGER.info("Customer created");
		return customer;
	}

	public Customer update() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String lastName = getInput();
		Customer customer = customerService.update(new Customer(id, firstName, lastName));
		LOGGER.info("Customer Updated");
		return customer;
	}

	public void delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerService.delete(id);
	}

}