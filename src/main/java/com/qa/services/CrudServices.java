package com.qa.services;
import java.util.List;

import domain.Items;


public interface CrudServices<T> {
	

	    public List<T> readAll();
	     
	    T create(T t);
	     
	    T update( T t);
	 
	    void delete(Long id);

		


		

	

	}

