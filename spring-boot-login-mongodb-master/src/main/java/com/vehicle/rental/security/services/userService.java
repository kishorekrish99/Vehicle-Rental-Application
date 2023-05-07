package com.vehicle.rental.security.services;

import java.util.List;

import com.vehicle.rental.models.User;

public interface userService {

	public List<User> getusers();

	public User getuser(String username);

	public void deleteuser(User u);

}
