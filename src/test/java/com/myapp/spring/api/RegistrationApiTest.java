package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.Registration;
import com.myapp.spring.repository.RegistrationRepository;

//import java.util.List;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class RegistrationApiTest {
	
	@MockBean
	private RegistrationRepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Test Registrationdetails by emailId - GET /api/v1/reg/")
	public void testGetRegistrationdetailsByemailId() throws Exception {
		
		// Prepare Mock Registrationdetails
		Registration Registrationdetails = new Registration("devikadevi2704@gmail.com","devika1234","G.Devika","female","27-04-1999");
		Registrationdetails.setEmailId("devikadevi2704@gmail.com");
		
		// Prepare Mock Service Method
		
		doReturn(Optional.of(Registrationdetails)).when(repository).findById(Registrationdetails.getEmailId());
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reg/{emailId}","devikadevi2704@gmail.com"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		
		// {"RegistrationdetailsId":1,
		
		// "RegistrationdetailsName":"Oneplus",
		
		// "description":"",
		
		// "price":70000,
		
		// "starRating":4.5}
		
		.andExpect(jsonPath("$.emailId", is("devikadevi2704@gmail.com")))
		.andExpect(jsonPath("$.dateOfBirth", is("27-04-1999")))
		.andExpect(jsonPath("$.fullName", is("G.Devika")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.password", is("devika1234")));
		
		
	}
	
	
	
	
	
	
	@Test
	@DisplayName("Test Add New Registrationdetails")
	public void testAddNewRegistrationdetails() throws Exception {
		
		// Prepare Mock Registrationdetails
		Registration newRegistrationdetails= new Registration ("devikadevi2704@gmail.com","devika1234","G.Devika","female","27-04-1999");
		
		Registration  mockRegistrationdetails = new Registration ("devikadevi2704@gmail.com","devika1234","G.Devika","female","27-04-1999");
		mockRegistrationdetails.setEmailId("devikadevi2704@gmail.com");
		// Prepare Mock Service Method
		
		doReturn(mockRegistrationdetails).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(post("/api/v1/reg")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(newRegistrationdetails)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.emailId", is("devikadevi2704@gmail.com")))
		.andExpect(jsonPath("$.dateOfBirth", is("27-04-1999")))
		.andExpect(jsonPath("$.fullName", is("G.Devika")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.password", is("devika1234")));
		
		
	}
	
	

}