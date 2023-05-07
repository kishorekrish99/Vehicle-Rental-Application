package com.vehicle.rental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.models.cards;
import com.vehicle.rental.security.services.cardsService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test/")
public class CardsController {
	
	@Autowired
	private cardsService cardservice;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/cards/{username}")
	public List<Object> getallcard(@PathVariable("username") String username){
		return cardservice.getcards(username);
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("/cards/{username}")
	public Long saveCards(@RequestBody cards card,@PathVariable String username) {
		return cardservice.saveCards(card, username);
	}
	
	@DeleteMapping("/cards/{id}")
	public void deleteCards(@PathVariable("id") int id){
		cardservice.deletecard(id);
	}
	
	
}