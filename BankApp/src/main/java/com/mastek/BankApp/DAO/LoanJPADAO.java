package com.mastek.BankApp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.Loan;

@Repository
public interface LoanJPADAO extends CrudRepository<Loan, Integer>{

}
