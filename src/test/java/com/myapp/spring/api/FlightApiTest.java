package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.FlightNew;
import com.myapp.spring.repository.FlightRepository;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class FlightApiTest {
	
	@MockBean
	private FlightRepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test flight by Id - GET /api/v1/flights/")
	public void testGetFlightsById() throws Exception {
		
		// Prepare Mock Product
		FlightNew flight = new FlightNew( "AirIndia", "Airbus A321", 60);
		flight.setAirlineCode(1);
		
		// Prepare Mock Service Method
		
		doReturn(Optional.of(flight)).when(repository).findById(flight.getAirlineCode());
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights/{airlineCode}",1))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		
		// {"productId":1,
		
		// "productName":"Oneplus",
		
		// "description":"",
		
		// "price":70000,
		
		// "starRating":4.5}
		
		.andExpect(jsonPath("$.airlineCode", is(1)))
		.andExpect(jsonPath("$.airlineName", is("AirIndia")))
		.andExpect(jsonPath("$.flightName", is("Airbus A321")))
		.andExpect(jsonPath("$.flightNumber", is(60)));
		
		
		
	}
	
	@Test
	@DisplayName("Test All Flights /api/v1/flights/")
	public void testGetAllFlights() throws Exception {
		
		// Prepare Mock Product
		FlightNew flight1 = new FlightNew("AirIndia", "Airbus A321", 60);
		flight1.setAirlineCode(475);
		
		FlightNew flight2 = new FlightNew("SpiceJet", "Boeing B321", 40);
		flight2.setAirlineCode(477);
		
		List<FlightNew> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2);
		
		// Prepare Mock Service Method
		
		doReturn(flights).when(repository).findAll();
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].airlineCode", is(475)))
		.andExpect(jsonPath("$[0].airlineName", is("AirIndia")))
		.andExpect(jsonPath("$[0].flightName", is("Airbus A321")))
		.andExpect(jsonPath("$[0].flightNumber", is(60)))
		
		.andExpect(jsonPath("$[1].airlineCode", is(477)))
		.andExpect(jsonPath("$[1].airlineName", is("SpiceJet")))
		.andExpect(jsonPath("$[1].flightName", is("Boeing B321")))
		.andExpect(jsonPath("$[1].flightNumber", is(40)));
		
		
		
		
	}
	
	@Test
	@DisplayName("Test Add New Flight")
	public void testAddNewFlight() throws Exception {
		
		// Prepare Mock Product
		FlightNew newflight = new FlightNew("AirIndia", "Airbus A321", 60);
		
		FlightNew mockflight = new FlightNew("AirIndia", "Airbus A321", 60);
		mockflight.setAirlineCode(475);
		// Prepare Mock Service Method
		
		doReturn(mockflight).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(post("/api/v1/flights")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(newflight)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.airlineCode", is(475)))
		.andExpect(jsonPath("$.airlineName", is("AirIndia")))
		.andExpect(jsonPath("$.flightName", is("Airbus A321")))
		.andExpect(jsonPath("$.flightNumber", is(60)));
		
	}
	
	
	
	@Test
	@DisplayName("Test Update Existing Flight")
	public void testUpdateExistingFlight() throws Exception {
		
		// Prepare Mock Product
		
		FlightNew mockflight = new FlightNew("AirIndia", "Airbus A321", 60);
		
		FlightNew flightToBeUpdated = new FlightNew("AirIndia", "Airbus A321", 60);
		flightToBeUpdated.setAirlineCode(475);
		
		
		mockflight.setAirlineCode(475);
		// Prepare Mock Service Method
		
		doReturn(Optional.of(mockflight)).when(repository).findById(475);
		
		doReturn(mockflight).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(put("/api/v1/flights/{id}",475)
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(flightToBeUpdated)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.airlineCode", is(475)))
		.andExpect(jsonPath("$.airlineName", is("AirIndia")))
		.andExpect(jsonPath("$.flightName", is("Airbus A321")))
		.andExpect(jsonPath("$.flightNumber", is(60)));
		
		
	}
	
	
	
	
	
	@Test
	@DisplayName("Test All Products /api/v1/products/")
	public void testGetAllFlightsSort() throws Exception {
		
		// Prepare Mock Product
		FlightNew flight1 = new FlightNew("AirIndia", "Airbus A321", 60);
		flight1.setAirlineCode(475);
		
		FlightNew flight2 = new FlightNew("SpiceJet", "Boeing B321", 40);
		flight2.setAirlineCode(477);
		
		List<FlightNew> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2);
		
		// Prepare Mock Service Method
		
		//doReturn(Optional.of(flight1)).when(repository).findById(flight1.getAirlineCode());
		//doReturn(Optional.of(flight2)).when(repository).findById(flight2.getAirlineCode());
		doReturn((flights)).when(repository).findAll(Sort.by("flightName"));
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/flights/sortByFlightName"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].airlineCode", is(475)))
		.andExpect(jsonPath("$[0].airlineName", is("AirIndia")))
		.andExpect(jsonPath("$[0].flightName", is("Airbus A321")))
		.andExpect(jsonPath("$[0].flightNumber", is(60)))
		
		.andExpect(jsonPath("$[1].airlineCode", is(477)))
		.andExpect(jsonPath("$[1].airlineName", is("SpiceJet")))
		.andExpect(jsonPath("$[1].flightName", is("Boeing B321")))
		.andExpect(jsonPath("$[1].flightNumber", is(40)));
		
		
		
		
	}
	
	
/*	
	
	*/
	
	
	
	
	
}