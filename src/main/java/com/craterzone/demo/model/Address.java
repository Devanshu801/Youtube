package com.craterzone.demo.model;

import javax.persistence.Id;

public class Address {
	@Id
	private int id;
	private int houseNo;
	private String street;
	private String area;
	private String landmark;
	private String city;
	private String state;
	private String countryCode;
	private String pincode;
	private long created;
	private long updated;
	private User userId;
	
		
	public Address() {
		super();
		
	}


	public Address(int id, int houseNo, String street, String area, String landmark, String city, String state,
			String countryCode, String pincode, long created, long updated, User userId) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.street = street;
		this.area = area;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.countryCode = countryCode;
		this.pincode = pincode;
		this.created = created;
		this.updated = updated;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCountryCode() {
		return countryCode;
	}




	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}




	public String getPincode() {
		return pincode;
	}




	public void setPincode(String pincode) {
		this.pincode = pincode;
	}




	public long getCreated() {
		return created;
	}




	public void setCreated(long created) {
		this.created = created;
	}




	public long getUpdated() {
		return updated;
	}




	public void setUpdated(long updated) {
		this.updated = updated;
	}




	public User getUserId() {
		return userId;
	}




	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", street=" + street + ", area=" + area + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", countryCode=" + countryCode + ", pincode="
				+ pincode + ", created=" + created + ", updated=" + updated + ", userId=" + userId + "]";
	}
	
	
	
}
