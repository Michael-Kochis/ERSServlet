package com.revature.view.servlet;

public class CommonForms {
	public static String registrationForm() {
		String returnThis = null;
		return returnThis;
	}
	
	public static String landingPage() {
		StringBuilder sb = new StringBuilder();
		sb.append("<title>Welcome to Emerald ERS</title>");
		sb.append("<form action=\"/ERSServlet/mainButton\" method=\"POST\">");
		sb.append("<button type=\"submit\" value=\"login\" name=\"action\">Login</button>");
		sb.append("<button type=\"submit\" value=\"register\" name=\"action\" />Register</button>");
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
