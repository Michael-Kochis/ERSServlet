package com.revature.view.comboBox;

import com.revature.enums.ERSReimbursementType;

public class SelectBox {
	public static String ERSTypeBox() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<select name=\"reimbType\" id=\"reimbType\">");
		for (ERSReimbursementType t : ERSReimbursementType.values() ) {
			sb.append("<option value=\"");
			sb.append(ERSReimbursementType.toString(t) );
			sb.append("\">");
			sb.append(ERSReimbursementType.toString(t) );
			sb.append("</option>");
		}
		sb.append("</select>");
		
		return sb.toString();
	}
}
