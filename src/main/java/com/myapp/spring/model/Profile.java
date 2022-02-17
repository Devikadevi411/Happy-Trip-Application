package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Profile")
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

	@Column(name = "City",nullable = false)
	private String City;

	@Column(name = "Address",nullable = false)
	private String Address;
	
	@Column(name = "State",nullable = false)
	private String State;
	
	@Column(name = "Pincode",nullable = false)
	private String Pincode;
	
	@Column(name = "Country",nullable = false)
	private String Country;
	
	@Column(name = "Phone_Number",nullable = false)
	private String PhoneNumber;
	
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
		builder.append(", City=");
		builder.append(City);
		builder.append(", Address=");
		builder.append(Address);
		builder.append(", State=");
		builder.append(State);
		builder.append(", Country=");
		builder.append(Country);
		builder.append(", Pincode=");
		builder.append(Pincode);
		builder.append(", Phone_Number=");
		builder.append(PhoneNumber);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, City, Country, PhoneNumber, Pincode, State, dateOfBirth, emailId, fullName, gender
				);
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
		return Objects.equals(Address, other.Address) && Objects.equals(City, other.City)
				&& Objects.equals(Country, other.Country) && Objects.equals(PhoneNumber, other.PhoneNumber)
				&& Objects.equals(Pincode, other.Pincode) && Objects.equals(State, other.State)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				;
	}

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

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(String emailId,String fullName, String gender, String dateOfBirth, String city,
			String address, String state, String pincode, String country, String phoneNumber) {
		super();
		this.emailId = emailId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		City = city;
		Address = address;
		State = state;
		Pincode = pincode;
		Country = country;
		PhoneNumber = phoneNumber;
	}
	
	
}