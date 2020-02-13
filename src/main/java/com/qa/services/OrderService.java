package com.qa.services;



import java.util.List;

import com.qa.persistence.Dao;


import domain.Order;

public class OrderService implements CrudServices<Order> {
	Dao<Order> orderDao;

	public OrderService(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order order) {
		return orderDao.create(order);
	}

	public Order update(Order order) {
		return orderDao.update(order);
	}

	public void delete(Long id) {
		orderDao.delete(id);
	}

	public Order update(Long id, Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order update(long id, Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	



}

