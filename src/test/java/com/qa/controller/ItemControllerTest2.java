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

import com.qa.services.ItemsService;

import domain.Items;
@	RunWith(MockitoJUnitRunner.class)
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
		Mockito.when(itemsServices.readAll()).thenReturn(items);
		assertEquals(items, itemsController.readAll());
	}



	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemsController).getInput();
		itemsController.delete();
		Mockito.verify(itemsServices, Mockito.times(1)).delete(1L);
	}
	
}


