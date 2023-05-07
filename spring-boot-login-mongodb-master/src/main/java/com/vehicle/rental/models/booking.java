package com.vehicle.rental.models;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class booking {
	
	@Id
	private int id;
	private boolean active;
	private int amount;
	private int discount;
	private String model;
	private LocalDate pickupdate;
	private String pickuplocation;
	private LocalTime pickuptime;
	private LocalDate returndate;
	private String returnlocation;
	private LocalTime returntime;
	private boolean insurence;
	public booking() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getPickupdate() {
		return pickupdate;
	}
	public void setPickupdate(LocalDate pickupdate) {
		this.pickupdate = pickupdate;
	}
	public String getPickuplocation() {
		return pickuplocation;
	}
	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}
	public LocalTime getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(LocalTime pickuptime) {
		this.pickuptime = pickuptime;
	}
	public LocalDate getReturndate() {
		return returndate;
	}
	public void setReturndate(LocalDate returndate) {
		this.returndate = returndate;
	}
	public String getReturnlocation() {
		return returnlocation;
	}
	public void setReturnlocation(String returnlocation) {
		this.returnlocation = returnlocation;
	}
	public LocalTime getReturntime() {
		return returntime;
	}
	public void setReturntime(LocalTime returntime) {
		this.returntime = returntime;
	}
	public boolean isInsurence() {
		return insurence;
	}
	public void setInsurence(boolean insurence) {
		this.insurence = insurence;
	}
	@Override
	public String toString() {
		return "booking [id=" + id + ", active=" + active + ", amount=" + amount + ", discount=" + discount + ", model="
				+ model + ", pickupdate=" + pickupdate + ", pickuplocation=" + pickuplocation + ", pickuptime="
				+ pickuptime + ", returndate=" + returndate + ", returnlocation=" + returnlocation + ", returntime="
				+ returntime + ", insurence=" + insurence + "]";
	}
	public booking(int id, boolean active, int amount, int discount, String model, LocalDate pickupdate,
			String pickuplocation, LocalTime pickuptime, LocalDate returndate, String returnlocation,
			LocalTime returntime, boolean insurence) {
		super();
		this.id = id;
		this.active = active;
		this.amount = amount;
		this.discount = discount;
		this.model = model;
		this.pickupdate = pickupdate;
		this.pickuplocation = pickuplocation;
		this.pickuptime = pickuptime;
		this.returndate = returndate;
		this.returnlocation = returnlocation;
		this.returntime = returntime;
		this.insurence = insurence;
	}
	
	
	
	
}
