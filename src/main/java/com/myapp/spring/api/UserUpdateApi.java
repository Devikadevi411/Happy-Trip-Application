package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Registration;
import com.myapp.spring.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/v1/userupdates")
public class UserUpdateApi {
	
	// Dependency Injection
		@Autowired
		private RegistrationRepository repository2;
		
		// http://localhost:8080/api/v1/products
		@GetMapping
		public ResponseEntity<List<Registration>> findAll(){
			
		return new ResponseEntity<List<Registration>>(repository2.findAll(), HttpStatus.OK);
		}
		
		// http://localhost:8080/api/v1/products/45000
			@GetMapping("/findByEmail/{Email_id}")
			public ResponseEntity<List<Registration>> findRegistrationsByEmail
			(@PathVariable("Email_id") String Email_id){
				
			return new ResponseEntity<List<Registration>>
			(repository2.findByEmail(Email_id).get(), HttpStatus.OK);
			}
			
		/*
			// http://localhost:8080/api/v1/products/findByPriceOrName?price=
			@GetMapping("/findByAirlineCodeOrderByFlightName")
			public ResponseEntity<List<FlightNew>> findByOrderByFlightName
			(@RequestParam("flightName") String flightName){
				return new ResponseEntity<List<FlightNew>>
			(repository1.findByAirlineCodeOrderByFlightName(flightName).get(), HttpStatus.OK);
			}
		*/
			
		// http://localhost:8080/api/v1/products
			
		@PostMapping
		public ResponseEntity<Registration> saveNewRegistration(@RequestBody Registration registration){
			
		return new ResponseEntity<Registration>(repository2.save(registration), HttpStatus.CREATED);
		}
		
		@PostMapping("/bulk")
		public ResponseEntity<List<Registration>> bulkRegistrationsInsert
		(@RequestBody List<Registration> registrations){
			
		return new ResponseEntity<List<Registration>>(repository2.saveAll(registrations), 
				HttpStatus.CREATED);
		}
		
		
		// http://localhost:8080/api/v1/products/1
		/*@GetMapping("/{id}")
		public ResponseEntity<FlightNew> findById(@PathVariable("id") Integer id){
			
	return new ResponseEntity<FlightNew>(repository.findById(id).get(), HttpStatus.OK);
		}*/

		
		/*@PutMapping("/{id}")
		public ResponseEntity<FlightNew> updateProduct(@PathVariable("id") Integer id,
				@RequestBody FlightNew flight) throws ResourceNotFoundException{
			FlightNew existingProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException
		    		   ("Product not found for this id :: " + id));
			
			BeanUtils.copyProperties(flight, existingProduct);
			
		return new ResponseEntity<FlightNew>(repository.save(existingProduct), 
				HttpStatus.CREATED);
		}
		
		
		@DeleteMapping("/{id}")
		public Map<String, Boolean> delete(@PathVariable(value = "id") Integer id)
		  throws ResourceNotFoundException {
			FlightNew flight = repository.findById(id)
		       .orElseThrow(() -> new ResourceNotFoundException
		    		   ("Product not found for this id :: " + id));

		    repository.delete(flight);
		     Map<String, Boolean> response = new HashMap<>();
		     response.put("deleted", Boolean.TRUE);
		     return response;
		}
	*/

}
