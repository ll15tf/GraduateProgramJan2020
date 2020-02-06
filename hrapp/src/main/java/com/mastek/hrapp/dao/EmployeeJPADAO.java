package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Employee;

@Repository 
public interface EmployeeJPADAO extends CrudRepository<Employee, Integer>{ // crudreposu=itory <class, primary key type>

	
	
}
