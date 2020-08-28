package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();
	
	public User findByID(int id);
	
	public User findByUsername(String username);
	
	public void addUser(User u);
	
	public void updateUser(User u);
	
//	public void findByUserRole(User u);

//	public List<Reimbursement> findUserReimbursements(User u);
	
}
