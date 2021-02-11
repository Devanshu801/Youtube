package com.craterzone.demo.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyTemporal;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="users")
public class UserDao {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;
@Column
@Size(min=3,max=30)
	private String firstName;
@Column
	private String lastName;
@Column	
@MapKeyTemporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private long dateOfBirth;

@Column(unique = true)
@javax.validation.constraints.Email
private  String email;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id", referencedColumnName = "id")
  private  AddressDao address;
@Column
	private  long created;
@Column
	private  long updated;
@Column
	private  String emailPassword;

public UserDao() {
	super();
	// TODO Auto-generated constructor stub
}

public UserDao(int id, @Size(min = 3, max = 30) String firstName, String lastName, long dateOfBirth,
		@Email String email, AddressDao address, long created, long updated, String emailPassword) {
	super();
	// this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.email = email;
	this.address = address;
	this.created = created;
	this.updated = updated;
	this.emailPassword = emailPassword;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public long getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(long dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public AddressDao getAddress() {
	return address;
}
public void setAddress(AddressDao address) {
	this.address = address;
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
public String getEmailPassword() {
	return emailPassword;
}
public void setEmailPassword(String emailPassword) {
	this.emailPassword = emailPassword;
}

@Override
public String toString() {
	return "UserDao [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
			+ ", email=" + email + ", address=" + address + ", created=" + created + ", updated=" + updated
			+ ", emailPassword=" + emailPassword + "]";
}

}