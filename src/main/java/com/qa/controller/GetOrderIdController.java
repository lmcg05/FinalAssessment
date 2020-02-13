package com.qa.controller;

import java.util.List;

public interface GetOrderIdController<T> {
	List<T> orderDetailsDisplay(long id);
	Long getOrder_ID(long customer_ID, double price);
}

