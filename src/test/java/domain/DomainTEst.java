package domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.persistence.Domain;

public class DomainTEst {
	
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMER;
		assertTrue(domain.description().toLowerCase().contains("customer"));
	}
	
	@Test
	public void itemTest() {
		Domain domain = Domain.ITEM;
		assertTrue(domain.description().toLowerCase().contains("item"));
	}
	
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDER;
		assertTrue(domain.description().toLowerCase().contains("items"));
	}
	
	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.description().toLowerCase().contains("close"));
	}


	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
