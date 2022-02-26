package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration {

	@Id
	@Column(name = "email_id1",nullable = false)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String emailId1;
	
	@Column(name = "password1",nullable = false)
	private String password1;
	
	@Column(name = "full_name1",nullable = false)
	private String fullName1;
	
	@Column(name = "gender1",nullable = false)
	private String gender1;
	
	@Column(name = "date_of_birth1",nullable = false)
	private String dateOfBirth1;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String emailId, String password, String fullName, String gender, String dateOfBirth) {
		super();
		this.emailId1 = emailId;
		this.password1 = password;
		this.fullName1 = fullName;
		this.gender1 = gender;
		this.dateOfBirth1 = dateOfBirth;
	}

	public String getEmailId() {
		return emailId1;
	}

	public void setEmailId(String emailId) {
		this.emailId1 = emailId;
	}

	public String getPassword() {
		return password1;
	}

	public void setPassword(String password) {
		this.password1 = password;
	}

	public String getFullName() {
		return fullName1;
	}

	public void setFullName(String fullName) {
		this.fullName1 = fullName;
	}

	public String getGender() {
		return gender1;
	}

	public void setGender(String gender) {
		this.gender1 = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth1;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth1 = dateOfBirth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth1, emailId1, fullName1, gender1, password1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(dateOfBirth1, other.dateOfBirth1) && Objects.equals(emailId1, other.emailId1)
				&& Objects.equals(fullName1, other.fullName1) && Objects.equals(gender1, other.gender1)
				&& Objects.equals(password1, other.password1);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registration [emailId=");
		builder.append(emailId1);
		builder.append(", password=");
		builder.append(password1);
		builder.append(", fullName=");
		builder.append(fullName1);
		builder.append(", gender=");
		builder.append(gender1);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth1);
		builder.append("]");
		return builder.toString();
	}
	
	
}