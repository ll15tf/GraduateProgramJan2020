package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity // Declares class as entity which will be managed by JPA
@Table(name="JPA_Employees")
@EntityListeners({EmployeeListener.class}) // call the appropriate listener event method on the lifecycle
public class Employee {
	int empno;
	String name; 
	double salary;
	Designation Designation;

	/////////////////////////////////////////////////////////////////////////////
	
	Department currentDepartment;
	
	@ManyToOne // one employee is associated with one of the many departments 
	@JoinColumn(name="fk_department_number")//fk to associate the depno
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

	/////////////////////////////////////////////////////////////////////////////
	
	Set<Project>projectsAssigned  = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_PROJECT_ASSIGNMENTS",
						joinColumns= {@JoinColumn(name="fk_empno")},
						inverseJoinColumns= {@JoinColumn(name="fk_projectId")}
						)
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	/////////////////////////////////////////////////////////////////////////////
	
	public Employee() {
	// TODO Auto-generated constructor stub
}

	@Id //marking the property as primary key
	@Column(name="employee_number")// use to name column 
	@GeneratedValue(strategy=GenerationType.AUTO)//auto-numbering configuration as per db
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	@Column(name="employee_name", length=50, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return Designation;
	}

	public void setDesignation(Designation designation) {
		Designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", Designation=" + Designation
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}




}
