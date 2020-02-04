package com.mastek.training.hrapp;

import java.io.Serializable;

import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.bson.Document;


//if the class id defined as final then we can not subclass/inherit/extend the class
public class Employee implements Serializable {
//serializable as marker to manage ObjectOuput/InputStream
	private int empno;
	private String name;
	private double unitDaySalary;
	private Designations designation;
	private transient Grades grade; //transient key word will denote the sterilier to skip this field while storing using binary files 
	
	public static final int MAX_PAID_DAYS=90; // THESE ARE USED FOR THINGS THAT COULD CHANGE
	public static final int MAX_DAY_RATE=2000; // THIS MEANS YOU ONLY HAVE TO CHANGE ONE VALUE
	public static final int MIN_DAY_RATE=10; 
	public static final int DEFAULT_ZERO=0;
	public static final int MAX_EMPNO=999999;
	private static final char[] Employee = null; 
	//default constructors: A class constructor without any arguments; they help developers to create a usable objects for simulations 
	
	//blocks:
	// static block: executed at class loading time 
	static {//we use to initialise the static members of the class
		System.out.println("Employee Static Block Called");
	}
	
	//instance block: executed before the constructor is called for any object of the class
	
	{
		setEmpno(9999);
		setName("Example");
		setDesignation(Designations.ARCHITECT);
		setUnitDaySalary(MIN_DAY_RATE);
		System.out.println("Employee Instance Block Called");
	}
	
	public Employee() {
		System.out.println("Employee Default Constructor Called");
		System.out.println("eno:"+getEmpno()+", name:"+getName()+", unit day salary:"+getUnitDaySalary()+", designation:"+getDesignation());;
	}
	
	public Employee(int empno) {
		this.setEmpno(empno);
		System.out.println("Employee Default Constructor Called with empno");
		System.out.println("eno:"+getEmpno()+", name:"+getName()+", unit day salary:"+getUnitDaySalary()+", designation:"+getDesignation());;
	}
	
	public Employee(int empno, String name, double unitDaySalary, Designations designations ) {
		this.setEmpno(empno);
		this.setName(name);
		this.setUnitDaySalary(unitDaySalary);
		this.setDesignation(designations);
		System.out.println("Employee Master Constructor Called");
		System.out.println("eno:"+getEmpno()+", name:"+getName()+", unit day salary:"+getUnitDaySalary()+", designation:"+getDesignation());;
	}
	
	
	public void finalize() { // method called by garbage collector before deleting the object  - you can inform to collect using System.gc();
		setEmpno(0);
		setName(null);
		setDesignation(null);
		setGrade(null);
		setUnitDaySalary(0);
		System.out.println("Employee Object Finialized");
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		if (empno>DEFAULT_ZERO &&  empno<MAX_EMPNO) {
		this.empno = empno;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitDaySalary() {
		return unitDaySalary;
		}
	public void setUnitDaySalary(double unitDaySalary) {
		if (unitDaySalary >MIN_DAY_RATE && unitDaySalary <MAX_DAY_RATE) {
		this.unitDaySalary = unitDaySalary;
		}
	}
	public Designations getDesignation() {
		return designation;
	}
	public void setDesignation(Designations designation) {
		this.designation = designation;
	}
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	
	
	
	public double getNetSalary(int noOfDays) throws Exception {
		if(noOfDays<DEFAULT_ZERO) {
			
		throw new Exception ("Invalid Input for Days: "+noOfDays);}
			//throw new RuntimeException ("Invalid Input for Days: "+noOfDays);	} raise an unchecked exception on business conditions 
		
		if (noOfDays<DEFAULT_ZERO || noOfDays>MAX_PAID_DAYS) {
			noOfDays=DEFAULT_ZERO; }
	
		return getUnitDaySalary()*noOfDays;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", unitDaySalary=" + unitDaySalary + ", designation="
				+ designation + ", grade=" + grade + "]";
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
	
	
	public static String getJSONString(Employee emp) {
		
		JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
		jsonBuilder.add("empno", emp.getEmpno());
		jsonBuilder.add("name", emp.getName());
		jsonBuilder.add("day-salary", emp.getUnitDaySalary());
		jsonBuilder.add("designation", emp.getDesignation().toString());
		jsonBuilder.add("grade", emp.getGrade().toString());
		
		String jsonEmp = jsonBuilder.build().toString();
		System.out.println(jsonEmp);
		return jsonEmp;	
	}
	
	public static Employee parseJSONString(String empJSON) {
		JsonReader reader = new JsonReader(new StringReader(empJSON));
		JsonObject empJSONObject =reader.readObject();
		
		Employee emp = new Employee();
		emp.setEmpno(empJSONObject.getIntValue("empno"));
		emp.setName(empJSONObject.getStringValue("name"));
		emp.setUnitDaySalary(empJSONObject.getIntValue("day-salary"));
		emp.setDesignation(Designations.valueOf(empJSONObject.getStringValue("designation")));
		emp.setGrade(Grades.valueOf(empJSONObject.getStringValue("grade")));
		
		System.out.println("From JSoN: "+empJSON);
		System.out.println("To Emo: "+emp);
		
		reader.close();
		return emp;
						
	}
	
	public static Document getEmployeeMongoDocument(Employee emp) {
		
		Document docEmp = new Document(); 
		
		docEmp.put("empno", emp.getEmpno());
		docEmp.put("name", emp.getName());
		docEmp.put("unit-salary", emp.getUnitDaySalary());
		docEmp.put("grade", emp.getGrade().toString());
		docEmp.put("designation", emp.getDesignation().toString());
		
		return docEmp;
		}
	
	public static Employee getEmployeeFromMongoDocument(Document empDoc) {
		Employee emp = new Employee ();
		try {
			emp.setEmpno(empDoc.getInteger("empno"));
			emp.setName(empDoc.getString("name"));
			emp.setUnitDaySalary(empDoc.getDouble("unit-salary"));
			emp.setGrade(Grades.valueOf(empDoc.getString("grade")));
			emp.setDesignation(Designations.valueOf(empDoc.getString("designation")));
			
		} catch (Exception e) {
			emp = null;
		}
		
		return emp;
	}
	
	
}
