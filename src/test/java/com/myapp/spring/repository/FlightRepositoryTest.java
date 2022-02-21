package com.myapp.spring.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Product;
import com.myapp.spring.model.FlightNew;


@SpringBootTest
public class FlightRepositoryTest {
	
	@Autowired
	private FlightRepository repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","flights.json").toFile();
	
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
	FlightNew flights[]=new ObjectMapper().readValue(DATA_JSON, FlightNew[].class);
	
	// save each product to database
	Arrays.stream(flights).forEach(repository::save);	
		
		
	}
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	@Test
	@DisplayName("Test product not found for a non existing id")
	public void testFlightNotFoundForNonExistingId() {
		
		// given three products in the database
		
		// when we retrieve a product using non existing id
		FlightNew flight=repository.findById(479).orElseGet(()-> new FlightNew());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(flight.getAirlineCode(), 
				"Product With Id 479 should not exist");
		
		}
	
	
	@Test
	@DisplayName("Test product saved sucessfully")
	public void testFlightSavedSucessfully() {
		
		// given a mock product
		FlightNew flight = new FlightNew("AirIndia", "Airbus A322", 66);
		flight.setAirlineCode(479);
		
		// when we retrieve a product using non existing id
		FlightNew savedFlight=repository.save(flight);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedFlight, 
				"New Product should be saved");
		
		Assertions.assertNotNull(savedFlight.getAirlineCode(), 
				"New Product should have id");
		Assertions.assertEquals(flight.getFlightName(), 
				savedFlight.getFlightName());
		
		
		}
	
	@Test
	@DisplayName("Test flight updated sucessfully")
	public void testFlightUpdatedSucessfully() {
		
		// given a mock product
		FlightNew flight = new FlightNew("AirIndia", "Airbus A111", 66);
		flight.setAirlineCode(479);
		
		// when we retrieve a product using non existing id
		FlightNew updatedFlight=repository.save(flight);
		
		
		Assertions.assertEquals(flight.getFlightName(), 
				updatedFlight.getFlightName());
		
		
		}
	

}
