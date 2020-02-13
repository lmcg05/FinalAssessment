package com.qa.controller;

import java.util.List;

public interface GetOrderIdList <T> {
	List<T> orderDetailsDisplay(long id);
	Long getOrder_ID(long custId, double price);

}
