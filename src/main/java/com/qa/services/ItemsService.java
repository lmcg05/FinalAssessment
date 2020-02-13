package com.qa.services;

import java.util.List;

import com.qa.persistence.Dao;

import domain.Items;

public class ItemsService implements CrudServices<Items> {

	Dao<Items> itemsDao;

	public ItemsService(Dao<Items> itemsDao) {
		this.itemsDao = itemsDao;
	}

	public List<Items> readAll() {
		return itemsDao.readAll();
	}

	public Items create(Items items) {
		return itemsDao.create(items);
	}

	public Items update(Items items) {
		return itemsDao.update(items);
	}

	public void delete(Long id) {
		itemsDao.delete(id);
	}

	public Items update(Long id, Items t) {
		// TODO Auto-generated method stub
		return null;
	}


		
	}



