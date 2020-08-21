package com.revature.models;

public class ReimbursementType {
	
	private static final long serialVersionUID = 1L;
	
	private int reimbTypeID;
	private String reimbType;
	
	
	public int getReimbTypeID() {
		return reimbTypeID;
	}
	
	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	
	public String getReimbType() {
		return reimbType;
	}
	
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeID;
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
		ReimbursementType other = (ReimbursementType) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeID != other.reimbTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbTypeID=" + reimbTypeID + ", reimbType=" + reimbType + "]";
	}
	
//	public ReimbursementType(int reimbTypeID, String reimbType) {
//		super();
//		this.reimbTypeID = reimbTypeID;
//		this.reimbType = reimbType;
//	}
	
//	public ReimbursementType(String reimbType) {
//		super();
//		this.reimbType = reimbType;
//	}
	
//	public ReimbursementType(String reimbType) {
//		super();
//	}

}
