package com.mastek.training.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.traning.hrapp.dao.DataAccessObject;
import com.mastek.traning.hrapp.dao.EmployeeBinaryFileDAO;
import com.mastek.traning.hrapp.dao.EmployeeJDBCDAO;
import com.mastek.traning.hrapp.dao.EmployeeJSONFileDAO;
import com.mastek.traning.hrapp.dao.EmployeeMongoDAO;

class EmployeeDAOTests {

	DataAccessObject<Employee> empDAO;
	
	@BeforeEach
	void setUp() throws Exception {
		//empDAO = new EmployeeBinaryFileDAO("empdata.dat");
		//empDAO = new EmployeeJSONFileDAO("empdata.json");
		//empDAO = new EmployeeJDBCDAO();
		empDAO = new EmployeeMongoDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmployeeData() {
		
		Employee newEmp = new Employee();
		newEmp.setEmpno(10);
		newEmp.setName("Example");
		newEmp.setDesignation(Designations.ARCHITECT);
		newEmp.setGrade(Grades.G4);
		newEmp.setUnitDaySalary(500);
		
		
		/*String jsonOBJ = Employee.getJSONString(newEmp);
		System.out.println(jsonOBJ);
		Employee exemp = Employee.parseJSONString(jsonOBJ);
		System.out.println(exemp);*/
		
		
		
		newEmp= empDAO.add(newEmp); // returns object if saves successfully
		assertNotNull(newEmp, "Employee Not Added");
		
		Employee fetchEmp = empDAO.find(10);
		}
	

	
	@Test
	void testListAllEmployees() {
		Collection<Employee> emps = empDAO.listAll();
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testRemoveEmployee() {

		Employee newEmp = new Employee();
		newEmp.setEmpno(11);
		newEmp.setName("Remove Sample");
		newEmp.setDesignation(Designations.DEVELOPER);
		newEmp.setGrade(Grades.G6);
		newEmp.setUnitDaySalary(233);
		
		newEmp= empDAO.add(newEmp); // returns object if saves successfully
		assertNotNull(newEmp, "Employee Not Added");
		
		Employee removedEmp = empDAO.remove(11);
		assertNotNull(removedEmp, "Employee Not Removed");
		
		Employee checkRemovedEmp = empDAO.find(11);
		assertNull(checkRemovedEmp, "Employee Not Removed");
		
		
	}
}
