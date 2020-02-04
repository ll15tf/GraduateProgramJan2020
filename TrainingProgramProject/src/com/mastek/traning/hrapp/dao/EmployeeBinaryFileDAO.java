package com.mastek.traning.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {

	
	Map<Integer, Employee> empMap;
	
	private String fileName;
	
	
	public EmployeeBinaryFileDAO(String fileName) {
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		//read all the data from file and load in collection map
		readMapFromFile();
	}
	//read data from file and add it to map shared
	
	private void readMapFromFile() {
		//identify your object input stream - allows you to read  objects from binary fileInput stream 
		//fileInputStream - read binary data from file objects 
		//file Open or refer to the file using Filenames/file Path
		
		try (ObjectInputStream objIn = new ObjectInputStream (
											new FileInputStream(
												new File(fileName)))){
			// we use try blocks with resources to manage auto-closing of streams 
			
			empMap = (Map<Integer, Employee>) objIn.readObject();
			
		} catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}
	//update file with the map content 
	
	private void writeMaptoFile() {
	//objectoutputStream: write binary object in sterilised format in fileoutputsteam 
		//file output stream: write binary objects to files
		// file: file object will refer to the file to be updated/created if not present 
		
		try (ObjectOutputStream objOut = new ObjectOutputStream (
											new FileOutputStream(
												new File(fileName)))) {
			
			objOut.writeObject(empMap);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		
	}
	
	
	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile();
		if (!empMap.containsKey(newEmployee.getEmpno())) {
			empMap.put(newEmployee.getEmpno(), newEmployee);
			writeMaptoFile();
		}
				return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values(); //return all the values from the map
	}

	@Override
	public Employee find(int key) {
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();
		Employee removedEmp = null;
		if (empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeMaptoFile(); // write use to minimum as it takes up time 
		}
		return removedEmp;
	}

}
