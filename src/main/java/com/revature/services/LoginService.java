package com.revature.services;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	
	private static UserService us = new UserService();
	
	public boolean login(LoginDTO l) {
		User u = us.findByUsername(l.username);
		if (l.username.equals(u.getUsername()) && l.password.equals(u.getPassword())) {
			return true;
		}
		return false;
	}

}
