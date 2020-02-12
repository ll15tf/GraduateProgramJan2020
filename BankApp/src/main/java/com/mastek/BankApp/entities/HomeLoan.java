package com.mastek.BankApp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_HOME_LOAN_JOINED")
public class HomeLoan extends Loan{

	int homeLoanId; 
	String homeLoanProvider;
	
	public HomeLoan() {
		// TODO Auto-generated constructor stub
	}

	public int getHomeLoanId() {
		return homeLoanId;
	}

	public void setHomeLoanId(int homeLoanId) {
		this.homeLoanId = homeLoanId;
	}

	public String getHomeLoanProvider() {
		return homeLoanProvider;
	}

	public void setHomeLoanProvider(String homeLoanProvider) {
		this.homeLoanProvider = homeLoanProvider;
	}

	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", homeLoanProvider=" + homeLoanProvider + ", loanId=" + loanId
				+ ", loanAmount=" + loanAmount + "]";
	}
	
	
}
