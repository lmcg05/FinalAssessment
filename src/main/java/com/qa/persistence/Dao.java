package com.qa.persistence;



import java.util.ArrayList;



public interface Dao <T>{
	T create(T t); // create a vehicle
	
	//R
 
	public ArrayList<T> readAll(); // read all the vehicles in the list
	//U
	T update (T t);
	
	//Dss
	//void delete (Long id, T t); //delete things from vehic

	void delete(Long id);

	



	

}
