package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.ERSUser;
import com.revature.service.ERSReimbursementService;
import com.revature.service.ERSUserService;
import com.revature.view.forms.ReimbForms;

public class ReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 5273949283894859448L;
	private static ERSReimbursementService rs = new ERSReimbursementService();
	private static Logger log = LogManager.getLogger(ReimbServlet.class);
	
	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  doPost(req, res);
	 }

	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  PrintWriter out = res.getWriter();
		  HttpSession sess = req.getSession();
		  String action = req.getParameter("action");
		  String uName = (String) sess.getAttribute("username");
		  ERSUser user = ERSUserService.readERSUserByUsername(uName);
		  
		  switch(action) {
		  case "newReimb":  out.println(ReimbForms.NewReimb(user));
			  				break;
		  default:  log.warn("Invalid key detected.");
		  }
	 }

	
}
