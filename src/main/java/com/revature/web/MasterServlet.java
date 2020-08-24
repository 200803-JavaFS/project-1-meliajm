package com.revature.web;

import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbController;
import com.revature.controllers.UserController;

public class MasterServlet extends HttpServlet {
	
	private static UserController uc = new UserController();	
	private static ReimbController rc = new ReimbController();
	private static LoginController lc = new LoginController();

	
	public MasterServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project1/", "");
		
		String[] portions = URI.split("/");
		
		// better to log
		System.out.println(Arrays.toString(portions));
		try {
			switch(portions[0]) {
				case "user":
					if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
						if (req.getMethod().equals("GET")) {
							if (portions.length == 2) {
								int id = Integer.parseInt(portions[1]);
								 uc.getUser(res, id);
							} else if (portions.length==1) {
//								rc.getAllReimbursements(res);
							} 
						} else if (req.getMethod().equals("POST")) {
							rc.addReimbursement(req, res);
						}
						
						
					} else  {
						res.setStatus(403);
						res.getWriter().println("you must be logged in to view.");
					}
					break;
				case "login":
					lc.login(req, res);
					break;
				case "logout":
					lc.logout(req, res);
					break;
					
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("the id you provided is not an integer");
			res.setStatus(400);
			}
		}
	
	
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}




}
