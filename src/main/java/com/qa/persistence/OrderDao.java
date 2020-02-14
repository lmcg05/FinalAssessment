package com.qa.persistence;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao<T, U, V> {
	T create(T t);

	// R

	public ArrayList<T> readAll();

	T update(T t);

	void delete(Long id);

	List<U> itemsDisplay();

	List<T> orderDetailsDisplay(long id);

	Double itemsPrice(U u);

	Long getCustomer_ID(V v);

	Long getOrder_ID(long customer_ID, double price);

	Long getItem_Id(U u);
}
