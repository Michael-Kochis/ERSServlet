package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.enums.ERSReimbursementStatus;
import com.revature.model.ERSReimbursement;

public interface ERSReimbursementDAOInterface {
    public void createReimbursement(ERSReimbursement reimb);
    public void deleteReimbursement(ERSReimbursement reimb);
    public void deleteReimbursementByID(long ID);
    public long getNextID();
    public TreeSet<ERSReimbursement> readAllReimbursements();
    public ERSReimbursement readReimbursementByID(long ID);
    public TreeSet<ERSReimbursement> readReimbursementsByOwnerID(long ID);
    public TreeSet<ERSReimbursement> readReimbursementsByStatus(ERSReimbursementStatus rs);
    public void updateReimbursement(ERSReimbursement reimb);
}
