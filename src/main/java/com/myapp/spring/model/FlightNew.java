package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newflights")
public class FlightNew {

	@Id
	@Column(name = "airline_code",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer airlineCode;
	
	@Column(name = "airline_name",nullable = false)
	private String airlineName;
	
	
	@Column(name = "flight_name",nullable = false)
	private String flightName;
	
	@Column(name = "flight_number",nullable = false)
	private Integer flightNumber;
	


	public FlightNew() {
	
		// TODO Auto-generated constructor stub
	}


	public FlightNew(String airlineName, String flightName, Integer flightNumber) {
		super();
		
		this.airlineName = airlineName;
		this.flightName = flightName;
		this.flightNumber = flightNumber;
	}


	public Integer getAirlineCode() {
		return airlineCode;
	}


	public void setAirlineCode(Integer airlineCode) {
		this.airlineCode = airlineCode;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public Integer getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(airlineCode, airlineName, flightName, flightNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightNew other = (FlightNew) obj;
		return Objects.equals(airlineCode, other.airlineCode) && Objects.equals(airlineName, other.airlineName)
				&& Objects.equals(flightName, other.flightName) && Objects.equals(flightNumber, other.flightNumber);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FlightNew [airlineCode=");
		builder.append(airlineCode);
		builder.append(", airlineName=");
		builder.append(airlineName);
		builder.append(", flightName=");
		builder.append(flightName);
		builder.append(", flightNumber=");
		builder.append(flightNumber);
		builder.append("]");
		return builder.toString();
	}
	


	
	
}
