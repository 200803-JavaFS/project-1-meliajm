package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class userRole {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_role_id")
	private int UserRoleID;
	
	@Column(name="user_role")
	private String UserRole;
	
	public int getUserRoleID() {
		return UserRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		UserRoleID = userRoleID;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public userRole() {
		super();
	}
	
	public userRole(int userRoleID, String userRole) {
		super();
		UserRoleID = userRoleID;
		UserRole = userRole;
	}
	public userRole(String userRole) {
		super();
		UserRole = userRole;
	}
	
}
