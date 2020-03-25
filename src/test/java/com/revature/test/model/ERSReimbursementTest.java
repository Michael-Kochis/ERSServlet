package com.revature.test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.ERSReimbursement;

public class ERSReimbursementTest {
	private ERSReimbursement reimb = new ERSReimbursement();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstantiate() {	
		assertTrue(reimb != null);
	}
	
	@Test
	public void testCompare() {
		ERSReimbursement r2 = new ERSReimbursement();
		
		assertTrue(reimb.compareTo(r2) == 0);
	}

	@Test
	public void testEquals() {
		ERSReimbursement r2 = new ERSReimbursement();
		
		assertTrue(reimb.equals(r2));
	}

}
