package com.mastek.hrapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentDAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectDAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Payment;
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
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionDAO jobDAO; 
	
	@Test
	void testAddJobPositionDocument() {
		JobPosition jp = new JobPosition();
		jp.setJobId(123);
		jp.setClientName("Example Client");
		jp.setLocation("Example Location");
		jp.setNumberOfPositions(1);
		jp.setSkillsRequired("Example Skill");
		
		jp =jobDAO.save(jp);
		
		assertNotNull(jp, "Job Position not Saved");
	}
	
	@Test
	void testListJobPositions() {
		System.out.println("Print all job positions");
		for (JobPosition jp : jobDAO.findAll()) {
			System.out.println(jp);
		}
	}
	
	@Test
	void testFindEmployeeByDesignation(){
		Iterable<Employee> emps = empDAO.findbyDesignation(Designation.ARCHITECT);
		System.out.println("All Employees with designation as "+Designation.ARCHITECT); 
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testFindEmployeeBySalary(){
		double minSalary = 100.0;
		double maxSalary = 5000.0; 
		Iterable<Employee> emps = empDAO.findbySalary(minSalary,maxSalary);
		System.out.println("All Employees having this salary range: "+minSalary +" to "+maxSalary);
		for (Employee employee : emps) {
		System.out.println(employee);
		}	
	}
	
	@Test
	void testCashPaymentAdd(){
		Payment cashP = new Payment(); 
		cashP.setAmount(100);

		cashP = paymentDAO.save(cashP);
		System.out.println(cashP);
		assertNotNull(cashP, "Payment Not Saved");
	}
	
	@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(444);
		cardP.setCardNumber(1111111111);
		cardP.setCardService("VISA");
		
		cardP = paymentDAO.save(cardP);
		System.out.println(cardP);
		assertNotNull(cardP, "Card Payment Not Saved");
	}
	
	@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(2300);
		cheqP.setBankName("RBS");
		cheqP.setChequeNumber(123456);
		
		cheqP = paymentDAO.save(cheqP);
		System.out.println(cheqP);
		assertNotNull(cheqP, "Cheque Payment not saved");
	}
	
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
	
	@Test
	void testAssignApplyForJobPosition() {
		int jobId = 122; 
		int empno = 40;
		JobPosition jp = empSvc.applyForJobPosition(jobId, empno);
		assertNotNull(jp, "Job not applied");
		System.out.println("Applications for job Id "+jobId);
		for (Employee applicant : jp.getApplicants()) {
			System.out.println(applicant);
		}
	}
	
}
