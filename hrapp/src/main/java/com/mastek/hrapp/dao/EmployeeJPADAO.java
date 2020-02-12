package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

@Repository 
public interface EmployeeJPADAO extends CrudRepository<Employee, Integer>{// crudreposu=itory <class, primary key type>

	Iterable<Employee> findbySalary(@Param("minSalary") double minSalary, @Param("maxSalary")double maxSalary); 
	
	Iterable<Employee> findbyDesignation(@Param("designation") Designation designation);

	
	
}
