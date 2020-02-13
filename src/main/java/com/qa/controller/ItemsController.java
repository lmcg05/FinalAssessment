package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.services.CrudServices;
import com.qa.services.GetItemId;

import Utils.Utils;
import domain.Customer;
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
	
	//	private GetItemId<Items> getItemId;
//
//	private Object itemName;
//
//	public ItemsController(CrudServices<Items> ItemsService, GetItemId<Items> getItemId ) {
//		this.ItemsService = ItemsService;
//		this.getItemId=getItemId;
//	}
//
//	String getInput() {
//		return Utils.getInput();
//	}
//	public List<Items> readAll() {
//		for(Items item: ItemsService.readAll()) {
//			LOGGER.info(item.toString());
//		}
	public List<Items> readAll() {
		// TODO Auto-generated method stub
		List<Items> items = ItemsService.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
		//return null;

	}
//	public Items create() {
//		LOGGER.info("Please enter item name");
//		String itemName = Utils.getInput(); 
//		while(itemName.matches(".*\\d.*")) {
//			LOGGER.info("Please enter item name");
//			itemName = Utils.getInput();
//		}
//		LOGGER.info("Please enter the item price");
//		String price= Utils.getInput(); 
//		while(price.matches(".*[A-Z a-z].*")) {
//			LOGGER.info("Please enter the item price");
//			price = Utils.getInput();
//		}
//		Double itemPrice = Double.parseDouble(price);
//		LOGGER.info("Please enter the item quantity");
//		String quantity = Utils.getInput();  ;
//		while(quantity.matches(".*[A-Z a-z].*")) {
//			LOGGER.info("Please enter the item quantity");
//			quantity = Utils.getInput();
//		}
//		Long itemQuantity = Long.parseLong(quantity);
//		
//		return ItemsService.create(new Items(itemName,itemPrice,itemQuantity));
//		
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
		Items items = ItemsService.update( new Items(id, Items_name, price_per_items));
		LOGGER.info("Item List Updated");
		return items;
	}
//	public Items update() {
//		LOGGER.info("Hi, it seems you want to change some details, please follow the steps below");
//		Long itemid= getItem_ID();
//		if(itemid!=0) {
//		LOGGER.info("Please enter new or current item name");
//		String itemName = Utils.getInput(); 
//		while(itemName.matches(".*\\d.*")) {
//			LOGGER.info("Please enter new or current item name");
//			itemName = Utils.getInput();
//		}
//		LOGGER.info("Please enter the new or current item price");
//		String price= Utils.getInput(); 
//		while(price.matches(".*[A-Z a-z].*")) {
//			LOGGER.info("Please enter the new or current item price");
//			price = Utils.getInput();
//		}
//		Double itemPrice = Double.parseDouble(price);
//		LOGGER.info("Please enter the new or current item quantity");
//		String quantity = Utils.getInput();  ;
//		while(quantity.matches(".*[A-Z a-z].*")) {
//			LOGGER.info("Please enter the new or current item quantity");
//			quantity = Utils.getInput();
//		}
//		Long itemQuantity = Long.parseLong(quantity);
//		
//		
//		ItemsService.update(itemid, new Items(itemName,itemPrice,itemQuantity));
//		}
//		return null;
//	}

	public void delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		ItemsService.delete(id);
	
	}
}
//
//
//	public Long getItemId() {
//		LOGGER.info("Please enter the name");
//		String itemName = Utils.getInput();
//		while(itemName.matches(".*\\d.*")) {
//			LOGGER.info("Please enter item name");
//			itemName = Utils.getInput();
//			
//	Long itemId = getItemId.getItem_ID(new Items(itemName));
//	  return itemId;
//	}
//		return null;
//
//}
//
//	@Override
//	public Long getItem_ID() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}