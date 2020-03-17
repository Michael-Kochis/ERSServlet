package com.revature.enums;

public enum ERSReimbursementStatus {
    DENIED, PENDING, APPROVED;
	
	public static long typeToLong(ERSReimbursementStatus rs) {
		switch (rs) {
		case DENIED: return 0;
		case APPROVED: return 2;
		default: return 1;
		}
	}
	
	public static ERSReimbursementStatus longToType(long rs) {
		return intToType((int) rs);
	}
	
	public static ERSReimbursementStatus intToType(int x) {
		switch(x) {
		case (0): return DENIED;
		case (2): return APPROVED;
		default: return PENDING;
		}
	}
	
	public static String toString(ERSReimbursementStatus rs) {
		int x = ((int) typeToLong(rs));
		switch (x) {
		case (0): return "Denied";
		case (2): return "Approved";
		default: return "Pending";
		}
	}
}
