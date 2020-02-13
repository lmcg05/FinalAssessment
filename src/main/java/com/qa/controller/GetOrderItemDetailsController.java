package com.qa.controller;

public interface GetOrderItemDetailsController <T>{
	void readAllOrderLine();
    
    void orderLineCreate(long order_ID, long item_ID, int quantity);
     
    void orderLineUpdate();
     
    void orderLineDelete();
}


