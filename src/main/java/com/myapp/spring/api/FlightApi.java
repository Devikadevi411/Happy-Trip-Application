package com.myapp.spring.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.FlightNew;
import com.myapp.spring.model.Product;
import com.myapp.spring.repository.FlightRepository;


// This is a Class Which exposes Rest API's
@RestController
@RequestMapping("/api/v1/flights")
public class FlightApi {
	
	// Dependency Injection
	@Autowired
	private FlightRepository repository1;
	
	// http://localhost:8080/api/v1/flights
	@GetMapping
	public ResponseEntity<List<FlightNew>> findAll(){
		
	return new ResponseEntity<List<FlightNew>>(repository1.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightNew> findById(@PathVariable("id") Integer id){
		
		return new ResponseEntity<FlightNew>(repository1.findById(id).get(), HttpStatus.OK);
	}
	
	// http://localhost:8080/api/v1/products/sortByFlightName
		@GetMapping("/sortByFlightName")
		public ResponseEntity<List<FlightNew>> findByFlightName
		(){
			return new ResponseEntity<List<FlightNew>>
		(repository1.findAll(Sort.by("flightName")), HttpStatus.OK);
		}
		
	// http://localhost:8080/api/v1/products
		
	@PostMapping
	public ResponseEntity<FlightNew> saveNewFlight(@RequestBody FlightNew flight){
		
	return new ResponseEntity<FlightNew>(repository1.save(flight), HttpStatus.CREATED);
	}
	
	/*@PostMapping("/bulk")
	public ResponseEntity<List<FlightNew>> bulkFlightsInsert
	(@RequestBody List<FlightNew> flights){
		
	return new ResponseEntity<List<FlightNew>>(repository1.saveAll(flights), 
			HttpStatus.CREATED);
	}
	
	*/
	
	// http://localhost:8080/api/v1/products/1
	

	
	@PutMapping("/{id}")
	public ResponseEntity<FlightNew> updateFlight(@PathVariable("id") Integer id,
			@RequestBody FlightNew flight) throws ResourceNotFoundException{
		FlightNew existingFlight = repository1.findById(id).orElseThrow(() -> new ResourceNotFoundException
	    		   ("Flight not found for this code :: " + id));
		
		BeanUtils.copyProperties(flight, existingFlight);
		
	return new ResponseEntity<FlightNew>(repository1.save(existingFlight), 
			HttpStatus.CREATED);
	}	

}