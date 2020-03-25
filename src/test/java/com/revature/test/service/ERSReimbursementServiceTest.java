package com.revature.test.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.enums.ERSReimbursementStatus;
import com.revature.enums.ERSReimbursementType;
import com.revature.model.ERSReimbursement;
import com.revature.service.ERSReimbursementService;

public class ERSReimbursementServiceTest {
	ERSReimbursementService rs = new ERSReimbursementService();

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
	public void testInstantiates() {
		assertNotNull(rs);
	}
	
	@Test
	public void testGetByName() {
		TreeSet<ERSReimbursement> bag = new TreeSet<ERSReimbursement>();
		bag = ERSReimbursementService.getReimbursementsByAuthorName("TomFool");
		
		assertTrue(bag.size() > 0);
	}
	
	@Test
	public void testGetByStatus() {
		TreeSet<ERSReimbursement> bag = new TreeSet<ERSReimbursement>();
		bag = ERSReimbursementService.getReimbursementsByStatus(ERSReimbursementStatus.DENIED);
		
		assertTrue(bag.size() > 0);
	}

	@Test
	public void testCreateReimbursement() {
		Long nID = ERSReimbursementService.getNextID();
		ERSReimbursement reimb = new ERSReimbursement(nID, 15.00, LocalDateTime.now(), null,
				"My McDonald's tab.", 1L, 0L, ERSReimbursementStatus.PENDING, 
				ERSReimbursementType.FOOD);
		ERSReimbursementService.create(reimb);
		reimb = ERSReimbursementService.getReimbursementByID(nID);
		
		assertTrue(reimb != null);
	}
}
