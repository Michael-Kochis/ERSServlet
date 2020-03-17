package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.enums.ERSReimbursementStatus;
import com.revature.model.ERSReimbursement;

public interface ERSReimbursementDAOInterface {
    public void createReimbursement(ERSReimbursement reimb);
    public void deleteReimbursement(ERSReimbursement reimb);
    public void deleteReimbursementByID(long ID);
    public long getMaxID();
    public TreeSet<ERSReimbursement> readAllReimbursements();
    public TreeSet<ERSReimbursement> readReimbursementsByID(long ID);
    public TreeSet<ERSReimbursement> readReimbursementsByOwnerID(long ID);
    public TreeSet<ERSReimbursement> readReimbursementsByStatus(ERSReimbursementStatus rs);
    public void updateReimbursement(ERSReimbursement reimb);
}
