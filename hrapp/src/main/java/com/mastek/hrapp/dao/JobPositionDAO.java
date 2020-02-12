package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPosition;

@Repository
public interface JobPositionDAO extends MongoRepository<JobPosition, Integer> {
	
	

}
