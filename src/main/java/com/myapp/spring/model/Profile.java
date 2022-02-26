package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile1")
public class Profile {

	@Id
	@Column(name = "email_id",nullable = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String emailId;
	

	@Column(name = "full_name",nullable = false)
	private String fullName;
	
	@Column(name = "gender",nullable = false)
	private String gender;
	
	@Column(name = "date_of_birth",nullable = false)
	private String dateOfBirth;
	
	
	@Column(name = "address",nullable = false)
	private String address;
	
	@Column(name = "city",nullable = false)
	private String city;
	
	@Column(name = "state",nullable = false)
	private String state;
	
	@Column(name = "country",nullable = false)
	private String country;
	
	@Column(name = "pinCode",nullable = false)
	private String pinCode;

	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;
	
	
	
	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
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



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getPinCode() {
		return pinCode;
	}



	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}





	public Profile(String emailId, String fullName, String gender, String dateOfBirth, String address, String city,
			String state, String country, String pinCode, String phoneNumber) {
		super();
		this.emailId = emailId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.phoneNumber = phoneNumber;
	}



	
	
	


	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		return Objects.hash(address, city, country, dateOfBirth, emailId, fullName, gender, phoneNumber, pinCode,
				state);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(gender, other.gender) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(pinCode, other.pinCode) && Objects.equals(state, other.state);
	}



	





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [emailId=");
		builder.append(emailId);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", country=");
		builder.append(country);
		builder.append(", pinCode=");
		builder.append(pinCode);
		builder.append(", phone_number=");
		builder.append(phoneNumber);
		builder.append("]");
		return builder.toString();
	}
	
	
}

