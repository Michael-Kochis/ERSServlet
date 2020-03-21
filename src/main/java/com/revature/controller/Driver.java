package com.revature.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.JDBCConnector;

public class Driver {
	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
    	JDBCConnector.testDatabase();
    }
}
