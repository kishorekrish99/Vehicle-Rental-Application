package com.vehicle.rental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.models.User;
import com.vehicle.rental.security.services.userService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/test")
public class UsersController {
	
	@Autowired
	private userService userservice;
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> getusers(){
		List<User> users = userservice.getusers();
		return users;
	}
	
	@GetMapping("/users/{username}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public User getuser(@PathVariable("username") String username) {
		return userservice.getuser(username);
	}
	
	@DeleteMapping("/users/{username}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public void deleteuser(@PathVariable("username") String username) {
		User u = userservice.getuser(username);
		userservice.deleteuser(u);
	}
	
	
}
