package com.revature.test.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.ERSUser;
import com.revature.service.ERSUserService;
import com.revature.view.forms.ReimbForms;

public class ReimbFormsTest {

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
	public void testReceiptFormExists() {
		String form = ReimbForms.reimbReceiptForm(1L);
		
		assertTrue(form != null);
	}

	@Test
	public void testReimbsByNameExists() {
		String form = ReimbForms.reimbsByName("TomFool");
		
		assertTrue(form != null);
	}

	@Test
	public void testAllPendingReimbsExists() {
		String form = ReimbForms.allPendingReimbs();
		
		assertTrue(form != null);
	}

	@Test
	public void testNewReimbExists() {
		ERSUser user = ERSUserService.readERSUserByUsername("TomFool");
		String form = ReimbForms.NewReimb(user);
		
		assertTrue(form != null);
	}

}
