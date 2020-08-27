package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_status")
public class ReimbursementStatus {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_status")
	private int reimbStatusID;
	
	@Column(name="reimb_status")
	private String reimStatus;
	
	@OneToMany(mappedBy="reimbStatus", fetch=FetchType.EAGER)
	private List<Reimbursement> rList;
	
	
	
	public ReimbursementStatus() {
		super();
	}
	
	
	
	public ReimbursementStatus(int reimbStatusID, String reimStatus, List<Reimbursement> rList) {
		super();
		this.reimbStatusID = reimbStatusID;
		this.reimStatus = reimStatus;
		this.rList = rList;
	}
	



	public ReimbursementStatus(String reimStatus, List<Reimbursement> rList) {
		super();
		this.reimStatus = reimStatus;
		this.rList = rList;
	}



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
	
	
	
	
	

	
	
	
	

}
