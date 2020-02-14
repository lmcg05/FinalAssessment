package com.qa.services;

import java.util.List;

import com.qa.persistence.Dao;

import domain.Customer;

public class CustomerService implements CrudServices<Customer> {

	Dao<Customer> customerDao;

private Dao<Customer> customerDao1;
	
	public CustomerService(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(Long id) {
		customerDao.delete(id);
	}

}
