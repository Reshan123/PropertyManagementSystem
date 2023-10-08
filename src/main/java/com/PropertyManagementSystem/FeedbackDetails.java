package com.PropertyManagementSystem;

public class FeedbackDetails {
	private String Fname;
	private String Lname;
	private String Email;
	private String Message;
	
	public FeedbackDetails(String fname, String lname, String email, String message) {
		Fname = fname;
		Lname = lname;
		Email = email;
		Message = message;
	}
	
	public String getFname() {
		return Fname;
	}
	public String getLname() {
		return Lname;
	}
	public String getEmail() {
		return Email;
	}
	public String getMessage() {
		return Message;
	}
	
	
}
