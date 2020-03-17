package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.revature.dao.interfaces.ERSUserDAOInterface;
import com.revature.enums.ERSUserRole;
import com.revature.model.ERSUser;
import com.revature.model.PHash;

public class ERSUserDAO implements ERSUserDAOInterface {
	private static Logger log = Logger.getLogger(ERSUserDAO.class);

	public void createERSUser(ERSUser user) {
	     try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("INSERT INTO ERS_USERS VALUES (?, ?, ?, ?, ?, ?, ?)");
		     st.setLong(1, user.getERSUserID());
		     st.setString(2, user.getERSUserName());
		     st.setString(3, user.getERSPassword().getHash());
		     st.setString(4, user.getFirstName());
		     st.setString(5, user.getLastName());
		     st.setString(6, user.getEmail());
		     st.setLong(7, ERSUserRole.typeToLong(user.getUserRoleID()) );
		     st.execute();
		     log.trace("Single record successfully inserted into ERS_Users table.");
		 } catch (SQLException e){
			 log.warn("Error while inserting into ERS_Users table in database", e);
		 }
	}

	public void deleteERSUser(ERSUser user) {
		deleteERSUserByID(user.getERSUserID() );
	}

	public void deleteERSUserByID(long ID) {
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("DELETE FROM ERS_USERS WHERE ERS_USERS_ID = ?");
		     st.setLong(1, ID);
		     st.execute();
		     
		     log.trace("Single record successfully deleted from ERS_Users table.");
		} catch (SQLException e) {
			log.warn("Error while deleting record from ERS_Users table.", e);
		}
	}

	public TreeSet<ERSUser> readAllUser() {
		TreeSet<ERSUser> returnThis = new TreeSet<ERSUser>();
		ERSUser temp = null;
		long count = 0;
		
		try {
			Connection testConn = JDBCConnector.getConn();
			PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_USERS");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				temp = new ERSUser();
		    	temp.setERSUserID(rs.getLong("ERS_USER_ID"));
		    	temp.setERSUserName(rs.getString("ERS_USERNAME") );
		    	temp.setERSPassword(new PHash(rs.getString("ERS_PASSWORD")) );
		    	temp.setFirstName(rs.getString("USER_FIRST_NAME"));
		    	temp.setLastName(rs.getString("USER_LAST_NAME"));
		    	temp.setEmail(rs.getString("USER_EMAIL"));
		    	temp.setUserRoleID(ERSUserRole.longToType(rs.getLong("USER_ROLE_ID")) );
				returnThis.add(temp);  count++;
			}
		} catch (SQLException e) {
			log.warn("Error reading records from ERS_Users table.", e);
		}
		
		log.trace(count + " records read from ERS_Users table.");
		return returnThis;
	}

	public ERSUser readUserByID(long ID) {
		ERSUser returnThis = null;
		
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID = ?");
		     st.setLong(1, ID);
		     ResultSet rs = st.executeQuery();
		     
		     if (rs.next()) {
		    	 returnThis = new ERSUser();
		    	 returnThis.setERSUserID(ID);
		    	 returnThis.setERSUserName(rs.getString("ERS_USERNAME") );
		    	 returnThis.setERSPassword(new PHash(rs.getString("ERS_PASSWORD")) );
		    	 returnThis.setFirstName(rs.getString("USER_FIRST_NAME"));
		    	 returnThis.setLastName(rs.getString("USER_LAST_NAME"));
		    	 returnThis.setEmail(rs.getString("USER_EMAIL"));
		    	 returnThis.setUserRoleID(ERSUserRole.longToType(rs.getLong("USER_ROLE_ID")) );
		     }
		     log.trace("Single record successfully deleted from ERS_Users table.");
		} catch (SQLException e) {
			log.warn("Error while reading record from ERS_Users table.", e);
		}
		
		return returnThis;
	}

	public ERSUser readUserByUsername(String name) {
		ERSUser returnThis = null;
		
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?");
		     st.setString(1, name);
		     ResultSet rs = st.executeQuery();
		     
		     if (rs.next()) {
		    	 returnThis = new ERSUser();
		    	 returnThis.setERSUserID(rs.getLong("ERS_USER_ID"));
		    	 returnThis.setERSUserName(rs.getString("ERS_USERNAME") );
		    	 returnThis.setERSPassword(new PHash(rs.getString("ERS_PASSWORD")) );
		    	 returnThis.setFirstName(rs.getString("USER_FIRST_NAME"));
		    	 returnThis.setLastName(rs.getString("USER_LAST_NAME"));
		    	 returnThis.setEmail(rs.getString("USER_EMAIL"));
		    	 returnThis.setUserRoleID(ERSUserRole.longToType(rs.getLong("USER_ROLE_ID")) );
		     }
		     log.trace("Single record successfully deleted from ERS_Users table.");
		} catch (SQLException e) {
			log.warn("Error while reading record from ERS_Users table.", e);
		}
		
		return returnThis;
	}

	public void updateERSUser(ERSUser user) {
		try {
		     Connection testConn = JDBCConnector.getConn();
		     PreparedStatement st = testConn.prepareStatement("UPDATE ERS_USERS SET ERS_USERNAME = ?, ERS_PASSWORD = ?, USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_EMAIL = ?, USER_ROLE_ID = ? WHERE ERS_USER_ID = ?");
		     st.setString(1, user.getERSUserName());
		     st.setString(2, user.getERSPassword().getHash());
		     st.setString(3, user.getFirstName());
		     st.setString(4, user.getLastName());
		     st.setString(5, user.getEmail());
		     st.setLong(6, ERSUserRole.typeToLong(user.getUserRoleID()) );
		     st.setLong(7, user.getERSUserID());
		     st.execute();
		     log.trace("Single record successfully updated in ERS_Users table.");
		} catch (SQLException e) {
			log.warn("Error while updating ERS_USERS.", e);
		}
	}

}
