package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.enums.ERSUserRole;
import com.revature.model.ERSUser;
import com.revature.model.PHash;
import com.revature.service.ERSUserService;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -49843099449695564L;

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  PrintWriter out = res.getWriter();
		  out.println(CommonForms.registrationForm());
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  PrintWriter out = res.getWriter();
		  long neoID = ERSUserService.getNextID();
		  String name = req.getParameter("username");
		  String pass = req.getParameter("password");
		  String conf = req.getParameter("confirm");
		  String first = req.getParameter("firstName");
		  String last = req.getParameter("lastName");
		  String email = req.getParameter("email");
		  
		  if (pass.equals(conf)) {
			  PHash pword = new PHash(); pword.setPassword(pass);
			  ERSUser user = new ERSUser(neoID, name, pword, first, last, email, ERSUserRole.ERS_UR_EMP);
			  ERSUserService us = new ERSUserService();
			  us.createUser(user);
			  
			  out.println(CommonForms.landingPage() );
		  } else {
			  out.println("<h4>Password and confirmation did not match.</h4>");
			  out.println(CommonForms.registrationForm());
		  }
		  
	  }
}
