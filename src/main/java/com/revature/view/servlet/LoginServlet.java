package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.service.ERSUserService;
import com.revature.view.forms.CommonForms;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -4938596647091194995L;
	private static Logger log = LogManager.getLogger(LoginServlet.class);

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
		  PrintWriter out = res.getWriter();
		  
		  if (ERSUserService.login(name, pass)) {
			  log.info("User " + name + " has logged in.");
			  HttpSession session = req.getSession();
			  session.setAttribute("username", name);
			  
			  out.println(CommonForms.selectReimbForm(name) );
		  } else {
			  out.println("<h4>User name and password did not match.</h4>");
			  out.println(CommonForms.loginForm());
		  }
		  
	  }
}
