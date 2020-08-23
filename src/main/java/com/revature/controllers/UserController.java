package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		System.out.println("your reimb for this user");
		RequestDispatcher rd = null;

		rd = req.getRequestDispatcher("employeeSuccess.html");

		
	}

}
