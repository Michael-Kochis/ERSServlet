package com.revature.model;

import com.revature.enums.ERSUserRole;

public class ERSUser {
	private long ERSUserID;
	private String ERSUserName;
	private PHash ERSPassword; 
	private String firstName;
	private String lastName;
	private String email;
	private ERSUserRole userRoleID;
	
	public ERSUser() {
		super();
	}

	public ERSUser(long eRSUserID, String eRSUserName, PHash eRSPassword, String firstName, String lastName,
			String email, ERSUserRole userRoleID) {
		super();
		ERSUserID = eRSUserID;
		ERSUserName = eRSUserName;
		ERSPassword = eRSPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleID = userRoleID;
	}

	public long getERSUserID() {
		return ERSUserID;
	}

	public void setERSUserID(long eRSUserID) {
		ERSUserID = eRSUserID;
	}

	public String getERSUserName() {
		return ERSUserName;
	}

	public void setERSUserName(String eRSUserName) {
		ERSUserName = eRSUserName;
	}

	public PHash getERSPassword() {
		return ERSPassword;
	}

	public void setERSPassword(PHash eRSPassword) {
		ERSPassword = eRSPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ERSUserRole getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(ERSUserRole userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ERSPassword == null) ? 0 : ERSPassword.hashCode());
		result = prime * result + (int) (ERSUserID ^ (ERSUserID >>> 32));
		result = prime * result + ((ERSUserName == null) ? 0 : ERSUserName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((userRoleID == null) ? 0 : userRoleID.hashCode());
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
		ERSUser other = (ERSUser) obj;
		if (ERSPassword == null) {
			if (other.ERSPassword != null)
				return false;
		} //else if (!ERSPassword.equals(other.ERSPassword))
			//return false;
		if (ERSUserID != other.ERSUserID)
			return false;
		if (ERSUserName == null) {
			if (other.ERSUserName != null)
				return false;
		} else if (!ERSUserName.equals(other.ERSUserName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (userRoleID != other.userRoleID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERSUser [ERSUserID=" + ERSUserID + ", ERSUserName=" + ERSUserName + ", ERSPassword=" + ERSPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userRoleID="
				+ userRoleID + "]";
	}
}
