package com.vehicle.rental.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.models.Vehicles;
import com.vehicle.rental.security.services.vehicleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test/")
public class vehicleController {
	
	@Autowired
	private vehicleService vehicleservice;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/vehicles")
	public List<Vehicles> getallvehicles(){
		List<Vehicles> v = vehicleservice.getallvehcles();
		List<Vehicles> x = new ArrayList<>();
		for(Vehicles t : v) {
			if(t.isAvailability()) {
				x.add(t);
			}
		}
		return x;
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/vehicles/{id}")
	public Vehicles getvehicleById(@PathVariable("id") int id) {
		return vehicleservice.getvehicleById(id);
	}
	
	@PostMapping("/vehicles")
	public void saveVehicle(@RequestBody Vehicles vehicle) {
		vehicleservice.saveVehicle(vehicle);
	}
	
	@PutMapping("/vehicles/{id}")
	public void editVehicle(@RequestBody Vehicles vehicle,@PathVariable int id) {
		vehicleservice.editVehicle(vehicle,id);
	}
	
	@DeleteMapping("/vehicles/{id}")
	public void deleteVehicle(@PathVariable("id") int id) {
		vehicleservice.deleteVehicle(id);
	}
	
}
