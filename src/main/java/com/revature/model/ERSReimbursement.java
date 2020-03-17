package com.revature.model;

import java.util.Date;

import com.revature.enums.ERSReimbursementStatus;
import com.revature.enums.ERSReimbursementType;

public class ERSReimbursement {
	private long reimbID;
	private double reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescription;
	private long reimbAuthor;
	private long reimbResolver;
	private ERSReimbursementStatus reimbStatus;
	private ERSReimbursementType reimbType;
	
	public ERSReimbursement() {
		super();
	}

	public ERSReimbursement(long reimbID, double reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, long reimbAuthor, long reimbResolver, ERSReimbursementStatus reimbStatus,
			ERSReimbursementType reimbType) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public long getReimbID() {
		return reimbID;
	}

	public void setReimbID(long reimbID) {
		this.reimbID = reimbID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Date reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Date getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Date reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public long getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(long reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public long getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(long reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public ERSReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ERSReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public ERSReimbursementType getReimbType() {
		return reimbType;
	}

	public void setReimbType(ERSReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (reimbAuthor ^ (reimbAuthor >>> 32));
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + (int) (reimbID ^ (reimbID >>> 32));
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + (int) (reimbResolver ^ (reimbResolver >>> 32));
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERSReimbursement other = (ERSReimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor != other.reimbAuthor)
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolver != other.reimbResolver)
			return false;
		if (reimbStatus != other.reimbStatus)
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType != other.reimbType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERSReimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";
	}
}
