package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	
//	private Customer customer;
//	private Customer other;
//	
//	@Before
//	public void setUp() {
//		customer = new Customer(1L, "Chris", "Perrins");
//		other = new Customer(1L, "Chris", "Perrins");
//	}
//	
//	@Test
//	public void settersTest() {
//		assertNotNull(customer.getId());
//		assertNotNull(customer.getFirstName());
//		assertNotNull(customer.getLastNAme());
//		customer.setId((Integer) null);
//		assertNull(customer.getId());
//		customer.setFirstName(null);
//		assertNull(customer.getFirstName());
//		customer.setLastNAme(null);
//		assertNull(customer.getLastNAme());
//		
//	}
//	
//	@Test
//	public void equalsWithNull() {
//		assertFalse(customer.equals(null));
//	}
//	
//	@Test
//	public void equalsWithDifferentObject() {
//		assertFalse(customer.equals(new Object()));
//	}
//	
//	@Test
//	public void createCustomerWithId() {
//		assertEquals(1L, customer.getId(), 0);
//		assertEquals("Chris", customer.getFirstName());
//
//	}
//	
//	@Test
//	public void checkEquality() {
//		assertTrue(customer.equals(customer));
//	}
//	
//	@Test
//	public void checkEqualityBetweenDifferentObjects() {
//		assertTrue(customer.equals(other));
//	}
//	
//	@Test
//	public void customerNameNullButOtherNameNotNull() {
//		customer.setFirstName(null);
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void customerNamesNotEqual() {
//		other.setFirstName("rhys");
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void checkEqualityBetweenDifferentObjectsNullName() {
//		customer.setFirstName(null);
//		other.setFirstName(null);
//		assertTrue(customer.equals(other));
//	}
//	
//	@Test
//	public void nullId() {
//		customer.setId((Integer) null);
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void nullIdOnBoth() {
//		customer.setId((Integer) null);
//		other.setId((Integer) null);
//		assertTrue(customer.equals(other));
//	}
//	
//	@Test
//	public void otherIdDifferent() {
//		other.setId((int) 2L);
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void nullLastNAme() {
//		customer.setLastNAme(null);
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void nullLastNAmeOnBoth() {
//		customer.setLastNAme(null);
//		other.setLastNAme(null);
//		assertTrue(customer.equals(other));
//	}
//	
//	@Test
//	public void otherLastNAmeDifferent() {
//		other.setLastNAme("thompson");
//		assertFalse(customer.equals(other));
//	}
//	
//	@Test
//	public void constructorWithoutId() {
//		Customer customer = new Customer("Chris", "Perrins");
//		assertNull(customer.getId());
//		assertNotNull(customer.getFirstName());
//		assertNotNull(customer.getLastNAme());
//	}
//	
//	@Test
//	public void hashCodeTest() {
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	@Test
//	public void hashCodeTestWithNull() {
//		Customer customer = new Customer(null, null);
//		Customer other = new Customer(null, null);
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	
//	@Test
//	public void toStringTest() {
//		String toString = "id:1 first name:Chris surname:Perrins";
//		assertEquals(toString, customer.toString());
//	}
//
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//}
}
