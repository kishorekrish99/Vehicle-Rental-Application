package com.vehicle.rental.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicles")
public class Vehicles {
	
	@Id
	private int id;
	private String brand;
	private String fuelType;
	private String model;
	private LocalDate purchaseDate;
	private String type;
	private boolean availability;
	private String color;
	private String number;
	private int price;
	private int uniqueId;
	private String fuelquantity;
	public Vehicles() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getFuelquantity() {
		return fuelquantity;
	}
	public void setFuelquantity(String fuelquantity) {
		this.fuelquantity = fuelquantity;
	}
	public Vehicles(int id, String brand, String fuelType, String model, LocalDate purchaseDate, String type,
			boolean availability, String color, String number, int price, int uniqueId, String fuelquantity) {
		super();
		this.id = id;
		this.brand = brand;
		this.fuelType = fuelType;
		this.model = model;
		this.purchaseDate = purchaseDate;
		this.type = type;
		this.availability = availability;
		this.color = color;
		this.number = number;
		this.price = price;
		this.uniqueId = uniqueId;
		this.fuelquantity = fuelquantity;
	}
	@Override
	public String toString() {
		return "Vehicles [id=" + id + ", brand=" + brand + ", fuelType=" + fuelType + ", model=" + model
				+ ", purchaseDate=" + purchaseDate + ", type=" + type + ", availability=" + availability + ", color="
				+ color + ", number=" + number + ", price=" + price + ", uniqueId=" + uniqueId + ", fuelquantity="
				+ fuelquantity + "]";
	}
	
	
	
}
