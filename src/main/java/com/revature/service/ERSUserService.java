package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.ERSUserDAO;
import com.revature.model.ERSUser;

public class ERSUserService {
	private static Logger log = Logger.getLogger(ERSUserService.class);
	private static ERSUserDAO ud = new ERSUserDAO();
	
	public ERSUserService() {
		super();
	}

	public void createUser(ERSUser user) {
		ud.createERSUser(user);
	}
	
	public void deleteUserByID(long id) {
		ud.deleteERSUserByID(id);
	}

	public ERSUser readUserByID(long id) {
		return ud.readUserByID(id);
	}

	public void updateUser(ERSUser user) {
		ud.updateERSUser(user);
	}

}
