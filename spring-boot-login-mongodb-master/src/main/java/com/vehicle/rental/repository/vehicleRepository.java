package com.vehicle.rental.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.rental.models.Vehicles;

@Repository
public interface vehicleRepository extends MongoRepository<Vehicles, Integer>{
		
	
}
