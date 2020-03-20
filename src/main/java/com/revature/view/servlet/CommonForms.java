package com.revature.view.servlet;

public class CommonForms {
	public static String landingPage() {
		StringBuilder sb = new StringBuilder();
		sb.append("<title>Welcome to Emerald ERS</title>");
		sb.append("<form action=\"/ERSServlet/mainButton\" method=\"POST\">");
		sb.append("<button type=\"submit\" value=\"login\" name=\"action\">Login</button>");
		sb.append("<button type=\"submit\" value=\"register\" name=\"action\" />Register</button>");
		sb.append("</form>\r\n");
		
		return sb.toString();
	}
	
	public static String loginForm() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<title>Welcome to Emerald ERS</title>");
		sb.append("<form action=\"/ERSServlet/login\" method=\"POST\">");
		sb.append("<label>Username</label>");
		sb.append("<input type=\"textarea\" name=\"username\" /><br>");
		sb.append("\n\r<label>Password</label>");
		sb.append("<input type=\"password\" name=\"password\" /><br>");
		sb.append("\n\r<button type=\"submit\" value=\"login\" name=\"action\" />Login</button>");
		sb.append("</form>\r\n");
		
		return sb.toString();
	}
	
	public static String registrationForm() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<title>Welcome to Emerald ERS</title>");
		sb.append("<form action=\"/ERSServlet/register\" method=\"POST\">");
		sb.append("<label>Username</label>");
		sb.append("<input type=\"textarea\" name=\"username\" /><br>");
		sb.append("\n\r<label>Password</label>");
		sb.append("<input type=\"password\" name=\"password\" /><br>");
		sb.append("\n\r<label>Confirm Password</label>");
		sb.append("<input type=\"password\" name=\"confirm\" /><br>");
		sb.append("\n\r<label>First Name</label>");
		sb.append("<input type=\"text\" name=\"firstName\" /><br>");
		sb.append("\n\r<label>Last Name</label>");
		sb.append("<input type=\"text\" name=\"lastName\" /><br>");
		sb.append("\n\r<label>Email</label>");
		sb.append("<input type=\"text\" name=\"email\" /><br>");
		sb.append("\n\r<button type=\"submit\" value=\"register\" name=\"action\" />Register</button>");
		sb.append("</form>\r\n");
		
		return sb.toString();
	}
	
	public static String userNameForm() {
		return "<form method=\"POST\" action=\"/ERSServlet/register\">\r\n" + 
	    		"<input type=\"textarea\" name=\"name\" />" +
	      		"    <button type=\"submit\">Say Hello</button>\r\n" + 
	      		"  </form>\r\n";
	}
}
