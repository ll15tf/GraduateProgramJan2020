package com.mastek.BankApp.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.TransferRequests;

@Repository
public interface TransferRequestJPADAO extends MongoRepository<TransferRequests, Integer> {

}
