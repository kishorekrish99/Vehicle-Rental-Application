package com.vehicle.rental.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vehicle.rental.models.cards;

public interface cardsRepository extends MongoRepository<cards, Integer> {

}
