package com.vehicle.rental.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.models.rentaltransaction;
import com.vehicle.rental.security.services.RentalService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test/")
public class RentalController {
	
	@Autowired
	private RentalService rentalservice;
	
	@GetMapping("/rental/{username}")
	 @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<rentaltransaction> getalltransactions(@PathVariable String username){
		List<rentaltransaction> usertrans =  rentalservice.getalltransaction(username);
		List<rentaltransaction> userprevtrans = new ArrayList<>();
		for(rentaltransaction r : usertrans) {
			if(!r.isActive()) {
				userprevtrans.add(r);
			}
		}
		return userprevtrans;
	}
	
	@GetMapping("/rental/active/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<rentaltransaction> getActiveTransactions(@PathVariable String username){
		List<rentaltransaction> usertrans= rentalservice.getalltransaction(username);
		List<rentaltransaction> useractivetrans = new ArrayList<>();
		for(rentaltransaction r : usertrans) {
			if(r.isActive()) {
				useractivetrans.add(r);
			}
		}
		 return useractivetrans;
	}
	
	@PostMapping("/rental")
	public void saveTranscation(@RequestBody rentaltransaction rt) {
		rentalservice.saveTransaction(rt);
	}
	
	//username return
	@PostMapping("/rental/return/{username}/{id}")
	public void returnVehicle(@PathVariable String username, @PathVariable int id,@RequestBody rentaltransaction rt) {
		rentalservice.returnvehicle(username,id,rt);
	}
}
