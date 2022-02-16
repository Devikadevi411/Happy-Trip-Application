/*package com.myapp.spring.repository;

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

@SpringBootTest
public class RegistrationRepositoryTest {
	
	@Autowired
	private RegistrationRepository repository;
	
	private static File DATA_JSON= Paths.get("src","test","resources","registration.json").toFile();
	
	
	@BeforeEach
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		
		Registration regdetails[]=new ObjectMapper().readValue(DATA_JSON, regdetails[].class);
	// save each product to database
	Arrays.stream(Registration).forEach(repository::save);	
		
		
	}
	
	@AfterEach
	public void cleanUp() {
		repository.deleteAll();
		
	}
	
	@Test
	@DisplayName("Test product not found for a non existing id")
	public void testProductNotFoundForNonExistingId() {
		
		// given three products in the database
		
		// when we retrieve a product using non existing id
		Registration reg1=repository.findById(100).orElseGet(()-> new reg1());
		
		// Then perform Assert Conditions To validate
		Assertions.assertNull(reg1.getProductId(), 
				"Product With Id 100 should not exist");
		
		}
	
	
	@Test
	@DisplayName("Test product saved sucessfully")
	public void testProductSavedSucessfully() {
		
		// given a mock product
		Registration reg1 = new reg1("Vivo", "Vivo12Pro", 37545.0, 3.9);
		reg1.setemailId(5);
		
		// when we retrieve a product using non existing id
		reg1 savedreg1=repository.save(reg1);
		
		// Then perform Assert Conditions To validate
		Assertions.assertNotNull(savedreg1, 
				"New Product should be saved");
		
		Assertions.assertNotNull(savedreg1.getProductId(), 
				"New Product should have id");
		Assertions.assertEquals(product.getProductName(), 
				savedreg1.getProductName());
		
		
		}
	
	@Test
	@DisplayName("Test product updated sucessfully")
	public void testProductUpdatedSucessfully() {
		
		// given a mock product
		Registration reg1 = new Registration("devikadevi","female","27-04-1999","devika","1244545");
		reg1.setProductId(1);
		
		// when we retrieve a product using non existing id
		Product updatedProduct=repository.save(reg1);
		
		
		Assertions.assertEquals(reg1.getPrice(), 
				updatedProduct.getPrice());
		
		
		}
	

}*/
