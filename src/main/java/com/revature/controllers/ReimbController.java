package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbService;

public class ReimbController {
	
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void reimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("submitted your reimbursement");
	}
	
	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println("body: "+ body);
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
