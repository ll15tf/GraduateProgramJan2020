package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component
public class EmployeeListener {

	@PrePersist // means call this method before inserting each emp object in the employee table
	public void beforeEmpInsert(Employee e) {
		System.out.println("Before Employee Insert");
		System.out.println("Raise Email Request for "+e.getName());
	}
	
	@PostPersist
	public void afterEmpInsert(Employee e) {
		System.out.println("After Employee Insert");
		System.out.println("Screen Name Generated: "+ e.getName()+e.getEmpno());
	}
	
	@PreUpdate
	public void beforeUpdate(Employee e) {
		System.out.println("Before Update "+ e);
	}
	
	@PostUpdate
	public void afterUpdate(Employee e) {
		System.out.println("After Update "+e);
	}
	
	@PostLoad
	public void afterLoading(Employee e ) {
		System.out.println("Employee Fetched "+e);
	}
	
	@PreRemove
	public void beforeDelete(Employee e) {
		System.out.println("Before Removing "+e);
		System.out.println("Disable profile for "+e.getEmpno());
	}
	
}
