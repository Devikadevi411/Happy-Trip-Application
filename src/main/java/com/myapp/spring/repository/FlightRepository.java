package com.myapp.spring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.FlightNew;

// This is a data repository class
@Repository
public interface FlightRepository extends JpaRepository<FlightNew, Integer> {
	
	// select * from NewFlights where UPPER(productName) = UPPER(?1)
//Optional<List<FlightNew>> findByPriceGreaterThanEqual(Integer airlineCode);
	
	Optional<List<FlightNew>> findByAirlineCode(Integer airlineCode);
	
	//Optional<List<FlightNew>> findByAirlineCodeOrderByFlightName(String flightName);

	//Optional<List<FlightNew>> findByProductNameLike(String productName);
	
	//Optional<List<FlightNew>> findByPriceIn(Collection<Double> prices);
	
	//Optional<List<FlightNew>> findByProductNameIgnoreCase(String productName);
	
}
