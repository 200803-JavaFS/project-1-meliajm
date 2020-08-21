package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {
	
	@Override
	public List<User> findAll() {
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
	}
	
	@Override
	public User findByID(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE user_id ="+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
				u.setEmail(result.getString("email"));
				u.setUserRole(result.getInt("user_role_id"));
				return u;
			} else {
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public User findByUsername(String username) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users WHERE username = ?;";			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				User u = new User();
				u.setUserID(result.getInt("user_id")); 
				u.setUsername(result.getString("username"));
				u.setPassword(result.getString("user_password"));
				u.setFirstName(result.getString("first_name"));
				u.setLastName(result.getString("last_name"));
				u.setEmail(result.getString("email"));
				u.setUserRole(result.getInt("user_role_id"));
				return u;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean addUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO users (username, user_password, first_name, last_name, email, user_role_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getUserRole());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE users SET username = ?, user_password = ?, first_name = ?, last_name = ?, email = ?, user_role_id =?, WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getUserRole());
			statement.setInt(++index, u.getUserID());

			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Reimbursement> findUserReimbursements(User u) {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE reimb_author ="+u.getUserID()+";";
			Statement statement = conn.createStatement();
			List<Reimbursement> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Reimbursement r = new Reimbursement(
						result.getInt("reimb_id"),
						result.getDouble("reimb_amount"),
						result.getString("reimb_submitted"),
						result.getString("reimb_resolved"),
						result.getString("reimb_description"),
						result.getInt("reimb_author"),
						result.getInt("reimb_resolver"),
						result.getInt("reimb_status_id"),
						result.getInt("reimb_type_id")
						);
				list.add(r);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
