package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MainButtonServlet extends HttpServlet {
	private static final long serialVersionUID = -3514439693500003690L;
	private static Logger log = Logger.getLogger(MainButtonServlet.class);

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	      PrintWriter out = res.getWriter();
	      out.println(CommonForms.landingPage());
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  String action = req.getParameter("action");

		  switch (action) {
		  case "login": System.out.println("Login keypress detected.");
		                break;
		  case "register":  System.out.println("Register keypress detected.");
			  				break;
		  default: System.out.println("Invalid event source.");
		  			log.warn("Impossible keypress detected in MainButtonServlet");
		  }
	      PrintWriter out = res.getWriter();
	      out.println(CommonForms.landingPage());
	  }
}
