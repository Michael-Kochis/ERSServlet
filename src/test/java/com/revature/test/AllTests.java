package com.revature.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.revature.test.DAO.AllDAOTests;
import com.revature.test.controller.AllControllerTests;
import com.revature.test.enums.AllEnumTests;
import com.revature.test.model.AllModelTests;
import com.revature.test.service.AllServiceTests;
import com.revature.test.view.AllViewTests;

@RunWith(Suite.class)
@SuiteClasses({ AllEnumTests.class, AllServiceTests.class, AllControllerTests.class, 
	AllDAOTests.class, AllModelTests.class, AllViewTests.class })
public class AllTests {

}
