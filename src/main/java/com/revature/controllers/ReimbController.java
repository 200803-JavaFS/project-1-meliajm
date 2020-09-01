package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbService;
import com.revature.services.UserService;

public class ReimbController {
	
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();

	private static UserService us = new UserService();

	public void getReimbursement(HttpServletResponse res, int id) throws IOException {
		Reimbursement r = rs.findById(id);
		System.out.println("in rc get reimb, r: "+r);
		if (r==null) {
			res.setStatus(204);
		} else {
			System.out.println("in get reimb rc");
			res.setStatus(200);
			String json = om.writeValueAsString(r);
			//issue is here
			System.out.println("in rc get reimb, json: "+json);
			res.getWriter().println(json);
		}
	}
	
	public void getAllReimbursements(HttpServletResponse res) throws IOException {
		List<Reimbursement> all = rs.findAll();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
	}
	
	
//	public void findUserReimbursements(HttpServletResponse res) throws IOException {
//		List<Reimbursement> all = us.findUserReimbursements(res.getParameter("username"));
//		res.getWriter().println(om.writeValueAsString(all));
//	}
	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		// i think is where find by user and associations need to happen
		
		System.out.println("body: "+ body);
//		body = {"reimbAmount":"100.05","timeSubmitted":"23:45:33","timeResolved":"03:45:33","reimbDescription":"this is for demos","reimbAuthor":"tiaclair1","reimbResolver":"captain","reimbStatus":"Pending","reimbType":"Food"};

//		body: {"amount":"100.05","timeSubmitted":"23:45:33","timeResolved":"03:45:33","descr":"this is for demos","author":"tiaclair1","resolver":"captain","status":"Pending","type":"Food"}

		Reimbursement r = om.readValue(body, Reimbursement.class);
		System.out.println("r: "+ r);
		
		if (rs.addReimbursement(r)) {
			res.setStatus(201);
			res.getWriter().println("Reimb was created");
		} else {
			res.setStatus(403);
		}
	}

}
