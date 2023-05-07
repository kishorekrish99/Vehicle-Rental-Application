package com.vehicle.rental.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class cards {
	private int id;
	private String name;
	private long number;
	private int month;
	private int year;
	private int cvv;
	private String cardtype;
	
	public cards() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	@Override
	public String toString() {
		return "cards [id=" + id + ", name=" + name + ", number=" + number + ", month=" + month + ", year=" + year
				+ ", cvv=" + cvv + ", cardtype=" + cardtype + "]";
	}

	public cards(int id, String name, long number, int month, int year, int cvv, String cardtype) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.month = month;
		this.year = year;
		this.cvv = cvv;
		this.cardtype = cardtype;
	
	}

	
	
	
	
}
