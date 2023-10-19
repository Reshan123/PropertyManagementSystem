package com.PropertyManagementSystem;

public class Property {
	
	private int ID;
	private String PropertyName;
	private String Address;
	private String Description;
	private String price;
	private int rooms;
	private String area;
	
	public Property(int iD, String propertyName, String address, String description, String price, int rooms, String area) {
		ID = iD;
		PropertyName = propertyName;
		Address = address;
		Description = description;
		this.price = price;
		this.rooms = rooms;
		this.area = area;
	}


	public int getID() {
		return ID;
	}


	public String getPropertyName() {
		return PropertyName;
	}


	public String getAddress() {
		return Address;
	}


	public String getDescription() {
		return Description;
	}


	public String getPrice() {
		return price;
	}


	public int getRooms() {
		return rooms;
	}
	
	public String getArea() {
		return area;
	}
	
}
