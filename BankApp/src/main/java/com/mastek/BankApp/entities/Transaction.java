package com.mastek.BankApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="JPA_TRANSACTIONS")
public class Transaction {

	private int transactionId; 
	private double amount; 
	private String paymentType; 
	///////////////////////////////////////////////////////
	Account linkedAccount; 
	
	@ManyToOne
	@JoinColumn(name="fk_account_id")
	@Transient
	public Account getlinkedAccount() {
		return linkedAccount;
	}

	public void setlinkedAccount(Account linkedAccount) {
		this.linkedAccount = linkedAccount;
	}

	///////////////////////////////////////////////////////
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	@Id 
	@Column(name="transaction_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Transient
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", paymentType=" + paymentType
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
	
	
	
}
