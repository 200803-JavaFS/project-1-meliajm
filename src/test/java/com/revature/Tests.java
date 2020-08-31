package com.revature;

import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.ReimbService;

public class Tests {
	
	
	public static LoginService ls;
	public static ReimbService rs;
	public static UserDAO uDAO;
	public static ReimbursementDAO rDAO;
	
	@BeforeClass
	public static void set() {
		System.out.println("In BeforeClass");
		ls = new LoginService();
		rs = new ReimbService();
		uDAO = new UserDAO();
		rDAO = new ReimbursementDAO();

	}
	
	@Before
	public void setFields() {
		System.out.println("In Before");
		Reimbursement r = null;
	}
	
	@After
	public void clearResult() {
	}
	
	@AfterClass
	public static void clear() {
		ls = null;
		rs = null;
		uDAO = null;
	}
	
//	@Test
//	public void testLogin() {
//		
//	}
	
//	@Test
//	public void testfindAllReimb() {
//		List<Reimbursement> reimbs = rDAO.findAll();
//		int lengthReimbs = 9;
//		int l = reimbs.size();
//		assertTrue(l==lengthReimbs);
//	}
	
//	@Test
//	public void testUpdateReimb() {
//		User u= uDAO.findByUsername("captain");
//		Reimbursement r2 = rDAO.findByID(6);		
//
//		Reimbursement r = rDAO.findByID(5);
//		r.setReimbResolver(u);
//		r.setReimbStatus(r2.getReimbStatus());
//		r.setTimeResolved(LocalTime.now());
//		r.setReimbDescription("test");
//		assertTrue(rDAO.updateReimbursement(r));
//	}
	
//	@Test
//	public void testSubmitReimb() {
//		System.out.println("testing submit reimb");
//		User tia= uDAO.findByUsername("tiaclair1");
//		ReimbursementStatus rs = new ReimbursementStatus("Pending");
//		ReimbursementType rt = new ReimbursementType("Other");
//		Reimbursement r = new Reimbursement(999.22, LocalTime.now(), null, "test", tia, null, rs, rt);
//		assertTrue(rDAO.addReimbursement(r));
//	}
	

}
