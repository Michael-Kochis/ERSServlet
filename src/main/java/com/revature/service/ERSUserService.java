package com.revature.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.ERSUserDAO;
import com.revature.model.ERSUser;

public class ERSUserService {
	private static Logger log = LogManager.getLogger(ERSUserService.class);
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

	public static boolean login(String username, String password) {
		return ud.login(username, password);
	}

	public static long getNextID() {
		return ud.getNextID();
	}

	public static boolean isAdminByName(String name) {
		return ud.isAdminByName(name);
	}

	public ERSUser readUserByID(long id) {
		return ud.readUserByID(id);
	}

	public static ERSUser readERSUserByUsername(String name) {
		return ud.readUserByUsername(name);
	}

	public void updateUser(ERSUser user) {
		ud.updateERSUser(user);
	}

}
