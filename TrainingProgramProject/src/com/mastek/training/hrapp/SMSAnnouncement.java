package com.mastek.training.hrapp;

public class SMSAnnouncement extends Announcement {

	// Each derived class of the base abstract class  must override all abstract methods from the base class
	@Override
	public void sendAnnouncement() {
		System.out.println("Sending SMS to:"+getForGroup()+" By "+getFrom()+ " with Title"+getSubject()+" and Text:"+getContentText());
	}

}
