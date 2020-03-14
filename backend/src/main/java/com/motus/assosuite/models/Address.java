package com.motus.assosuite.models;

public class Address {
	
	private Integer streetNum;
	
	private String street;
	
	private String city;
	
	private String zip;
	
	private String description;

	public Address() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public Integer getStreetNum() {
		return streetNum;
	}

	public String getDescription() {
		return description;
	}

	public void setStreetNum(Integer streetNum) {
		this.streetNum = streetNum;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Address [streetNum=" + streetNum + ", street=" + street + ", city=" + city + ", zip=" + zip
				+ ", description=" + description + "]";
	}
	
}
