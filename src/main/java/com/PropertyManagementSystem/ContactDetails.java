package com.PropertyManagementSystem;

public class ContactDetails {
	int CID;
	private String Description;
	private String Phone;
	private String Email;
	private String Address;
	
	public ContactDetails(int cID, String description, String phone, String email, String address) {
		CID = cID;
		Description = description;
		Phone = phone;
		Email = email;
		Address = address;
	}

	public int getCID() {
		return CID;
	}

	public String getDescription() {
		return Description;
	}

	public String getPhone() {
		return Phone;
	}

	public String getEmail() {
		return Email;
	}

	public String getAddress() {
		return Address;
	}
	
	
	
}
