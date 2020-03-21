package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import com.revature.view.forms.CommonForms;

import org.apache.logging.log4j.LogManager;

public class MainButtonServlet extends HttpServlet {
	private static final long serialVersionUID = -3514439693500003690L;
	private static Logger log = LogManager.getLogger(MainButtonServlet.class);

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
		  
		  PrintWriter out = res.getWriter();

		  switch (action) {
		  case "login": res.sendRedirect("/ERSServlet/login");
		                break;
		  case "register":  res.sendRedirect("/ERSServlet/register");
			  				break;
		  default: System.out.println("Invalid event source.");
		  			log.warn("Impossible keypress detected in MainButtonServlet");
		  }
	      out.println(CommonForms.landingPage());
	  }
}
