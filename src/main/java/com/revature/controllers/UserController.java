package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;


public class UserController {
	
	private static ObjectMapper om = new ObjectMapper();
	private static UserService us = new UserService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		User u = us.findByUsername(req.getParameter("username"));
//		u.setUsername(req.getParameter("userId"));
//		u.setPassword(req.getParameter("password"));
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			rd = req.getRequestDispatcher("success");
			rd.forward(req, res);
		} else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
			out.print("<span style='color:red; text-align:center'>Invalid Username/Password</span>");
		}

		
		
	}

}
