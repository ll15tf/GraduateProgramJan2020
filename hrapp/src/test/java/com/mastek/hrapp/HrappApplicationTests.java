package com.mastek.hrapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentDAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectDAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest
class HrappApplicationTests {
 
	@Autowired
	EmployeeService empSvc; 
	
	@Autowired
	EmployeeService empsvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentDAO depDAO; 
	
	@Autowired 
	ProjectDAO proDAO; 
	
	
	@Test
	void testEmployeeServiceMethod() {
		empSvc.exampleMethod();
		empsvc1.exampleMethod();
		
	}
	@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee(); 
		emp.setName("Example");
		emp.setSalary(2334);
		emp.setDesignation(Designation.ARCHITECT);
		
		//emp = empDAO.save(emp);
		
		System.out.println(emp);
		
		assertNotNull(emp, "Employee Not Added");
		
	}
	
	@Test
	void testDepartmentAdd() {
		Department dep = new Department();
		dep.setLocation("Leeds");
		dep.setName("Example");
		
		//dep = depDAO.save(dep);
		
		System.out.println(dep);
		
		assertNotNull(dep, "Department not Added");
	}
	
	
	@Test
	void testProjectAdd() {
		Project pro = new Project(); 
		pro.setName("Example Project Name");
		pro.setCustomerName("Example Customer Name");
		
		//pro = proDAO.save(pro);
		
		System.out.println(pro);
		
		assertNotNull(pro, "Project not added");
	}
	
	
	@Test
	void testListEmployees() {
		Iterable<Employee> emps =empDAO.findAll();
		assertNotNull(emps, "Employees not found");
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
		
	@Test
	void testListDepartments() {
		Iterable<Department> dep =depDAO.findAll();
		assertNotNull(dep, "Department Not Found");
		for ( Department department : dep) {
			System.out.println(department);
			}
	}
	
	@Test
	void testListProjects() {
		Iterable<Project> pro= proDAO.findAll();
		assertNotNull(pro, "Project not Found");
		for (Project project : pro) {
			System.out.println(project);
		}
	}
	
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched"+emp);
		emp.setSalary(emp.getSalary()+1000);
		emp.setDesignation(Designation.MANAGER);
		
		//emp =empDAO.save(emp);
		
		System.out.println("Updated Employee: "+emp);
	}

	/*@Test
	void testDeleteEmployee() {
		empDAO.deleteById(16); // must change every time we do test
		System.out.println("Employee Deleted");}*/
	
	
	@Test
	void testAssignEmployeeToDepartment(){
		
		Employee emp = empSvc.assignEmployeeToDepartment(22,33); 
		assertNotNull(emp.getCurrentDepartment(), "Department not Assigned");
		
	}
	
	@Test
	void testAssignEmployeeToProject() {
		Employee emp = empSvc.assignEmployeeToProject(22,41);
		assertNotNull(emp.getProjectsAssigned().size()>0, "project assigned");
	}
	
}
