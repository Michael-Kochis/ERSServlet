package com.revature.enums;

public enum ERSReimbursementType {
	LODGING, TRAVEL, FOOD, OTHER;
	
	public static ERSReimbursementType longToType(long rt) {
		return intToType(((int) rt) );
	}
	
	public static ERSReimbursementType intToType(int x) {
		switch (x) {
		case 1: return LODGING;
		case 2: return TRAVEL;
		case 3: return FOOD;
		default: return OTHER;
		}
	}
	
	public static long typeToLong(ERSReimbursementType rt) {
		switch (rt) {
		case LODGING: return 1L;
		case TRAVEL: return 2L;
		case FOOD: return 3L;
		default: return 0L;
		}
	}
	
	public static String toString(ERSReimbursementType rt) {
		switch (rt) {
		case LODGING: return "Lodging";
		case TRAVEL: return "Travel";
		case FOOD: return "Food";
		default: return "Other";
		}
	}
}
