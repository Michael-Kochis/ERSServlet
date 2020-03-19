package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		  String name = req.getParameter("username");
		  String pass = req.getParameter("password");
		  String conf = req.getParameter("confirm");
		  if (pass.equals(conf)) {
			  System.out.println(name);
			  ERSServlet.nameMe(req, res, name);
		  } else {
			  PrintWriter out = res.getWriter();
			  out.println("<h4>Password and confirmation did not match.</h4>");
			  out.println(CommonForms.registrationForm());
		  }
		  
	  }
}
