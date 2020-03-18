package com.revature.view.servlet;

import java.io.PrintWriter;

public class CommonForms {
	public static String userNameForm() {
		return "<form method=\"POST\" action=\"/ERSServlet/register\">\r\n" + 
	    		"<input type=\"textarea\" name=\"name\" />" +
	      		"    <button type=\"submit\">Say Hello</button>\r\n" + 
	      		"  </form>\r\n";
	}
}
