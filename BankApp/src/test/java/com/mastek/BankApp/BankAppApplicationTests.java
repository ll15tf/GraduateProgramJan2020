package com.mastek.BankApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.BankApp.DAO.AccountJPADAO;
import com.mastek.BankApp.DAO.CustomerJPADAO;
import com.mastek.BankApp.DAO.LoanJPADAO;
import com.mastek.BankApp.DAO.TransactionJPADAO;
import com.mastek.BankApp.DAO.TransferRequestJPADAO;
import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.CarLoan;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.entities.HomeLoan;
import com.mastek.BankApp.entities.Loan;
import com.mastek.BankApp.entities.Transaction;
import com.mastek.BankApp.entities.TransferRequests;
import com.mastek.BankApp.services.BankAppServices;

@SpringBootTest
class BankAppApplicationTests {

	@Autowired
	CustomerJPADAO cusDAO; 
	
	@Autowired
	AccountJPADAO accDAO; 
	
	@Autowired 
	TransactionJPADAO traDAO; 
	
	@Autowired
	BankAppServices banDAO;
	
	@Autowired
	LoanJPADAO loaDAO;
	
	@Autowired
	TransferRequestJPADAO trDAO; 
	
	
	//@Test
	void testAddCustomer() {
		Customer cus = new Customer(); 
		cus.setName("Example Name");
		cus.setAddress("Example Address");
		
		cus = cusDAO.save(cus);
		
		assertNotNull(cus, "Customer not Null");
		
	}
	
	//@Test
	void testAddAccount() {
		Account acc = new Account(); 
		acc.setBankName("Example Bank");
		acc.setSortCode(000000);
		
		acc = accDAO.save(acc); 
		
		assertNotNull(acc, "Account not Saved");
	}
	
	//@Test
	void testAddTranaction() {
		Transaction tra = new Transaction(); 
		tra.setAmount(120);
		tra.setPaymentType("Example Payment");
		
		tra = traDAO.save(tra); 
		
		assertNotNull(tra, "Transaction not Saved");
	}

	//@Test
	void testAssignCustomerToAccount() {
		
		Customer cus = banDAO.assignCustomertoAccount(4, 6); 		
	}
	
	//@Test 
	void testAssignTransactionToAccount(){
		
		Transaction tra = banDAO.assignTransactionToAccount(5, 6);
	}
	
	//@Test
	void testLoanAdd() {
		
		Loan loa = new Loan(); 
		loa.setLoanAmount(200);
		
		loa = loaDAO.save(loa); 
		
		assertNotNull(loa, "Loan not Added");
		
	}
	
	//@Test
	void testCarLoanAdd() {
		CarLoan car = new CarLoan(); 
		car.setCarLoanId(1);
		car.setCarLoanProvider("Set Loan Provider");
		car.setLoanAmount(400);
		
		car = loaDAO.save(car); 
		
		assertNotNull(car, "Car Loan Not Added");
	}
	
	//@Test
	void testHomeLoanAdd() {
		HomeLoan hom = new HomeLoan(); 
		hom.setHomeLoanId(1);
		hom.setHomeLoanProvider("Set Loan Provider");
		hom.setLoanAmount(200000);
		
		hom = loaDAO.save(hom);
		
		assertNotNull(hom, "Home Loan not Added");
	}
	
	//@Test
	void testTransferRequestDocument() {
		TransferRequests tr = new TransferRequests(); 
		
		tr.setTransferRequestId(10);
		tr.setFromAccount("Example From Account");
		tr.setToAccount("Example to Account");
		tr.setAmount(100);
		tr.setDiscription("Example Discription");
		
		tr = trDAO.save(tr); 
	}
	
	
	//@Test
	void testApplyForTransferRequest() {
		//int trId = 1; 
		//int traId = 2; 
		TransferRequests tr = banDAO.assignTransactionRequestToTransaction(10, 5);
		for (Transaction tra : tr.getTr()) {
			System.out.println(tra);			
		}
	}
}
