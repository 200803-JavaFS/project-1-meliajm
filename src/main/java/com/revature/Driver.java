package com.revature;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.userRole;


public class Driver {
	
	public static UserDAO uDAO = new UserDAO();
	public static UserRoleDAO urDAO = new UserRoleDAO();
	public static ReimbursementDAO rDAO = new ReimbursementDAO();
	
	
	public static void main(String[] args) {
		insertValues();
		List<User> users = uDAO.findAll();
		userRole uRole = users.get(1).getUserRole();
		System.out.println("user role: "+ uRole);
		
//		List<Reimbursement> reimbs = rDAO.findReimbursementsByUser(users.get(3));
//		
//		for (Reimbursement r: reimbs) {
//			System.out.println(r);
//		}
		
	}

	private static void insertValues() {

//		userRole ur2 = urDAO.findByID(2);
//		User u1 = new User("barty", "pass", "bart", "simpson", "bsimpo.com", ur2, null, null);
//		uDAO.addUser(u1);
//		User tia= uDAO.findByUsername("tiaclair1");
		User bart= uDAO.findByID(4);
//		User bart= uDAO.findByUsername("barty");

		System.out.println("bart: "+ bart);
		List<User> users = uDAO.findAll();
		for (User u: users) {
			System.out.println(u);
		}
		ReimbursementStatus rStatus = rDAO.findReimbursementsByUser(users.get(3)).get(0).getReimbStatus();
		System.out.println("bart "+users.get(3));
//		System.out.println("bart "+users.get(3));
		List<Reimbursement> l = rDAO.findReimbursementsByUser(users.get(3));
//		for (Reimbursement li: l) {
//			System.out.println(li);
//		}
			
//		System.out.println(l);
//				.get(0).getReimbStatus();

//		System.out.println("stat: "+rStatus);
		ReimbursementType rType = rDAO.findReimbursementsByUser(users.get(3)).get(0).getReimbType();
//		
		Reimbursement r = new Reimbursement(2020.20, "15:35:23", null, "good vision", bart, null, rStatus, rType);
		rDAO.addReimbursement(r);
	}
}
