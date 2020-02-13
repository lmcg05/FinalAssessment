package com.qa.services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.Dao;

import domain.Customer;


public class CustomerServiceTest {
	

	@RunWith
	(MockitoJUnitRunner.class)
	public class CustomerServicesTest {
		
		@Mock
		private Dao<Customer> customerDao;
		
		@InjectMocks
		private CustomerService customerService;
		
		@Test
		public void customerServicesCreate() {
			Customer customer = new Customer("chris", "perrins");
			customerService.create(customer);
			Mockito.verify(customerDao, Mockito.times(1)).create(customer);
		}
		
		@Test
		public void customerServicesRead() {
			customerService.readAll();
			Mockito.verify(customerDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void customerServicesUpdate() {
			Customer customer = new Customer("chris", "perrins");
			customerService.update(customer);
			Mockito.verify(customerDao, Mockito.times(1)).update(customer);
		}
		
		@Test
		public void customerServicesDelete() {
			customerService.delete(1L);;
			Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
		}
	}
}
