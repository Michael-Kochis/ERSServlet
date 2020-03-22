package com.revature.view.forms;

import com.revature.service.ERSUserService;

public class CommonForms {
	public static String commonHeaders() {
		StringBuilder sb = new StringBuilder();
		sb.append("<title>Welcome to Emerald ERS</title>");
	    sb.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
	    sb.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>");
	    sb.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");

	    return sb.toString();
	}
	public static String landingPage() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommonForms.commonHeaders());
		sb.append("<form action=\"/ERSServlet/mainButton\" method=\"POST\">");
		sb.append("<button type=\"submit\" value=\"login\" name=\"action\" class=\"btn btn-primary\">Login</button>");
		sb.append("<button type=\"submit\" value=\"register\" name=\"action\" class=\"btn btn-primary\" />Register</button>");
		sb.append("</form>");
		
		return sb.toString();
	}
	
	public static String loginForm() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(CommonForms.commonHeaders());
		sb.append("<form action=\"/ERSServlet/login\" method=\"POST\">");
		sb.append("<label class=\"font-weight-bold\">Username</label>");
		sb.append("<input type=\"textarea\" name=\"username\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">Password</label>");
		sb.append("<input type=\"password\" name=\"password\" /><br>");
		sb.append("\n\r<button type=\"submit\" value=\"login\" name=\"action\" class=\"btn btn-primary\" />Login</button>");
		sb.append("</form>\r\n");
		
		return sb.toString();
	}
	
	public static String registrationForm() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(CommonForms.commonHeaders());
		sb.append("<form action=\"/ERSServlet/register\" method=\"POST\">");
		sb.append("<label class=\"font-weight-bold\">Username</label>");
		sb.append("<input type=\"textarea\" name=\"username\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">Password</label>");
		sb.append("<input type=\"password\" name=\"password\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">Confirm Password</label>");
		sb.append("<input type=\"password\" name=\"confirm\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">First Name</label>");
		sb.append("<input type=\"text\" name=\"firstName\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">Last Name</label>");
		sb.append("<input type=\"text\" name=\"lastName\" /><br>");
		sb.append("\n\r<label class=\"font-weight-bold\">Email</label>");
		sb.append("<input type=\"text\" name=\"email\" /><br>");
		sb.append("\n\r<button type=\"submit\" value=\"register\" name=\"action\" class=\"btn btn-success\" />Register</button>");
		sb.append("<button type=\"submit\" value=\"login\" name=\"action\" class=\"btn btn-primary\">Login Instead</button>");
		sb.append("</form>\r\n");
		
		return sb.toString();
	}
	
	public static String reimbAdminForm() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(CommonForms.commonHeaders());
		sb.append(ReimbForms.allPendingReimbs() );
		sb.append("<form action=\"/ERSServlet/reimbButton\" method=\"POST\">");
		sb.append("\n\r<button type=\"submit\" value=\"newTicket\" name=\"action\" class=\"btn btn-primary\" />New Ticket</button>");
		sb.append("\n\r<button type=\"submit\" value=\"logout\" name=\"action\" class=\"btn btn-secondary\" />Logout</button>");
		sb.append("</form>");
		
		return sb.toString();
	}
	
	public static String reimbUserForm(String name) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(CommonForms.commonHeaders());
		sb.append(ReimbForms.reimbsByName(name) );
		sb.append("<form action=\"/ERSServlet/reimbButton\" method=\"POST\">");
		sb.append("\n\r<button type=\"submit\" value=\"newReimb\" name=\"action\" class=\"btn btn-success\"/>New Reimbursement</button>");
		sb.append("\n\r<button type=\"submit\" value=\"logout\" name=\"action\" class=\"btn btn-primary\" />Logout</button>");
		sb.append("</form>");
		
		return sb.toString();
	}
			
	public static String selectReimbForm(String name) {
		if (ERSUserService.isAdminByName(name)) {
			return reimbAdminForm();
		} else {
			return reimbUserForm(name);
		}
	}

	public static String userNameForm() {
		return "<form method=\"POST\" action=\"/ERSServlet/register\">\r\n" + 
	    		"<input type=\"textarea\" name=\"name\" />" +
	      		"    <button type=\"submit\" class=\"btn btn-secondary\" >Say Hello</button>\r\n" + 
	      		"  </form>\r\n";
	}

}
