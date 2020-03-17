package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.dao.JDBCConnector;

public class Driver {
	private static Logger log = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
    	JDBCConnector.testDatabase();
    }
}
