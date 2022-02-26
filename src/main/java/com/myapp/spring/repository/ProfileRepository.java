package com.myapp.spring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Profile;

// This is a data repository class
@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
	
	// select * from devopsproducts where UPPER(productName) = UPPER(?1)
//Optional<List<Product>> findByPriceGreaterThanEqual(Double price);
	
	Optional<List<Profile>> findByEmailId(String emailId);

	//Optional<List<Product>> findByProductNameLike(String productName);
	
	//Optional<List<Product>> findByPriceIn(Collection<Double> prices);
	
	//Optional<List<Product>> findByProductNameIgnoreCase(String productName);
	
}