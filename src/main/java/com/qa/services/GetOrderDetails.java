package com.qa.services;

import java.util.List;

import domain.Items;

public interface GetOrderDetails <T, U, V> {
	Long getOrderId(long customer_ID, double price);
	Double itemPrice(U u);
	public List<Items> itemsDisplay();
    Long getCustomer_ID(V v);
    Long getItem_ID(U u);
    List<T> orderDetailsDisplay(long id);


}
