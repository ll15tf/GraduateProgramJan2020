package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;


class HRApplicationTest {
	
	Employee ex1;
	
	@BeforeEach
	public void setupEmpTestCase() {
		System.out.println("Before Test Case");
		//Employee.DEFAULT_ZERO; //<class_name>.<static_member>
		ex1 = new Employee();
		
		ex1.setEmpno(61298);
		ex1.setName("Tabitha Fogarty");
		ex1.setDesignation(Designations.BUSINESS_ANALYST);
		ex1.setGrade(Grades.G4);
		ex1.setUnitDaySalary(300); //putting this here stops waste, optimising the code 
		
		Employee ex2 = new Employee(1122); 
	
		Employee ex3 = new Employee(2222, "Example", 344.0, Designations.DEVELOPER);
		
		ex2=null; // release the object to mark for garbage 
		ex3=null;
		System.gc();
		//ex2.getEmpno(); will throw NullPointerException
	}
	
	@AfterEach
	public void teardownEmpTestCase() {
		System.out.println("After Test Case");
		
	}
	
	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("Test Case Create");
		/*Employee ex1 = new Employee();
		ex1.setEmpno(61298);
		ex1.setName("Tabitha Fogarty");
		ex1.setDesignation(Designations.BUSINESS_ANALYST);
		ex1.setGrade(Grades.G4);
		ex1.setUnitDaySalary(500);*/
		
		System.out.println(
				"Number: "+ex1.getEmpno()+ ", "+"\n"+
				"Name: "+ex1.getName()+ ", "+"\n"+
				"Designation: "+ex1.getDesignation()+ ", "+"\n"+
				"Grade: "+ex1.getGrade()+ ", "+"\n"+
				"Day Salary: £"+ex1.getUnitDaySalary()
				);			
	}
	
		@Test
		void testCreateAndComputeSalaryEmployeeObject() {
			System.out.println("Test Case Compute");
			/*Employee ex1 = new Employee();
			ex1.setEmpno(61298);
			ex1.setName("Tabitha Fogarty");
			ex1.setDesignation(Designations.BUSINESS_ANALYST);
			ex1.setGrade(Grades.G4);
			ex1.setUnitDaySalary(300);*/
			
			try {
				assertEquals(9000, ex1.getNetSalary(30), "Invalid Net Salary Compuation");
				assertEquals(9000, ex1.getNetSalary(30), "Invalid Net Salary Compuation");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}

		@Test
		void testSalesEmployeeObjectUsage() {
			SalesEmployee saleEx1 = new SalesEmployee(); 
			
			saleEx1.setEmpno(224);
			saleEx1.setName("Example");
			saleEx1.setUnitDaySalary(100);
			saleEx1.setDesignation(Designations.ARCHITECT);
			saleEx1.setGrade(Grades.G4);
			saleEx1.setCommission(0.8);
			saleEx1.setTarget(1000000000);
			
			try {
				assertEquals(1620,saleEx1.getNetSalary(9), "Invalid Salary Calculated");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		void testObjectFeaturesOnEmployee() {
			
			System.out.println("<==== Object Features Start ===>");
			
			System.out.println(ex1.toString());
			System.out.println("HashCode: "+ex1.hashCode());
			
			System.out.println("<==== Object Features End ===>");
		}
		
		@Test
			void testSendAnnouncementToEmployees() {
			// Announcement exAnnouncement = new Announcement; can not use new as this is an abstract class 
			// to use an abstract class object you must extend it with derived class and override ALL abstract methods defined in base/parent class
			Announcement exSMS = new SMSAnnouncement();
			exSMS.setFrom("HR");
			exSMS.setForGroup("MASTEKEER_AT_GLASGOW");
			exSMS.setSubject("Weather Conditions");
			exSMS.setContentText("All Mastekeers adviced to work from home tomorrow");
			
			Announcement exEmail = new EmailAnnouncement();
			exEmail.setFrom("Leadership Team");
			exEmail.setForGroup("MASTEKEERS");
			exEmail.setSubject("QMEET JAN 2020");
			exEmail.setContentText("You are invited to the Q-meet 2020");
			
			if (exSMS instanceof SMSAnnouncement) {
				System.out.println("Connect to Telecom SMS Service");
				exSMS.sendAnnouncement(); // connects automatically to the derived class - connected to SMS and use Send from SMSAnnouncement
			}
		
			if (exEmail instanceof EmailAnnouncement) {
				System.out.println("Connect to Email Service");
				exEmail.sendAnnouncement();//connect to email and use send from SMS Announcement 
			}
			assertTrue(exSMS instanceof SMSAnnouncement);
			assertTrue(exEmail instanceof EmailAnnouncement);
		}
		
		
		@Test
		
		void testShapeExample() {
			Rectangle rect = new Rectangle(); 
			rect.setLength(10);
			rect.setBreath (20);
			
			Circle circle= new Circle(); 
			circle.setRadius(20); 
			
			Shape shRect = rect; 
			Shape shCircle = circle; 
			
			System.out.println("Rectangle Area: "+shRect.getArea());
			System.out.println("Rectangle Perimeter: "+shRect.getPerimeter());
			
			System.out.println("Circle Area: "+shCircle.getArea());
			System.out.println("Circle Perimeter: "+shCircle.getPerimeter());
			
			assertTrue(rect instanceof Shape, "Invalid Shape");
			assertTrue(circle instanceof Shape, "Invalid Shape");
		}
}



