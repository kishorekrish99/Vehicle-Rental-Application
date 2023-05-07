package com.vehicle.rental.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vehicle.rental.models.User;
import com.vehicle.rental.models.rentaltransaction;

public interface RentalRepository extends MongoRepository<rentaltransaction, Integer> {
	User findByUsername(String username);

}
