package com.revature.test.enums;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.enums.ERSUserRole;

public class ERSUserRoleTest {

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
	public void testZeroIsEmployee() {
		assertTrue(ERSUserRole.longToType(0L) == ERSUserRole.ERS_UR_EMP);
	}

	@Test
	public void testOneIsAdmin() {
		assertTrue(ERSUserRole.longToType(1L) == ERSUserRole.ERS_UR_FIN_ADM);
	}

	@Test
	public void testEmployeeIsZero() {
		assertTrue(0L == ERSUserRole.typeToLong(ERSUserRole.ERS_UR_EMP));
	}

	@Test
	public void testAdminIsOne() {
		assertTrue(1L == ERSUserRole.typeToLong(ERSUserRole.ERS_UR_FIN_ADM));
	}

}
