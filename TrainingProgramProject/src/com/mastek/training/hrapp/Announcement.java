package com.mastek.training.hrapp;
// we decalre the class as abstract if a) any one of the methods within the class is declared as abstract, b) if any one of the abstract method from the base class is not overriden.
public abstract class Announcement {
	
	private String from;
	private String forGroup; 
	private String subject; 
	private String contentText;
	
	// we declare the method as abstract when we want derived class to define the logic of the method/behaviour
	// we cannot declare an abstract method as final 
	// we cannot declare abstract methods as private method, only as public or protected
	public abstract void sendAnnouncement();
	
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getForGroup() {
		return forGroup;
	}
	public void setForGroup(String forGroup) {
		this.forGroup = forGroup;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

}
