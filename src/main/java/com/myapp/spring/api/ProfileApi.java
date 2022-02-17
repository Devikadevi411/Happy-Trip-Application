package com.myapp.spring.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Profile;
import com.myapp.spring.repository.ProfileRepository;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileApi {

	
	// Dependency Injection
		@Autowired
		private ProfileRepository repository;
		
		// http://localhost:8080/api/v1/products
		@GetMapping
		public ResponseEntity<List<Profile>> findAll(){
			
		return new ResponseEntity<List<Profile>>(repository.findAll(), HttpStatus.OK);
		}
		
		// http://localhost:8080/api/v1/products/45000
			 /* @GetMapping("/findByEmailId/{emailId}")
			public ResponseEntity<List<Profile>> findUserByEmailId
			(@PathVariable("emailId") String emailId){
				
			return new ResponseEntity<List<Profile>>
			(repository.findByEmailId(emailId).get(), HttpStatus.OK);
			} */
			
			/*
			// http://localhost:8080/api/v1/products/findByPriceOrName?price=
			@GetMapping("/findByPriceOrName")
			public ResponseEntity<List<Product>> findProductsByPriceOrName
			(@RequestParam("price") Optional<Double> price,
					@RequestParam("productName") Optional<String> productName){
				return new ResponseEntity<List<Product>>
			(repository.findByProductNameOrPrice(productName.orElse(""), price.orElse(0.0)).get(), HttpStatus.OK);
			}*/
		
		// http://localhost:8080/api/v1/products
		@PostMapping
		public ResponseEntity<Profile> saveProfileDetails(@RequestBody Profile Profiles){
			
		return new ResponseEntity<Profile>(repository.save(Profiles), HttpStatus.CREATED);
		}
		
		@PutMapping("/{emailId}")
        public ResponseEntity<Profile> updateProduct(@PathVariable("emailId") String emailId,
                @RequestBody Profile reg) throws ResourceNotFoundException{
            Profile existingProduct = repository.findById(emailId).orElseThrow(() -> new ResourceNotFoundException
                       ("Product not found for this id :: " + emailId));
            
            BeanUtils.copyProperties(reg, existingProduct);
            
        return new ResponseEntity<Profile>(repository.save(existingProduct), 
                HttpStatus.CREATED);
        }
		/*
		@PostMapping("/bulk")
		public ResponseEntity<List<Product>> bulkProductsInsert
		(@RequestBody List<Product> products){
			
		return new ResponseEntity<List<Product>>(repository.saveAll(products), 
				HttpStatus.CREATED);
		}
		
		
		// http://localhost:8080/api/v1/products/1
		@GetMapping("/{id}")
		public ResponseEntity<Product> findById(@PathVariable("id") Integer id){
			
	return new ResponseEntity<Product>(repository.findById(id).get(), HttpStatus.OK);
		} */

		
		/* @PutMapping("/{id}")
		public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id,
				@RequestBody Product product) throws ResourceNotFoundException{
			Product existingProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException
		    		   ("Product not found for this id :: " + id));
			
			BeanUtils.copyProperties(product, existingProduct);
			
		return new ResponseEntity<Product>(repository.save(existingProduct), 
				HttpStatus.CREATED);
		} */
		
}