package com.myapp.spring.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @Column(name = "Email_id",nullable = false)
    private String Email_id ;
    
    
    @Column(name = "full_name",nullable = false)
    private String full_name ;
    
    
    @Column(name = "password",nullable = false)
    private String password;
    
    @Column(name = "gender",nullable = false)
    private String gender;
    
    @Column(name = "date_of_birth",nullable = false)
    private String date_of_birth;
    
    
    public Registration() {
        // TODO Auto-generated constructor stub
    }


	public Registration(String email_id, String full_name, String password, String gender, String date_of_birth) {
		super();
		Email_id = email_id;
		this.full_name = full_name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
	}


	public String getEmail_id() {
		return Email_id;
	}


	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}


	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Email_id, date_of_birth, full_name, gender, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Registration))
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(Email_id, other.Email_id) && Objects.equals(date_of_birth, other.date_of_birth)
				&& Objects.equals(full_name, other.full_name) && Objects.equals(gender, other.gender)
				&& Objects.equals(password, other.password);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registration [Email_id=");
		builder.append(Email_id);
		builder.append(", full_name=");
		builder.append(full_name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", date_of_birth=");
		builder.append(date_of_birth);
		builder.append("]");
		return builder.toString();
	}
    
    
}
    