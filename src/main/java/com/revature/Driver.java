package com.revature;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.userRole;


public class Driver {
	
	public static UserDAO uDAO = new UserDAO();
	public static UserRoleDAO urDAO = new UserRoleDAO();
	public static ReimbursementDAO rDAO = new ReimbursementDAO();
	
	public static void main(String[] args) {
		insertValues();
		List<Reimbursement> reimbs = rDAO.findAll();
		for (Reimbursement r: reimbs) {
			System.out.println(r);
		}
	}

	private static void insertValues() {
		userRole ur = new userRole("Employee");
		urDAO.addUserRole(ur);
		User u1 = new User("liz", "lemon", "eliz", "site", "liz@sites.com", ur, null, null);
		uDAO.addUser(u1);
	}

	
	
	

}
