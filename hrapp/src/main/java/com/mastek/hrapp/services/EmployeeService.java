package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.dao.DepartmentDAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectDAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;

@Component
@Scope("singleton")
public class EmployeeService {
	
	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentDAO deptDAO;
	
	@Autowired
	ProjectDAO proDAO;
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	@PostConstruct
	public void initializeService() {
		System.out.println("Employee Service Inititalised");
	}
	
	@PreDestroy
	public void terminateService() {
		System.out.println("Employee service terminated");
	}

	public void exampleMethod() {
		System.out.println("connect to"+getExampleProperty()+ " for business data");
	}
	
	public String getExampleProperty() {
		return exampleProperty;
	}
@Value("String Example Data Source")
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example property set: "+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

/////////////////////////////////////////////////////////////////////////////

@Transactional //this will keep the session open until the method returns the value 
public Employee assignEmployeeToDepartment(int empno, int deptno) {
	
	Employee emp = empDAO.findById(empno).get();
	Department dept = deptDAO.findById(deptno).get();
	
	emp.setCurrentDepartment(dept);
	dept.getTeam().add(emp);
	
	empDAO.save(emp);
	deptDAO.save(dept);
	
	return emp;
}

@Transactional
public Employee assignEmployeeToProject(int empno, int projectid) {
	
	Employee emp = empDAO.findById(empno).get();
	Project newProject = proDAO.findById(projectid).get();
	
	emp.getProjectsAssigned().add(newProject);
	empDAO.save(emp);

	return emp;
}

}


