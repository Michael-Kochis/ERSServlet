package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.interfaces.ERSReimbursementDAOInterface;
import com.revature.enums.ERSReimbursementStatus;
import com.revature.enums.ERSReimbursementType;
import com.revature.model.ERSReimbursement;

import oracle.sql.DATE;

public class ERSReimbursementDAO implements ERSReimbursementDAOInterface {
	private static Logger log = LogManager.getLogger(ERSReimbursementDAO.class);

	public void createReimbursement(ERSReimbursement reimb) {
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		     st.setLong(1, reimb.getReimbID() );
		     st.setDouble(2, reimb.getReimbAmount() );
		     //st.setDate(3, Date.getDate() );
		     st.setNull(4, 0);
		     st.setString(5, reimb.getReimbDescription() );
		     st.setNull(6, 0);
		     st.setLong(7, reimb.getReimbAuthor() );
		     st.setLong(8, 0L);
		     st.setLong(9, 0L);
		     st.setLong(10, ERSReimbursementType.typeToLong(reimb.getReimbType()) );
		     st.execute();
		} catch (SQLException e) {
			log.warn("Error encountered writing to ERS_REIMBURSEMENT table.", e);
		}
	}

	public void deleteReimbursement(ERSReimbursement reimb) {
		deleteReimbursementByID(reimb.getReimbID() );
	}

	public void deleteReimbursementByID(long ID) {
		// TODO Auto-generated method stub

	}

	public long getMaxID() {
		// TODO Auto-generated method stub
		return 0;
	}

	public TreeSet<ERSReimbursement> readAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeSet<ERSReimbursement> readReimbursementsByID(long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeSet<ERSReimbursement> readReimbursementsByOwnerID(long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeSet<ERSReimbursement> readReimbursementsByStatus(ERSReimbursementStatus rs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateReimbursement(ERSReimbursement reimb) {
		// TODO Auto-generated method stub

	}

}
