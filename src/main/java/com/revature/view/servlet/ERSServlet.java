package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.controller.Driver;

public class ERSServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(ERSServlet.class);
	private static final long serialVersionUID = -4973076404122935147L;

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  res.setContentType("text/html");
		  
	      PrintWriter out = res.getWriter();

	      out.println("<h1>Hello World!</h1>");
	      out.println(CommonForms.userNameForm());
	 }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	 }

	public static void nameMe(HttpServletRequest req, HttpServletResponse res, String name) {
		try {
			PrintWriter out = res.getWriter();
		    out.println("<h1>Hello, " + name + "!</h1>");
		    out.println(CommonForms.userNameForm());
		} catch (IOException e) {
			log.warn("IOException in nameMe function of ERSServlet.", e);
		}
		
	}
}