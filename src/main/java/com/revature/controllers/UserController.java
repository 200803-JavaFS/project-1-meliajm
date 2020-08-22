package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;


public class UserController {
	
	private static ObjectMapper om = new ObjectMapper();


	public void login(HttpServletResponse res) throws IOException {
		
		User u = new User();
		//from html form, no html forms yet
		u.setUsername(req.getParameter("user_id"));
		u.setPassword(req.getParameter("password"));

		
		
	}

}
