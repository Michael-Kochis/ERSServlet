package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ERSServlet extends HttpServlet{
	private static final long serialVersionUID = -4973076404122935147L;

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  res.setContentType("text/html");
		  
	      PrintWriter out = res.getWriter();

	      out.println("<h1>Hello World!</h1>");
	      System.out.println("<h1>Hello World!</h1>");
	 }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
	 }
}