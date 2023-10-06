package com.PropertyManagementSystem;

public class User {
	private int UID;
	private String username;
	private String email;
	private String password;
	
	
	public User(int uID, String username, String email, String password) {
		UID = uID;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public int getUID() {
		return UID;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public void setUID(int uID) {
		UID = uID;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
