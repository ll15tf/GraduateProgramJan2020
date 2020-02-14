package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.DepartmentAPI;
import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.apis.ProjectAPI;
import com.mastek.hrapp.dao.DepartmentDAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.ProjectDAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Project;

@Component
@Scope("singleton")
public class EmployeeService implements EmployeeAPI, DepartmentAPI, ProjectAPI{
	
	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentDAO deptDAO;
	
	@Autowired
	ProjectDAO proDAO;
	
	@Autowired
	JobPositionDAO jobsDAO;
	
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

public JobPosition applyForJobPosition (int jobId, int empno) {
	JobPosition job = jobsDAO.findById(jobId).get();
	Employee emp = empDAO.findById(empno).get();
	
	job.getApplicants().add(emp);
	
	job = jobsDAO.save(job); 
	return job; 
}
	@Override
	public Iterable<Employee> listAllEmployees() {
		System.out.println("listing all employees");
		return empDAO.findAll();
}
	@Override
	public Employee findByEmpno(int empno) {
		return empDAO.findById(empno).get();
	}
	
	@Override
	public Employee registerNewEmployee(Employee newEmployee) {
		newEmployee = empDAO.save(newEmployee);
		return newEmployee;
	}
	@Override
	public Iterable<Project> listAllProjects() {
		System.out.println("listing all departments");
		return proDAO.findAll();
	}
	@Override
	public Project findByProjectID(int projectID) {
		// TODO Auto-generated method stub
		return proDAO.findById(projectID).get();
	}
	@Override
	public Project registerNewProject(Project newproject) {
		newproject = proDAO.save(newproject);
		return newproject;
	}
	@Override
	public Iterable<Department> listAllDepartments() {
		System.out.println("listing all department");
		return deptDAO.findAll();
	}
	@Override
	public Department findByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return deptDAO.findById(deptno).get();
	}
	@Override
	public Department registerNewDepartment(Department newDepartment) {
		newDepartment = deptDAO.save(newDepartment);
		return newDepartment;
	}

}


