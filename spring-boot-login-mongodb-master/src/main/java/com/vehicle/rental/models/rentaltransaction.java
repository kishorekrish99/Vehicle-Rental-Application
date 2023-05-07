package com.vehicle.rental.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rentaltransaction")
public class rentaltransaction {
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
	private String returnfuelquantity;
	private String username;
	private boolean insurencestatus;
	private long totalamount;
	private String miscellaneous;
	private String comments;
	private int vehicleid;
	
	public rentaltransaction() {
		
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

	public String getReturnfuelquantity() {
		return returnfuelquantity;
	}

	public void setReturnfuelquantity(String returnfuelquantity) {
		this.returnfuelquantity = returnfuelquantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public boolean isInsurencestatus() {
		return insurencestatus;
	}

	public void setInsurencestatus(boolean insurencestatus) {
		this.insurencestatus = insurencestatus;
	}

	public long getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(long totalamount) {
		this.totalamount = totalamount;
	}

	public String getMiscellaneous() {
		return miscellaneous;
	}

	public void setMiscellaneous(String miscellaneous) {
		this.miscellaneous = miscellaneous;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	@Override
	public String toString() {
		return "rentaltransaction [id=" + id + ", active=" + active + ", amount=" + amount + ", discount=" + discount
				+ ", model=" + model + ", pickupdate=" + pickupdate + ", pickuplocation=" + pickuplocation
				+ ", pickuptime=" + pickuptime + ", returndate=" + returndate + ", returnlocation=" + returnlocation
				+ ", returntime=" + returntime + ", returnfuelquantity=" + returnfuelquantity + ", username=" + username
				+ ", insurencestatus=" + insurencestatus + ", totalamount=" + totalamount + ", miscellaneous="
				+ miscellaneous + ", comments=" + comments + ", vehicleid=" + vehicleid + "]";
	}

	public rentaltransaction(int id, boolean active, int amount, int discount, String model, LocalDate pickupdate,
			String pickuplocation, LocalTime pickuptime, LocalDate returndate, String returnlocation,
			LocalTime returntime, String returnfuelquantity, String username, boolean insurencestatus, int totalamount,
			String miscellaneous, String comments, int vehicleid) {
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
		this.returnfuelquantity = returnfuelquantity;
		this.username = username;
		this.insurencestatus = insurencestatus;
		this.totalamount = totalamount;
		this.miscellaneous = miscellaneous;
		this.comments = comments;
		this.vehicleid = vehicleid;
	}

	

}
