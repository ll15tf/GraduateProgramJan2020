package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Project;

@Repository
public interface ProjectDAO extends CrudRepository<Project, Integer> {

	
}
