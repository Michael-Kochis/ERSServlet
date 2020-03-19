package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ERSUserService;

public class LoginServlet extends HttpServlet {
	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  PrintWriter out = res.getWriter();
		  out.println(CommonForms.loginForm());
	  }
	  
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  String name = req.getParameter("username");
		  String pass = req.getParameter("password");
		  if (ERSUserService.login(name, pass)) {
			  System.out.println(name);
			  ERSServlet.nameMe(req, res, name);
		  } else {
			  PrintWriter out = res.getWriter();
			  out.println("<h4>User name and password did not match.</h4>");
			  out.println(CommonForms.loginForm());
		  }
		  
	  }
}
