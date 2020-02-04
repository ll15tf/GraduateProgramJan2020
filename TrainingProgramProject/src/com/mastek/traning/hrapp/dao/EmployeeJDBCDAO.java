package com.mastek.traning.hrapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mysql.jdbc.Driver;

public class EmployeeJDBCDAO implements DataAccessObject<Employee> {

	Connection conMysql;
	
	public EmployeeJDBCDAO() {
		
		try {
			//1.load database driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. open the connection to mysql
			conMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/graduate_2020_masteknet", "root", "root");
			System.out.println("Connection Sucessful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public Employee add(Employee newEmployee) {
		//define the query in sql format with parameters if required
		String sqlInsert = "Insert into jdbc_employees "
							+" (empno, name, unit_salary, grade, designation)" 
							+ " values(?,?,?,?,?)";
		
		try(PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)) {
			//2. prepare the object for query and set all parameters
			psInsert.setInt(1, newEmployee.getEmpno());
			psInsert.setString(2, newEmployee.getName());
			psInsert.setDouble(3, newEmployee.getUnitDaySalary());
			psInsert.setString(4, newEmployee.getGrade().toString());
			psInsert.setString(5, newEmployee.getDesignation().toString());
			// 4. execute the query on the database table and return the rows affected 
			int recordsAffected = psInsert.executeUpdate(); // used for insert, delete and update in SQL
			System.out.println(recordsAffected+ " Employees Inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
			newEmployee =null; // return null in case of failure
			
		}
		return newEmployee; // on success return the new employee
	}

	@Override
	public Collection<Employee> listAll() {

		String sqlSelectAll = "select * from jdbc_employees";
		List<Employee> employees = new LinkedList<Employee>();
		try(Statement stSelectAll = conMysql.createStatement()) {
			ResultSet rsEmployees = stSelectAll.executeQuery(sqlSelectAll);
			while (rsEmployees.next()) {
				Employee e = new Employee();
				e.setEmpno(rsEmployees.getInt("empno"));
				e.setName(rsEmployees.getString("name"));
				e.setUnitDaySalary(rsEmployees.getDouble("unit_salary"));
				e.setGrade(Grades.valueOf(rsEmployees.getString("grade")));
				e.setDesignation(Designations.valueOf(rsEmployees.getString("designation")));
				
				employees.add(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee find(int key) {
		
		String findSQL = "Select * from jdbc_employees where empno=?";
		Employee emp = null;
		try(PreparedStatement psFind = conMysql.prepareStatement(findSQL)) {
			
			psFind.setInt(1, key); // set the empno for search
			
			ResultSet rsFindResult =psFind.executeQuery();
			
			if (rsFindResult.next()) {
				emp = new Employee();
				emp.setEmpno(rsFindResult.getInt("empno"));
				emp.setName(rsFindResult.getString("name"));
				emp.setUnitDaySalary(rsFindResult.getDouble("unit_salary"));
				emp.setGrade(Grades.valueOf(rsFindResult.getString("grade")));
				emp.setDesignation(Designations.valueOf(rsFindResult.getString("designation")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public Employee remove(int key) {
		
		Employee empToBeRemoved = find(key);
		if (empToBeRemoved!=null) {
			
			String sqlDelete = "delete from jdbc_employees where empno=?";
			
			try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)){
				
				psDelete.setInt(1, key);
				
				int rowsDeleted = psDelete.executeUpdate();
				System.out.println(rowsDeleted+" employee deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return empToBeRemoved;
	}

}
