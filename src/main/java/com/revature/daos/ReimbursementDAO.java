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

public class ReimbursementDAO implements IReimbursementDAO {

	@Override
	public List<Reimbursement> findAll() {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM reimbursement;";
			Statement statement = conn.createStatement();
			List<Reimbursement> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(result.getInt("reimb_id")); 
				r.setReimbAmount(result.getDouble("reimb_amount"));
				r.setReimbSubmitted(result.getString("reimb_submitted"));
				r.setReimbResolved(result.getString("reimb_resolved"));
				r.setReimbDescription(result.getString("reimb_description"));
				r.setReimbAuthor(result.getInt("reimb_author"));
				r.setReimbResolver(result.getInt("reimb_resolver"));
				r.setReimbStatusID(result.getInt("reimb_status_id"));
				r.setReimbTypeID(result.getInt("reimb_type_id"));
				list.add(r);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Reimbursement findByID(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE reimb_id ="+id+";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(result.getInt("reimb_id")); 
				r.setReimbAmount(result.getDouble("reimb_amount"));
				r.setReimbSubmitted(result.getString("reimb_submitted"));
				r.setReimbResolved(result.getString("reimb_resolved"));
				r.setReimbDescription(result.getString("reimb_description"));
				r.setReimbAuthor(result.getInt("reimb_author"));
				r.setReimbResolver(result.getInt("reimb_resolver"));
				r.setReimbStatusID(result.getInt("reimb_status_id"));
				r.setReimbTypeID(result.getInt("reimb_type_id"));
				return r;
			} else {
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimbursement(Reimbursement r) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ? ,?);";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, r.getReimbAmount());
			statement.setString(++index, r.getReimbSubmitted());
			statement.setString(++index, r.getReimbResolved());
			statement.setString(++index, r.getReimbDescription());
			statement.setInt(++index, r.getReimbAuthor());
			statement.setInt(++index, r.getReimbResolver());
			statement.setInt(++index, r.getReimbStatusID());
			statement.setInt(++index, r.getReimbTypeID());


			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimbursement(Reimbursement r) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE reimbursement SET reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?, reimb_description = ?, reimb_author = ?, reimb_resolver =?, reimb_status_id = ?, reimb_type_id =?, WHERE reimb_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setDouble(++index, r.getReimbAmount());
			statement.setString(++index, r.getReimbSubmitted());
			statement.setString(++index, r.getReimbResolved());
			statement.setString(++index, r.getReimbDescription());
			statement.setInt(++index, r.getReimbAuthor());
			statement.setInt(++index, r.getReimbResolver());
			statement.setInt(++index, r.getReimbStatusID());
			statement.setInt(++index, r.getReimbTypeID());
			
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimbursement> findReimbursementByStatus(String status) {
		try(Connection conn = ConnectionUtility.getConnection()) {
			String sql = "select * from reimbursement r join reimbursement_status rs on r.reimb_status_id = rs.reimb_status_id where reimb_status = ?;";			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, status);
			List<Reimbursement> list = new ArrayList<>();
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbID(result.getInt("reimb_id")); 
				r.setReimbAmount(result.getDouble("reimb_amount"));
				r.setReimbSubmitted(result.getString("reimb_submitted"));
				r.setReimbResolved(result.getString("reimb_resolved"));
				r.setReimbDescription(result.getString("reimb_description"));
				r.setReimbAuthor(result.getInt("reimb_author"));
				r.setReimbResolver(result.getInt("reimb_resolver"));
				r.setReimbStatusID(result.getInt("reimb_status_id"));
				r.setReimbTypeID(result.getInt("reimb_type_id"));
				list.add(r);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}




}
