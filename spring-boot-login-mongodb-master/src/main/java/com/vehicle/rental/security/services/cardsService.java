package com.vehicle.rental.security.services;

import java.util.List;

import com.vehicle.rental.models.cards;

public interface cardsService {

	public Long saveCards(cards card, String username);


	public void deletecard(int id);

	public List<Object> getcards(String username);

}
