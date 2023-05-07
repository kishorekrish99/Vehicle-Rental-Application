package com.vehicle.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.models.booking;
import com.vehicle.rental.security.services.BookingService;
import com.vehicle.rental.security.services.vehicleService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class BookController {
	
	@Autowired
	private BookingService bookingservice;
	
	@Autowired
	private vehicleService vehicleservice;
	
	@PostMapping("/book/{username}/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	
	public void book(@PathVariable("username") String username,@PathVariable("id") int id, @RequestBody booking booking) {
		bookingservice.bookvehicle(username,id, booking);
		vehicleservice.disableVehicle(id);
	}
	
	
	@PostMapping("/return/{username}/{id}")
	public void returnvehicle(@PathVariable("username") String username, @PathVariable("id") int id) {
		
		
		
	}
	
	
	
	
}
