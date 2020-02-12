package com.mastek.BankApp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.Customer;

@Repository
public interface CustomerJPADAO extends CrudRepository<Customer, Integer> {

}
