package com.revature.models;

public class ReimbursementStatus {
	
	private static final long serialVersionUID = 1L;

	private int reimbStatusID;
	private String reimStatus;
	
	public int getReimbStatusID() {
		return reimbStatusID;
	}
	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}
	public String getReimStatus() {
		return reimStatus;
	}
	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimStatus == null) ? 0 : reimStatus.hashCode());
		result = prime * result + reimbStatusID;
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimStatus == null) {
			if (other.reimStatus != null)
				return false;
		} else if (!reimStatus.equals(other.reimStatus))
			return false;
		if (reimbStatusID != other.reimbStatusID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [reimbStatusID=" + reimbStatusID + ", reimStatus=" + reimStatus + "]";
	}
	
	
	
//	public ReimbursementStatus(int reimbStatusID, String reimStatus) {
//		super();
//		this.reimbStatusID = reimbStatusID;
//		this.reimStatus = reimStatus;
//	}
	
//	public ReimbursementStatus(int reimbStatusID, String reimStatus) {
//		super();
//		this.reimStatus = reimStatus;
//	}
	
//	public ReimbursementStatus(int reimbStatusID, String reimStatus) {
//		super();
//	}
	
	
	
	

}
