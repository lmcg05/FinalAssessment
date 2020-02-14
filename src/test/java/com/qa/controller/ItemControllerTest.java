package com.qa.controller;




import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;


import com.qa.services.ItemsService;

import domain.Items;

public class ItemControllerTest {
	@Mock
	private ItemsService itemServices;
	@Spy
	@InjectMocks
	private ItemsController itemController;
	@Test
		public void readAllTest() {
		ItemsController itemController = new ItemsController(itemServices);
		List<Items>item1 = new ArrayList<Items>();
		List<Items>item2 = new ArrayList<Items>();
		item1.add(new Items(1L, "B",1.00));
		item2.add(new Items("B", 1.00));
	//	Mockito.when(itemServices.readAll()).thenReturn(item1);
	//	assertEquals(item2, itemController.readAll());
	}
}
	
//	@Mock
//	private Dao<Items> itemsDao;
//	@InjectMocks
//	private ItemsService itemsService;
//	@Test
//	public void itemsServicesCreate() {
//		Items items = new Items("Water bottle", 5.49);
//		itemsService.create(items);
//		Mockito.verify(itemsDao, Mockito.times(1)).create(items);
//	}
//	@Test
//	public void itemsServicesRead() {
//		itemsService.readAll();
//		Mockito.verify(itemsDao, Mockito.times(1)).readAll();
//	}
//	@Test
//	public void itemsServicesUpdate() {
//		Items items = new Items("mobile", 45.99);
//		itemsService.update(items);
//		Mockito.verify(itemsDao, Mockito.times(1)).update(items);
//	}
//	@Test
//	public void itemsServicesDelete() {
//		itemsService.delete(1L);;
//		Mockito.verify(itemsDao, Mockito.times(1)).delete(1L);
//	}
//}
	/**
	 *  The thing I want to fake functionlity for
	 */
//	@Mock
//	private ItemsService customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
//	@Spy
//	@InjectMocks
//	private ItemsController itemsController;

//	@Test
//	public void readAllTest() {
//		ItemsController itemController = new ItemsController(itemsServices);
//		List<Items> customers = new ArrayList<>();
//		Items.add(new Customer("Chris", "P"));
//		customers.add(new Customer("Rhys", "T"));
//		customers.add(new Customer("Nic", "J"));
//		Mockito.when(customerServices.readAll()).thenReturn(customers);
//		assertEquals(customers, customerController.readAll());
//	}
//
//	@Test
//	public void createTest() {
//		String firstName = "Chris";
//		String surname = "Perrins";
//		Mockito.doReturn(firstName, surname).when(customerController).getInput();
//		Customer customer = new Customer(firstName, surname);
//		Customer savedCustomer = new Customer(1L, "Chris", "Perrins");
//		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
//		assertEquals(savedCustomer, customerController.create());
//	}
//
//	/**
//	 * 
//	 */
//	@Test
//	public void updateTest() {
//		String id = "1";
//		String firstName = "Rhys";
//		String surname = "Thompson";
//		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
//		Customer customer = new Customer(1L, firstName, surname);
//		Mockito.when(customerServices.update(customer)).thenReturn(customer);
//		assertEquals(customer, customerController.update());
//	}
//	
//
//	/**
//	 * Delete doesn't return anything, so we can just verify that it calls the delete method
//	 */
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(customerController).getInput();
//		customerController.delete();
//		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
//	}
//	
//}
//
//	}
//}
//
