package com.PropertyManagementSystem;

public class Property {
	
	private int ID;
	private String PropertyName;
	private String Address;
	private String Description;
	private String price;
	private int rooms;
	private String area;
	private String MainImage;
	private String UserName;
	
	public Property(int iD, String propertyName, String address, String description, String price, int rooms,
			String area, String mainImage, String userName) {
		ID = iD;
		PropertyName = propertyName;
		Address = address;
		Description = description;
		this.price = price;
		this.rooms = rooms;
		this.area = area;
		MainImage = mainImage;
		UserName = userName;
	}


	public Property(int iD, String propertyName, String address, String description, String price, int rooms, String area, String mainImage ) {
		ID = iD;
		PropertyName = propertyName;
		Address = address;
		Description = description;
		this.price = price;
		this.rooms = rooms;
		this.area = area;
		MainImage = mainImage;
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


	public String getMainImage() {
		return MainImage;
	}


	public String getUserName() {
		return UserName;
	}
	
}
