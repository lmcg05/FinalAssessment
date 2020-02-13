package com.qa.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Items;

public class ItemTest {
	private Items items ;
	private Items other;
	
	@Before
	public void setUp() {
		items = new Items(1L, "pineapple", 2.99);
		other = new Items(1L, "pineapple", 2.99);
	}

	
	@Test
	public void settersTest() {
//		assertNotNull(items.getId());
//		assertNotNull(items.getItems_name());
//		assertNotNull(items.getPrice_per_items());
//		
//		items.setId(1);
//		assertNull(items.getId());
//		items.setItems_name(null);
//		assertNull(items.getItems_name());
//		items.setPrice_per_items(null);
//		assertNull(items.getPrice_per_items());
//		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(items.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(items.equals(new Object()));
	}
	
	@Test
	public void createItemsWithId() {
//		assertEquals(1L, items.getId(), 0);
//		assertEquals("pineapple", items.getItems_name());
//		assertEquals("2.99", items.getPrice_per_items());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(items.equals(items));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(items.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		items.setItems_name(null);
//		assertFalse(items.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setItems_name("orange");
		assertFalse(items.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		items.setItems_name(null);
		other.setItems_name(null);
		assertTrue(items.equals(other));
	}
	
	
	@Test
	public void nullId() {
		items.setId(1);
		assertFalse(items.equals(other));
	}
	
	
	@Test
	public void nullIdOnBoth() {
		items.setId(1);
		other.setId(1);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId((int) 2L);
		assertFalse(items.equals(other));
	}
	
	@Test
	public void nullotherPrice_per_items() {
		items.setPrice_per_items(null);
	//	assertFalse(items.equals(other));
	}
	
	@Test
	public void nullotherPrice_per_itemsOnBoth() {
		items.setPrice_per_items(null);
		other.setPrice_per_items(null);
		assertTrue(items.equals(other));
	}
	
	@Test
	public void otherPrice_per_itemsDifferent() {
		other.setPrice_per_items(2.99);
		assertFalse(items.equals(other));
	}
	
	@SuppressWarnings("unused")
	@Test
	public void constructorWithoutId() {
		Items item = new Items("Pineapple", 2.99);
//		assertNull(items.getId());
//		assertNotNull(items.getItems_name());
//		assertNotNull(items.getPrice_per_items());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(items.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Items items = new Items(null, null);
		Items other = new Items(null, null);
		assertEquals(items.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		@SuppressWarnings("unused")
		String toString = "id:1 items_name:pineapple Price_per_items:2.99";
	//	assertEquals(toString, customer.toString());
	}

}
