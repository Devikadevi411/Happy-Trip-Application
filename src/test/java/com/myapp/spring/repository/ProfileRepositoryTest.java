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
import com.myapp.spring.model.Profile;


@SpringBootTest
public class ProfileRepositoryTest {
	
	@Autowired
	private ProfileRepository repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","profile.json").toFile();
	
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
		Profile Profiledetails[]=new ObjectMapper().readValue(DATA_JSON, Profile[].class);
	// save each product to database
	Arrays.stream(Profiledetails).forEach(repository::save);	
		
		
	}
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	 @Test
	@DisplayName("Test regdeatils found for a non existing emilid")
	public void testProfileFoundFornonExistingemailId() {
		
		// given three products in the database
		
		// when we retrieve a product using non existing id
		Profile Profiledetails=repository.findById("ujjainee@gmail.com").orElseGet(()-> new Profile());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(Profiledetails.getEmailId(), 
				"Product With emailId ");
		
		}
	
	
	@Test
	@DisplayName("Test product saved sucessfully")
	public void testProfiledetialsSavedSucessfully() {
		
		// given a mock product
		Profile Profiledetails = new Profile("gowthamikummara99@gmail.com","GowthamiKummara","female","02-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		Profiledetails.setEmailId("gowthamikummara99@gmail.com");
		
		// when we retrieve a product using non existing id
		Profile savedProfiledetails=repository.save(Profiledetails);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedProfiledetails, 
				"New Product should be saved");
		
		Assertions.assertNotNull(savedProfiledetails.getEmailId(), 
				"New Product should have emailId");
		Assertions.assertEquals(Profiledetails.getFullName(), 
				savedProfiledetails.getFullName());
		
		
		}
	
	@Test
	@DisplayName("Test product updated sucessfully")
	public void testProductUpdatedSucessfully() {
		
		// given a mock product
		Profile Profiledetails = new Profile("gowthamikummara99@gmail.com","GowthamiKummara","female","08-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		Profiledetails.setEmailId("gowthamikummara99@gmail.com");
		
		// when we retrieve a product using non existing id
		Profile updatedProfiledetails=repository.save(Profiledetails);
		
		
		Assertions.assertEquals(Profiledetails.getEmailId(), 
				updatedProfiledetails.getEmailId());
		
		
		}

}