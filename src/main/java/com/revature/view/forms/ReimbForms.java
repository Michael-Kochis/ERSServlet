package com.revature.view.forms;

import java.util.TreeSet;

import com.revature.enums.ERSReimbursementType;
import com.revature.model.ERSReimbursement;
import com.revature.model.ERSUser;
import com.revature.service.ERSReimbursementService;
import com.revature.view.comboBox.SelectBox;

public class ReimbForms {
	
	public static String reimbReceiptForm(long ID) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<form action=\"/ERSServlet/receipt");
		//sb.append("/" + ID + "");
		sb.append("\" method=\"POST\"");
		sb.append("enctype=\"multipart/form-data\"");
		sb.append(">");
		sb.append("\n\r<input type=\"file\" name=\"receipt\">\n\r<br>");
		sb.append("<button type=\"submit\" value=\"upload\" name=\"action\" />");
		sb.append("Upload</button>");
		sb.append("\n\r</form>\n\r");
		
		return sb.toString();
	}

	public static String reimbsByName(String name) {
		StringBuilder sb = new StringBuilder();
		
		TreeSet<ERSReimbursement> set = ERSReimbursementService.getReimbursementsByAuthorName(name);
		
		if (set != null) {
			for (ERSReimbursement reimb : set) {
				sb.append(reimb.getReimbID());
				sb.append(" " + ERSReimbursementType.toString(reimb.getReimbType()) );
				sb.append(" " + reimb.getReimbAmount());
				sb.append(" "+ reimb.getReimbSubmitted());
				sb.append(" " + reimb.getReimbStatus());
				sb.append("<br>" + reimb.getReimbDescription());
				
				sb.append(reimbReceiptForm(reimb.getReimbID()) );
				sb.append("\n\r");
			}
		}
		
		return sb.toString();
	}

	public static String NewReimb(ERSUser user) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<title>Welcome to Emerald ERS</title>");
		sb.append("<form action=\"/ERSServlet/reimbButton\" method=\"POST\">");
		sb.append("<label>" + user.getERSUserName() + "</label><br>");
		sb.append(SelectBox.ERSTypeBox() );
		sb.append("<br><label>Description</label><br>");
		sb.append("<input type=\"textarea\" name=\"description\" /><br>");
		sb.append("<label>Amount</label><br>");
		sb.append("<input type=\"textarea\" name=\"amount\" /><br>");
		sb.append("<br><button type=\"submit\" value=\"neoReimb\" name=\"action\" />Submit</button>");
		sb.append("</form>");
		
		return sb.toString();
	}

}
