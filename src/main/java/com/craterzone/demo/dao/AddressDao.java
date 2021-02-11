package com.craterzone.demo.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="address")
public class AddressDao {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column
private int houseNo;
@Column
private String street;
@Column
private String area;
@Column
private String landmark;
@Column
private String city;
@Column
private String state;
@Column
private String countryCode;
@Column
private String pincode;
@Column
private long created;
@Column
private long updated;



@OneToOne(mappedBy = "address")
 private UserDao user;



public AddressDao() {
	super();
	// TODO Auto-generated constructor stub
}

public AddressDao(int id, int houseNo, String street, String area, String landmark, String city, String state,
		String countryCode, String pincode, long created, long updated, UserDao user) {
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
	this.user = user;
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

public UserDao getUser() {
	return user;
}

public void setUser(UserDao user) {
	this.user = user;
}

@Override
public String toString() {
	return "AddressDao [id=" + id + ", houseNo=" + houseNo + ", street=" + street + ", area=" + area + ", landmark="
			+ landmark + ", city=" + city + ", state=" + state + ", countryCode=" + countryCode + ", pincode=" + pincode
			+ ", created=" + created + ", updated=" + updated + ", user=" + user + "]";
}


}
