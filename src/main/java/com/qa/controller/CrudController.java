package com.qa.controller;

import java.util.List;

public interface CrudController<T> {
	/**
	 * Create, Read, Update and Delete controller. Takes in inputs for each action
	 * to be sent to a service class
	 */

	List<T> readAll();

	T create();

	T update();

	void delete();

}
