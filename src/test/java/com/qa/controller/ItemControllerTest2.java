package com.qa.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.qa.services.ItemsService;

import domain.Items;

public class ItemControllerTest2 {

	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemsService itemsServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemsController itemsController;

	@Test
	public void readAllTest() {
		ItemsController itemsController = new ItemsController(itemsServices);
		List<Items> items = new ArrayList<>();
		Items.add(new Items("orange", 2.00));
		Items.add(new Items("apple", 4.00));
		//Mockito.when(itemsServices.readAll()).thenReturn(items);
	//	assertEquals(items, itemsController.readAll());
	}

	@Test
	public void createTest() {
		String item_name = "orange";
		Double price_per_items = 2.00;
	//	Mockito.doReturn(item_name, price_per_items).when(itemsController).getInput();
	//	Items items = new Items(item_name, price_per_items);
	//	Items savedItems = new Items(1L, "orange", 2.99);
	//	Mockito.when(itemsServices.create(items)).thenReturn(savedItems);
	//	assertEquals(savedItems, itemsController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String items_name = "oreo";
		Double price_per_items = 2.99;
	//	Mockito.doReturn(id, items_name, price_per_items).when(itemsController).getInput();
		Items items = new Items(1, items_name, price_per_items);
	//	Mockito.when(itemsServices.update(items)).thenReturn(items);
	//	assertEquals(items, itemsController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
	//	Mockito.doReturn(id).when(itemsController).getInput();
	//	itemsController.delete();
	//	Mockito.verify(itemsServices, Mockito.times(1)).delete(1L);
	}
	
}


