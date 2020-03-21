package com.revature.service;

import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.ERSReimbursementDAO;
import com.revature.model.ERSReimbursement;

public class ERSReimbursementService {
	private static Logger log = LogManager.getLogger(ERSReimbursementService.class);
	private static ERSReimbursementDAO rd = new ERSReimbursementDAO();
	
	public static TreeSet<ERSReimbursement> getReimbursementsByAuthorName(String name) {
		return rd.readAllReimbursementsByOwnerName(name);
	}
}
