package com.mastek.training.basics;

public class MastekApplicants {
	
	Candidate candidate;
	
	String jobRole = "Senior Java Developer";
	String Location = "Leeds";
	String ContractType = "Full Time";
	double salary = 60000;
	
	
	public void Requirements() {
		if(candidate.yearsOfExpierience>4 && 
				candidate.skills == "Spring Batch" &&
				candidate.skills == "HTML"
					) {
			applyNow();
		}
	}
	public String applyNow() {
		return "https://www.mastek.com/careers";
	}
}

