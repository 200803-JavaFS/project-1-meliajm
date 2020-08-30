package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.UserController;
import com.revature.controllers.ReimbController;

import com.revature.controllers.LoginController;
import com.revature.models.User;
import com.revature.models.Reimbursement;

public class MasterServlet extends HttpServlet {

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

		// example URI = user/1 to get user with ID 1

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		if(portions.length==0) {
			req.getRequestDispatcher("index.html").forward(req, res);;
		}
		try {
			switch (portions[0]) {
			case "reimbursement":
				System.out.println("req.getSession(false) "+ req.getSession(false));
				System.out.println("req.getSession().getAttribute(log) "+ req.getSession().getAttribute("loggedin"));
//				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					//ADD REIMB WITH SESSIONS RIGHT NOW
				// BECAUSE SESS NOT PERSISTING
				// update DOM
				// THEN SWITCH TO FINANCE MANAGER
				// SEE ALL
				// UPDATE REIMB
				// FILTERT BY STATUS
				// LOGOUT
				// INPUT TWO DECIMALS
				// HASH PASSWORD
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimbursement(res, id);
						} else if (portions.length == 1) {
//							ac.getAllAvengers(res);
							rc.getAllReimbursements(res);
						}
					} else if (req.getMethod().equals("POST")) {
						rc.addReimbursement(req, res);
					}
//				} 
//				else {
//					res.setStatus(403);
//					res.getWriter().println("You must be logged in to do that!");
//				}
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
			res.getWriter().print("The id you provided is not an integer");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}