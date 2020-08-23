package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.UserController;

public class LoginServlet  extends HttpServlet {
	
	private static UserController uc = new UserController();
	
	
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project1/", "");
		
		String[] portions = URI.split("/");
		
		// better to log
		System.out.println(Arrays.toString(portions));
		System.out.println("portions[0]: "+  portions[0]);
		System.out.println("portions[0] equal: "+  portions[0].equals("login"));
		try {
			switch(portions[0]) {
//				case "index":
//					RequestDispatcher rd = null;
//					rd = req.getRequestDispatcher("index.html");

				case "login":
					System.out.println("req: "+ req);

					System.out.println("req.get: "+ req.getMethod());
					if (req.getMethod().equals("POST")) {
						System.out.println("in if");
						
						uc.login(req, res);
					}
//				case "employeeSuccess": 
//					// check what type of user they are 
//					// this is for employee
//					if (req.getMethod().equals("POST")) {
//						uc.employeeSuccess(req, res);
//					}
//				case "reimb":
//					if (req.getMethod().equals("GET")) {
//						if (portions.length == 2) {
//							int id = Integer.parseInt(portions[1]);
//							 rc.getReimb(res, id);
//							
//						} else if (portions.length==1) {
//							rc.getAllAvengers(res);
//						} 
//					} else if (req.getMethod().equals("POST")) {
//						
//						ac.addReimb(req, res);
//						
//						
//					}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("the id you provided is not an integer");
			res.setStatus(400);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}


}
