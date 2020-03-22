package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.interfaces.ERSReimbursementDAOInterface;
import com.revature.enums.ERSReimbursementStatus;
import com.revature.enums.ERSReimbursementType;
import com.revature.model.ERSReimbursement;
import com.revature.model.ERSUser;
import com.revature.service.ERSUserService;

public class ERSReimbursementDAO implements ERSReimbursementDAOInterface {
	private static Logger log = LogManager.getLogger(ERSReimbursementDAO.class);

	public void createReimbursement(ERSReimbursement reimb) {
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		     st.setLong(1, reimb.getReimbID() );
		     st.setDouble(2, reimb.getReimbAmount() );
		     st.setTimestamp(3, Timestamp.valueOf(reimb.getReimbSubmitted()) );
		     st.setNull(4, 0);
		     st.setString(5, reimb.getReimbDescription() );
		     st.setNull(6, 0);
		     st.setLong(7, reimb.getReimbAuthor() );
		     st.setLong(8, 0L);
		     st.setLong(9, ERSReimbursementStatus.typeToLong(reimb.getReimbStatus()));
		     st.setLong(10, ERSReimbursementType.typeToLong(reimb.getReimbType()) );
		     
		     st.execute();
		     log.trace("Single record added to ERS_REIMBURSEMENT table.");
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

	public long getNextID() {
		long returnThis = 0L;
		
		try {
	     Connection testConn = JDBCConnector.getConn();
	     PreparedStatement st = testConn.prepareStatement("SELECT MAX(REIMB_ID) FROM ERS_REIMBURSEMENT");
	     ResultSet rs = st.executeQuery();
	     
	     if (rs.next()) {
	    	 returnThis = rs.getLong(1);
	     } else {
	    	 log.warn("Data returned, but incorrect format.");
	     }
			
		} catch (SQLException e) {
			log.warn("Error while reading max value from ERS_Reimbursement table.", e);
		}
   	    returnThis++;
		return returnThis;
	}

	public TreeSet<ERSReimbursement> readAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	public ERSReimbursement readReimbursementByID(long ID) {
		ERSReimbursement returnThis = null;
		
		try { 
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?");
		     st.setLong(1, ID);
		     ResultSet rs = st.executeQuery();
		     
		     if (rs.next()) {
		    	 long rID = rs.getLong("REIMB_ID");
		    	 double amount = rs.getDouble("REIMB_AMOUNT");
		    	 LocalDateTime submit = rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime();
		    	 LocalDateTime resolved = null;
		    	 if (rs.getTimestamp("REIMB_RESOLVED") == null) {
		    	    resolved = null;
		    	 } else {
		    	   resolved = rs.getTimestamp("REIMB_RESOLVED").toLocalDateTime();
		    	 }
		    	 String desc = rs.getString("REIMB_DESCRIPTION");
		    	 long authID = rs.getLong("REIMB_AUTHOR");
		    	 long rslvID = rs.getLong("REIMB_RESOLVER");
		    	 ERSReimbursementStatus status = ERSReimbursementStatus.longToType(rs.getLong("REIMB_STATUS_ID"));
		    	 ERSReimbursementType type = ERSReimbursementType.longToType(rs.getLong("REIMB_TYPE_ID"));

		    	 returnThis = new ERSReimbursement(rID, amount, submit, resolved, desc, authID, rslvID, status, type);
		     }
		} catch (SQLException e) {
			log.warn("Error while reading max value from ERS_Reimbursement table.", e);
		}
		
		return returnThis;
	}

	public TreeSet<ERSReimbursement> readReimbursementsByOwnerID(long ID) {
		TreeSet<ERSReimbursement> returnThis = new TreeSet<ERSReimbursement>();
		
		try { 
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?");
		     st.setLong(1, ID);
		     ResultSet rs = st.executeQuery();
		     
		     while (rs.next()) {
		    	 long rID = rs.getLong("REIMB_ID");
		    	 double amount = rs.getDouble("REIMB_AMOUNT");
		    	 LocalDateTime submit = rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime();
		    	 Timestamp tsr = rs.getTimestamp("REIMB_RESOLVED");
		    	 LocalDateTime resolved = null;
	
		    	 if (tsr == null) {
		    		 resolved = null;
		    	 } else {
		    	     resolved = tsr.toLocalDateTime();
		     	 }
		    	 
		     	 String desc = rs.getString("REIMB_DESCRIPTION");
		    	 long authID = rs.getLong("REIMB_AUTHOR");
		    	 long rslvID = rs.getLong("REIMB_RESOLVER");
		    	 ERSReimbursementStatus status = ERSReimbursementStatus.longToType(rs.getLong("REIMB_STATUS_ID"));
		    	 ERSReimbursementType type = ERSReimbursementType.longToType(rs.getLong("REIMB_TYPE_ID"));

		    	 ERSReimbursement neo = new ERSReimbursement(rID, amount, submit, resolved, desc, authID, rslvID, status, type);
		    	 returnThis.add(neo);
		     }
		} catch (SQLException e) {
			log.warn("Error while reading max value from ERS_Reimbursement table.", e);
		}
		
		return returnThis;
	}

	public TreeSet<ERSReimbursement> readAllReimbursementsByOwnerName(String name) {
		ERSUser user = ERSUserService.readERSUserByUsername(name);
		return readReimbursementsByOwnerID(user.getERSUserID() );
	}

	public TreeSet<ERSReimbursement> readReimbursementsByStatus(ERSReimbursementStatus rstat) {
		TreeSet<ERSReimbursement> returnThis = new TreeSet<ERSReimbursement>();
		
		try { 
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?");
		     st.setLong(1, ERSReimbursementStatus.typeToLong(rstat));
		     ResultSet rs = st.executeQuery();
		     
		     while (rs.next()) {
		    	 long rID = rs.getLong("REIMB_ID");
		    	 double amount = rs.getDouble("REIMB_AMOUNT");
		    	 LocalDateTime submit = rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime();
		    	 Timestamp tsr = rs.getTimestamp("REIMB_RESOLVED");
		    	 LocalDateTime resolved = null;
	
		    	 if (tsr == null) {
		    		 resolved = null;
		    	 } else {
		    	     resolved = tsr.toLocalDateTime();
		     	 }
		    	 
		     	 String desc = rs.getString("REIMB_DESCRIPTION");
		    	 long authID = rs.getLong("REIMB_AUTHOR");
		    	 long rslvID = rs.getLong("REIMB_RESOLVER");
		    	 ERSReimbursementStatus status = ERSReimbursementStatus.longToType(rs.getLong("REIMB_STATUS_ID"));
		    	 ERSReimbursementType type = ERSReimbursementType.longToType(rs.getLong("REIMB_TYPE_ID"));

		    	 ERSReimbursement neo = new ERSReimbursement(rID, amount, submit, resolved, desc, authID, rslvID, status, type);
		    	 returnThis.add(neo);
		     }
		} catch (SQLException e) {
			log.warn("Error while reading max value from ERS_Reimbursement table.", e);
		}
		
		return returnThis;
	}

	public void updateReimbursement(ERSReimbursement reimb) {
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? WHERE REIMB_ID = ?");
			 st.setTimestamp(1, Timestamp.valueOf(reimb.getReimbResolved()) );
			 st.setLong(2, reimb.getReimbResolver());
			 st.setLong(3, ERSReimbursementStatus.typeToLong(reimb.getReimbStatus()) ); 
			 st.setLong(4, reimb.getReimbID());
		     
		     st.execute();
		     log.trace("Single record successfully updated in ERS_Reimbursement table.");
		} catch (SQLException e) {
			log.warn("Error while updating record ERS_Reimbursement table.", e);
		}
	}

	public void updateStatus(long ID, String username, ERSReimbursementStatus status) {
		ERSReimbursement reimb = readReimbursementByID(ID);
		ERSUser user = ERSUserService.readERSUserByUsername(username);
		reimb.setReimbResolver(user.getERSUserID() );
		reimb.setReimbResolved(LocalDateTime.now());
		reimb.setReimbStatus(status);
		
		updateReimbursement(reimb);
	}

}
