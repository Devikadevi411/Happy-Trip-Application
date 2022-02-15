package com.myapp.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
	
	// select * from NewFlights where UPPER(productName) = UPPER(?1)
//Optional<List<FlightNew>> findByPriceGreaterThanEqual(Integer airlineCode);
	
	Optional<List<Registration>> findByEmail(String Email_id);
	
	//Optional<List<Registration>> findByAirlineCodeOrderByFlightName(String flightName);

	//Optional<List<Registration>> findByProductNameLike(String productName);
	
	//Optional<List<Registration>> findByPriceIn(Collection<Double> prices);
	
	//Optional<List<Registration>> findByProductNameIgnoreCase(String productName);
	
}