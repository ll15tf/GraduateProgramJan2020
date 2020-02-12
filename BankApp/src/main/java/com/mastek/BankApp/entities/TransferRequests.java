package com.mastek.BankApp.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_TRANSFER_REQUESTS")
public class TransferRequests {

	int transferRequestId; 
	String fromAccount; 
	String toAccount; 
	double amount; 
	String discription;
	
	Set<Transaction> tr = new HashSet<>();
	
	public Set<Transaction> getTr() {
		return tr;
	}
	public void setTr(Set<Transaction> tr) {
		this.tr = tr;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transferRequestId;
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
		TransferRequests other = (TransferRequests) obj;
		if (transferRequestId != other.transferRequestId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TransferRequests [transferRequestId=" + transferRequestId + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", discription=" + discription + "]";
	}
	@org.springframework.data.annotation.Id
	public int getTransferRequestId() {
		return transferRequestId;
	}
	public void setTransferRequestId(int transferRequestId) {
		this.transferRequestId = transferRequestId;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	} 
	
	
	
}
