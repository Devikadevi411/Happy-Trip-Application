package com.myapp.spring.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.myapp.spring.model.Profile;
import com.myapp.spring.repository.ProfileRepository;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class ProfileApiTest {
	
	@MockBean
	private ProfileRepository repository;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	@DisplayName("Test Profiledetails by emailId - GET /api/v1/profile/")
	public void testGetProfiledetailsByemailId() throws Exception {
		
		// Prepare Mock Profiledetails
		Profile profiledetails = new Profile("gowthamikummara99@gmail.com","GowthamiKummara","female","02-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		profiledetails.setEmailId("gowthamikummara99@gmail.com");
		
		// Prepare Mock Service Method
		
		doReturn(Optional.of(profiledetails)).when(repository).findById(profiledetails.getEmailId());
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/profile/{id}","gowthamikummara99@gmail.com"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		
		// {"ProfiledetailsId":1,
		
		// "ProfiledetailsName":"Oneplus",
		
		// "description":"",
		
		// "price":70000,
		
		// "starRating":4.5}
		
		.andExpect(jsonPath("$.emailId", is("gowthamikummara99@gmail.com")))
		.andExpect(jsonPath("$.fullName", is("GowthamiKummara")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.dateOfBirth", is("02-05-1999")))
		.andExpect(jsonPath("$.address", is("Palamaner")))
		.andExpect(jsonPath("$.city", is("Chittoor")))
		.andExpect(jsonPath("$.state", is("AndhraPradesh")))
		.andExpect(jsonPath("$.country", is("India")))
		.andExpect(jsonPath("$.pinCode", is("517408")))
		.andExpect(jsonPath("$.phoneNumber", is("6309648757")));
		
		
		
	}
	
	/*@Test
	@DisplayName("Test All Profiledetailss /api/v1/reg/")
	public void testGetAllProfiledetailss() throws Exception {
		
		// Prepare Mock Profiledetails
		Profile Profiledetails1 = new Profile("devikadevi2704@gmail.com", "27-04-1999","G.Devika","female","devika1234");
		Profiledetails1.setEmailId("devikadevi2704@gmail.com");
		
		Profile Profiledetails2 = new Profile("pragathi@gmail.com", "2-01-1998","pragathi","female","pragathi1234");
		Profiledetails2.setEmailId("pragathi@gmail.com");
		
		List<Profile> Profiledetails = new ArrayList<>();
		Profiledetails.add(Profiledetails1);
		Profiledetails.add(Profiledetails2);
		
		// Prepare Mock Service Method
		
		doReturn(Profiledetails).when(repository).findAll();
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/Profiledetailss"))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$.emailId", is("devikadevi2704@gmail.com")))
		.andExpect(jsonPath("$.dateOfBirth", is("27-04-1999")))
		.andExpect(jsonPath("$.fullName", is("G.Devika")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.password", is("devika1234")))
		
		.andExpect(jsonPath("$.emailId", is("pragathi@gmail.com")))
		.andExpect(jsonPath("$.dateOfBirth", is("2-01-1998")))
		.andExpect(jsonPath("$.fullName", is("pragathi")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.password", is("pragathi1234")));
		
		
		
		
		
	}
	
	@Test
	@DisplayName("Test All Profiledetailss By Price /api/v1/Profiledetailss/{price}")
	public void testGetAllProfiledetailssByPrice() throws Exception {
		
		// Prepare Mock Profiledetails
		Profiledetails Profiledetails1 = new Profiledetails("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		Profiledetails1.setProfiledetailsId(35);
		
		Profiledetails Profiledetails2 = new Profiledetails("Oneplus", "OnePlus8Pro", 60000.00, 4.5);
		Profiledetails2.setProfiledetailsId(36);
		
		Profiledetails Profiledetails3 = new Profiledetails("Iphone", "Iphone12", 80000.00, 4.5);
		Profiledetails3.setProfiledetailsId(37);
		
		List<Profiledetails> Profiledetailss = new ArrayList<>();
		Profiledetailss.add(Profiledetails1);
		Profiledetailss.add(Profiledetails2);
		Profiledetailss.add(Profiledetails3);
		
		// Prepare Mock Service Method
		double price =50000.00;
		
		doReturn(Optional.of(Profiledetailss)).when(repository)
		.findByPriceGreaterThanEqual(price);
		
		// Perform GET Request
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/Profiledetailss/findByPrice/{price}",price))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].ProfiledetailsId", is(35)))
		.andExpect(jsonPath("$[0].ProfiledetailsName", is("Oneplus")))
		.andExpect(jsonPath("$[0].description", is("OnePlus9Pro")))
		.andExpect(jsonPath("$[0].price", is(70000.00)))
		.andExpect(jsonPath("$[0].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[1].ProfiledetailsId", is(36)))
		.andExpect(jsonPath("$[1].ProfiledetailsName", is("Oneplus")))
		.andExpect(jsonPath("$[1].description", is("OnePlus8Pro")))
		.andExpect(jsonPath("$[1].price", is(60000.00)))
		.andExpect(jsonPath("$[1].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[2].ProfiledetailsId", is(37)))
		.andExpect(jsonPath("$[2].ProfiledetailsName", is("Iphone")))
		.andExpect(jsonPath("$[2].description", is("Iphone12")))
		.andExpect(jsonPath("$[2].price", is(80000.00)))
		.andExpect(jsonPath("$[2].starRating", is(4.5)));
		
		
	}
	
	@Test
	@DisplayName("Test All Profiledetailss By Price /api/v1/Profiledetailss?name=&price")
	public void testGetAllProfiledetailssByNameOrPrice() throws Exception {
		
		// Prepare Mock Profiledetails
		Profiledetails Profiledetails1 = new Profiledetails("Oneplus", "OnePlus9Pro", 70000.00, 4.5);
		Profiledetails1.setProfiledetailsId(35);
		
		Profiledetails Profiledetails2 = new Profiledetails("Oneplus", "OnePlus8Pro", 60000.00, 4.5);
		Profiledetails2.setProfiledetailsId(36);
		
		
		
		List<Profiledetails> Profiledetailss = new ArrayList<>();
		Profiledetailss.add(Profiledetails1);
		Profiledetailss.add(Profiledetails2);
		
		
		// Prepare Mock Service Method
		Double price =50000.00;
		String ProfiledetailsName="Oneplus";
		
		doReturn(Optional.of(Profiledetailss)).when(repository)
		.findByProfiledetailsNameOrPrice(ProfiledetailsName, price);
		
		
		// Perform GET Request
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/Profiledetailss/findByPriceOrName")
				.queryParam("ProfiledetailsName",ProfiledetailsName)
				.queryParam("price", price.toString()))
		// Validate Status should be 200 OK and JSON response received
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		
		// Validate Response Body
		
		.andExpect(jsonPath("$[0].ProfiledetailsId", is(35)))
		.andExpect(jsonPath("$[0].ProfiledetailsName", is("Oneplus")))
		.andExpect(jsonPath("$[0].description", is("OnePlus9Pro")))
		.andExpect(jsonPath("$[0].price", is(70000.00)))
		.andExpect(jsonPath("$[0].starRating", is(4.5)))
		
		.andExpect(jsonPath("$[1].ProfiledetailsId", is(36)))
		.andExpect(jsonPath("$[1].ProfiledetailsName", is("Oneplus")))
		.andExpect(jsonPath("$[1].description", is("OnePlus8Pro")))
		.andExpect(jsonPath("$[1].price", is(60000.00)))
		.andExpect(jsonPath("$[1].starRating", is(4.5)));
		
		
		
		
	}*/
	
	
	
	
	@Test
	@DisplayName("Test Add New Profiledetails")
	public void testAddNewProfiledetails() throws Exception {
		
		// Prepare Mock Profiledetails
		Profile newProfiledetails= new Profile ("gowthamikummara99@gmail.com","GowthamiKummara","female","02-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		
		Profile  mockProfiledetails = new Profile ("gowthamikummara99@gmail.com","GowthamiKummara","female","02-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		mockProfiledetails.setEmailId("gowthamikummara99@gmail.com");
		// Prepare Mock Service Method
		
		doReturn(mockProfiledetails).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(post("/api/v1/profile")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(newProfiledetails)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.emailId", is("gowthamikummara99@gmail.com")))
		.andExpect(jsonPath("$.fullName", is("GowthamiKummara")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.dateOfBirth", is("02-05-1999")))
		.andExpect(jsonPath("$.address", is("Palamaner")))
		.andExpect(jsonPath("$.city", is("Chittoor")))
		.andExpect(jsonPath("$.state", is("AndhraPradesh")))
		.andExpect(jsonPath("$.country", is("India")))
		.andExpect(jsonPath("$.pinCode", is("517408")))
		.andExpect(jsonPath("$.phoneNumber", is("6309648757")));
		
		
	}
	
	@Test
	@DisplayName("Test Update Existing Profiledetails")
	public void testUpdateExistingProfiledetails() throws Exception {
		
		// Prepare Mock Profiledetails
		
		Profile mockProfiledetails = new Profile("gowthamikummara99@gmail.com","GowthamiKummara","female","08-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		
		Profile ProfiledetailsToBeUpdated = new Profile("gowthamikummara99@gmail.com","GowthamiKummara","female","08-05-1999","Palamaner","Chittoor","AndhraPradesh","India","517408","6309648757");
		ProfiledetailsToBeUpdated.setEmailId("gowthamikummara99@gmail.com");
		
		
		mockProfiledetails.setEmailId("gowthamikummara99@gmail.com");
		// Prepare Mock Service Method
		
		doReturn(Optional.of(mockProfiledetails)).when(repository).findById("gowthamikummara99@gmail.com");
		
		doReturn(mockProfiledetails).when(repository).save(ArgumentMatchers.any());
		
		// Perform GET Request
		
		mockMvc.perform(put("/api/v1/profile/{emailId}","gowthamikummara99@gmail.com")
		// Validate Status should be 200 OK and JSON response received
		
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.content(new ObjectMapper().writeValueAsString(ProfiledetailsToBeUpdated)))
		
		
		// Validate Response Body
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.emailId", is("gowthamikummara99@gmail.com")))
		.andExpect(jsonPath("$.fullName", is("GowthamiKummara")))
		.andExpect(jsonPath("$.gender", is("female")))
		.andExpect(jsonPath("$.dateOfBirth", is("08-05-1999")))
		.andExpect(jsonPath("$.address", is("Palamaner")))
		.andExpect(jsonPath("$.city", is("Chittoor")))
		.andExpect(jsonPath("$.state", is("AndhraPradesh")))
		.andExpect(jsonPath("$.country", is("India")))
		.andExpect(jsonPath("$.pinCode", is("517408")))
		.andExpect(jsonPath("$.phoneNumber", is("6309648757")));
		
		
	}
	

}