package com.revature.models;

public class Reimbursement {
	
	private static final long serialVersionUID = 1L;
	
	private int reimbID;
	private double reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatusID;
	private int reimbTypeID;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbID, double reimbAmount, String reimbSubmitted, String reimResolved,
			String reimDescription, int reimbAuthor, int reimbResolver, int reimbStatusID, int reimbTypeID) {
		super();
		this.reimbID = reimbID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimResolved;
		this.reimbDescription = reimDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
	}
	
	public Reimbursement(double reimbAmount, String reimbSubmitted, String reimResolved,
			String reimDescription, int reimbAuthor, int reimbResolver, int reimbStatusID, int reimbTypeID) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimResolved;
		this.reimbDescription = reimDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimResolved) {
		this.reimbResolved = reimResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimDescription) {
		this.reimbDescription = reimDescription;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatusID() {
		return reimbStatusID;
	}

	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}

	public int getReimbTypeID() {
		return reimbTypeID;
	}

	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbAuthor;
		result = prime * result + ((reimbDescription == null) ? 0 : reimbDescription.hashCode());
		result = prime * result + reimbID;
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + reimbResolver;
		result = prime * result + reimbStatusID;
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
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
		if (reimbStatusID != other.reimbStatusID)
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbTypeID != other.reimbTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusID="
				+ reimbStatusID + ", reimbTypeID=" + reimbTypeID + "]";
	}

	

	

	
	
	
	

}
