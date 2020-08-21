package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class Reimbursement implements IReimbursementDAO {

	@Override
	public List<com.revature.models.Reimbursement> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users;";
			Statement statement = conn.createStatement();
			List<User> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
				u.setEmail(result.getString("email"));
				u.setUserRole(result.getInt("user_role_id"));
				list.add(u);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
		return null;
	}

	@Override
	public com.revature.models.Reimbursement findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addReimbursement(com.revature.models.Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReimbursement(com.revature.models.Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<com.revature.models.Reimbursement> findReimbursementByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
