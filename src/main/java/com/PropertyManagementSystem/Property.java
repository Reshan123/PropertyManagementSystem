package com.PropertyManagementSystem;

public class Property {
	
	private int ID;
	private String PropertyName;
	private String Address;
	private String Description;
	private String price;
	private int bathrooms;
	private int kitchens;
	private int rooms;
	private String area;
	private String MainImage;
	private String UserName;
	private String UserEmail;


	public Property(int iD, String propertyName, String address, String description, String price, int bathrooms,
			int kitchens, int rooms, String area, String mainImage, String userName, String userEmail) {
		ID = iD;
		PropertyName = propertyName;
		Address = address;
		Description = description;
		this.price = price;
		this.bathrooms = bathrooms;
		this.kitchens = kitchens;
		this.rooms = rooms;
		this.area = area;
		MainImage = mainImage;
		UserName = userName;
		UserEmail = userEmail;
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
	
	public String getUserEmail() {
		return UserEmail;
	}

	public int getBathrooms() {
		return bathrooms;
	}


	public int getKitchens() {
		return kitchens;
	}
	
}
