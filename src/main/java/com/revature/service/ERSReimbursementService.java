package com.revature.service;

import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.ERSReimbursementDAO;
import com.revature.enums.ERSReimbursementStatus;
import com.revature.model.ERSReimbursement;

public class ERSReimbursementService {
	private static Logger log = LogManager.getLogger(ERSReimbursementService.class);
	private static ERSReimbursementDAO rd = new ERSReimbursementDAO();
	
	public static void create(ERSReimbursement reimb) {
		rd.createReimbursement(reimb);
	}

	public static TreeSet<ERSReimbursement> getReimbursementsByAuthorName(String name) {
		return rd.readAllReimbursementsByOwnerName(name);
	}

	public static long getNextID() {
		return rd.getNextID();
	}

	public static TreeSet<ERSReimbursement> getReimbursementsByStatus(ERSReimbursementStatus status) {
		return rd.readReimbursementsByStatus(status);
	}

	public static void setReceipt(long ID, byte[] buffer) {
		rd.setReciptByReimbursementID(ID, buffer);
	}

	public static void update(long modify, String username, ERSReimbursementStatus status) {
		rd.updateStatus(modify, username, status);
	}

}
