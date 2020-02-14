package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.services.CrudServices;

import Utils.Utils;

import domain.Items;

public class ItemsController implements CrudController<Items> {
	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);

	private CrudServices<Items> ItemsService;

	public ItemsController(CrudServices<Items> itemsService) {
		this.ItemsService = itemsService;

	}

	String getInput() {
		return Utils.getInput();

	}
	// TODO Auto-generated constructor stub

	public List<Items> readAll() {
		// TODO Auto-generated method stub
		List<Items> items = ItemsService.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
		// return null;

	}

	public Items create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter a items_name");
		String items_name = getInput();
		LOGGER.info("Please enter a price_per_items");
		Double price_per_items = Double.valueOf(getInput());
		Items items = ItemsService.create(new Items(items_name, price_per_items));
		LOGGER.info("Customer created");
		return items;
	}

	public Items update() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the ID of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a Items_name");
		String Items_name = getInput();
		LOGGER.info("Please enter a price_per_items");
		Double price_per_items = Double.valueOf(getInput());
		Items items = ItemsService.update(new Items(id, Items_name, price_per_items));
		LOGGER.info("Item List Updated");
		return items;
	}

	public void delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		ItemsService.delete(id);

	}
}
