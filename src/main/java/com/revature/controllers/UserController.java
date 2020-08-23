package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.userRole;
import com.revature.services.UserRoleService;
import com.revature.services.UserService;

public class UserController {
	
	private static ObjectMapper om = new ObjectMapper();
	private static UserService us = new UserService();
	private static UserRoleService urs = new UserRoleService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		User u = us.findByUsername(req.getParameter("username"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			userRole ur = urs.findByID(u.getUserID());
			System.out.println("ur.getUserRole().equals?: " + ur.getUserRole().equals("Employee"));
			if (ur.getUserRole().equals("Employee")) {				
				rd = req.getRequestDispatcher("employeeSuccess");
				rd.forward(req, res);
			} else if (ur.getUserRole().equals("FinanceM")) {
				rd = req.getRequestDispatcher("financeMSuccess");
				rd.forward(req, res);
				
			}
		} else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
		}
	}
	
	public void employeeSuccess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Print out reimbursements of users
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		System.out.println("your reimb for this user");
		System.out.println("req: "+ req);
		System.out.println("reqs: "+ res);

		RequestDispatcher rd = null;
		// i want to use employeeSuccess.html but for now it's print outs
		//rd = req.getRequestDispatcher("employeeSuccess.html");
		out.print("<h1>Welcome, "+ req.getParameter("username")+ "!</h1>");
		// find reimbs from user
		// this an extra step needing to hit database again, not best practice, where can i pass in user so i
		// do not need to do that
		// this should go to employee success not login i believe
		User u = us.findByUsername(req.getParameter("username"));
		List<Reimbursement> listReimb = us.findUserReimbursements(u);
		out.print("<h3>Here are your reimbursements</h3>");
		int len = listReimb.size();
		for (int i=0; i<len; i++) {	
			out.print("");
			out.print(listReimb.get(i));
		}

		
		

		System.out.println("your reimb for this user here? in employeeSuccess in user controller");

		
	}

}
