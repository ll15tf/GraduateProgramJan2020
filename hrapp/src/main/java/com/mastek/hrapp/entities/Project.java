package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
@Entity
@Table(name="JPA_Projects")
public class Project {
	
	int projectID; 
	@FormParam("name")
	String name;
	@FormParam("customerName")
	String customerName; 
		
	//////////////////////////////////////////////////////////////////////
	
	Set<Employee> projectTeam = new HashSet<>();
	
	@ManyToMany(mappedBy="projectsAssigned")
	@XmlTransient
	public Set<Employee> getProjectTeam() {
		return projectTeam;
	}

	public void setProjectTeam(Set<Employee> projectTeam) {
		this.projectTeam = projectTeam;
	}

	//////////////////////////////////////////////////////////////////////
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projectID;
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
		Project other = (Project) obj;
		if (projectID != other.projectID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", name=" + name + ", customerName=" + customerName + "]";
	}

	@Id //marking the property as primary key
	@Column(name="project_number")// use to name column 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	@Column(name="project_name", length=50, nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="customers_name", length=50, nullable=false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
}
