package com.revature.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.enums.ERSUserRole;
import com.revature.model.ERSUser;
import com.revature.model.PHash;
import com.revature.service.ERSUserService;

public class ERSUserServiceTest {
	private static ERSUserService us = new ERSUserService();

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
	public void testConstructor() {
		assertNotNull(us);
	}
	
	@Test
	public void testCreateUser() {
		us.deleteUserByID(1L);
		PHash pword = new PHash();  pword.setPassword("Emerald4Boss");
		ERSUser user = new ERSUser(1, "ERS_Emerald", pword, "Emerald", "the Boss", "emerald@revature.com", ERSUserRole.ERS_UR_FIN_ADM);
		us.createUser(user);
		ERSUser proof = us.readUserByID(1L);
		
		assertTrue(user.equals(proof) );
	}
	
	@Test
	public void testUpdate() {
		us.deleteUserByID(2L);
		PHash pword = new PHash();  pword.setPassword("IFlyByNight");
		ERSUser user = new ERSUser(2, "TomFool", pword, "Thomas", "Poole", "tom.poole@revature.com", ERSUserRole.ERS_UR_FIN_ADM);
		us.createUser(user);
		user.setUserRoleID(ERSUserRole.ERS_UR_EMP);
		us.updateUser(user);
		ERSUser proof = us.readUserByID(2L);
		
		assertTrue(ERSUserRole.compare(proof.getUserRoleID(), ERSUserRole.ERS_UR_EMP) );
	}

}
