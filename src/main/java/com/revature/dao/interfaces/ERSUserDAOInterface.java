package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.ERSUser;

public interface ERSUserDAOInterface {
	public void createERSUser(ERSUser user);
	public void deleteERSUser(ERSUser user);
	public void deleteERSUserByID(long ID);
    public TreeSet<ERSUser> readAllUser();
    public ERSUser readUserByID(long ID);
    public ERSUser readUserByUsername(String name);
    public void updateERSUser(ERSUser user);
}
