package com.mastek.BankApp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.BankApp.DAO.AccountJPADAO;
import com.mastek.BankApp.DAO.CustomerJPADAO;
import com.mastek.BankApp.DAO.TransactionJPADAO;
import com.mastek.BankApp.DAO.TransferRequestJPADAO;
import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.entities.Transaction;
import com.mastek.BankApp.entities.TransferRequests;

@Component
@Scope("singleton")
public class BankAppServices {

	@Autowired
	AccountJPADAO accDAO;

	@Autowired
	CustomerJPADAO cusDAO;

	@Autowired
	TransactionJPADAO traDAO;
	
	@Autowired 
	TransferRequestJPADAO trDAO;
	
	@Transactional
	public TransferRequests assignTransactionRequestToTransaction(int transferRequestId, int transactionId) {
		TransferRequests tr = trDAO.findById(transferRequestId).get();
		Transaction tra =traDAO.findById(transactionId).get();
		
		tr.getTr().add(tra);
		tr = trDAO.save(tr);
		
		return tr; 		
	}
	

	@Transactional
	public Transaction assignTransactionToAccount(int traId, int accId) {
		Transaction tra = traDAO.findById(traId).get();
		Account acc = accDAO.findById(accId).get();

		tra.setlinkedAccount(acc);
		acc.getTransactionHistory().add(tra);

		traDAO.save(tra);
		accDAO.save(acc);

		return tra;
	}

	@Transactional
	public Customer assignCustomertoAccount(int cusId, int accId) {
		Customer cus = cusDAO.findById(cusId).get();
		Account acc = accDAO.findById(accId).get();

		cus.getAccountAssigned().add(acc);
		cusDAO.save(cus);
		accDAO.save(acc);

		return cus;
	}

	public BankAppServices() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initializeService() {
		System.out.println("Service Inititalised");
	}

	@PreDestroy
	public void terminateService() {
		System.out.println("Service Terminated");
	}

}
