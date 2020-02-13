package com.qa.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.services.CrudServices;
import com.qa.services.CustomerService;

import domain.Customer;
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private CustomerService customerServices;
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;
	@SuppressWarnings("null")
	@Test
	public void readAllTest() {
		CrudServices<Customer> customerService = null;
		CustomerController customerController = new CustomerController(customerService);
		List<Customer> customer = new ArrayList<>();
		customer.add(new Customer("Chris", "P"));
		customer.add(new Customer("Rhys", "T"));
		customer.add(new Customer("Nic", "J"));
		Mockito.when(customerService.readAll()).thenReturn(customer);
		assertEquals(customer, customerController.readAll());
	}
	@Test
	public void createTest() {
		String firstName = "Chris";
		String lastName = "Perrins";
		Mockito.doReturn(firstName, lastName).when(customerController).getInput();
		Customer customer = new Customer(firstName, lastName);
		Customer savedCustomer = new Customer(1L, "Chris", "Perrins");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}
	/**
	 *
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String firstName = "Rhys";
		String lastName = "Thompson";
		Mockito.doReturn(id, firstName, lastName).when(customerController).getInput();
		Customer customer = new Customer(1L, firstName, lastName );
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

	}


