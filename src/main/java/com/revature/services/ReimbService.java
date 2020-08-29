package com.revature.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IReimbursementDAO;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;



public class ReimbService {
	
	private static final Logger log = LogManager.getLogger(ReimbService.class);
	
	private static IReimbursementDAO rDao = new ReimbursementDAO();
	
	public List<Reimbursement> findAll() {
		log.info("find all");
		return rDao.findAll();
	}
	
	public Reimbursement findById(int id) {
		log.info("find by id");
		return rDao.findByID(id);
	}
	
	public boolean addReimbursement(Reimbursement r) {
		log.info("add reimbursement");
		return rDao.addReimbursement(r);
	}
	
	public boolean updateReimbursement(Reimbursement r) {
		log.info("update reimbursement");
		return rDao.updateReimbursement(r);
	}
	
	public List<Reimbursement> findReimbursementByStatus(int i) {
		log.info("find reimbursement by status");
		return rDao.findReimbursementByStatus(i);
	}

}
