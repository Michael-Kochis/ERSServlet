package com.revature.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.ERSReimbursementService;

public class ReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 5273949283894859448L;
	private static ERSReimbursementService rs = new ERSReimbursementService();
	private static Logger log = LogManager.getLogger(ReimbServlet.class);
	
	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	 }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	 }

	
}
