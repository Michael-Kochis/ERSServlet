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

import com.revature.enums.ERSReimbursementStatus;
import com.revature.enums.ERSReimbursementType;
import com.revature.model.ERSReimbursement;
import com.revature.model.ERSUser;
import com.revature.service.ERSReimbursementService;
import com.revature.service.ERSUserService;
import com.revature.view.forms.CommonForms;
import com.revature.view.forms.ReimbForms;

public class ReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 5273949283894859448L;
	private static Logger log = LogManager.getLogger(ReimbServlet.class);
	
	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException {
		  log.warn("Illegal use of GET method for ReimbServlet, will lose data.");
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
		  String url = null;
		  long modify = 0L;
		  
		  if (req instanceof HttpServletRequest) {
			  switch(action) {
			    case "approve":
			    case "deny":	  
				  url = ((HttpServletRequest)req).getRequestURL().toString();
				  String[] ursa = url.split("/");
				  modify = Long.parseLong(ursa[ursa.length-1]);
				  break;
			    default: break;	  
			  }
		  }
		  
		  if (action == null) {
			  log.warn("Value of action button has been lost.");
		  } else {
			  switch(action) {
			  case "approve":
				  ERSReimbursementService.update(modify, uName, ERSReimbursementStatus.APPROVED);
				  out.println(CommonForms.selectReimbForm(uName));
				  break;
			  case "deny":
				  ERSReimbursementService.update(modify, uName, ERSReimbursementStatus.DENIED);
				  out.println(CommonForms.selectReimbForm(uName));
				  break;
			  case "logout":
				  sess.invalidate();
				  res.sendRedirect("ers");
				  break;
			  case "neoReimb":  
				  long rID = ERSReimbursementService.getNextID();
				  double amount = Double.parseDouble(req.getParameter("amount"));
				  LocalDateTime submitted = LocalDateTime.now();
				  String desc = req.getParameter("description");
				  long author = user.getERSUserID();
				  ERSReimbursementStatus rs = ERSReimbursementStatus.PENDING;
				  ERSReimbursementType rt = ERSReimbursementType.parse(req.getParameter("type"));
				  
				  ERSReimbursement reimb = new ERSReimbursement(rID, amount, submitted, null, 
						  desc, author, 0L, rs, rt);
				  ERSReimbursementService.create(reimb);
				  break;
			  case "newReimb":  out.println(ReimbForms.NewReimb(user));
								break;
			  default:  log.warn("Invalid key detected: " + action);
			  }
		  }
	 }

	
}
