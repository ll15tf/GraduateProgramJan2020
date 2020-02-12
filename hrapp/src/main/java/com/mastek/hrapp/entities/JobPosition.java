package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_INITERNAL_JOB_POSITIONS")
public class JobPosition {
	
	int jobId;
	String clientName; 
	int numberOfPositions; 
	String location; 
	String skillsRequired;
	
	
	Set<Employee> applicants = new HashSet<>();
	
	public Set<Employee> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Employee> applicants) {
		this.applicants = applicants;
	}

	
	
	
	
	public JobPosition() {
		// TODO Auto-generated constructor stub
	}

	@Id
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(int numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	@Override
	public String toString() {
		return "JobPosition [jobId=" + jobId + ", clientName=" + clientName + ", numberOfPositions=" + numberOfPositions
				+ ", location=" + location + ", skillsRequired=" + skillsRequired + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobId;
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
		JobPosition other = (JobPosition) obj;
		if (jobId != other.jobId)
			return false;
		return true;
	}
	
	
	

}
