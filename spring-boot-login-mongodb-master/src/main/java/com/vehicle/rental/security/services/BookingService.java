package com.vehicle.rental.security.services;

import com.vehicle.rental.models.booking;

public interface BookingService {

	

	public void bookvehicle(String username, int id, booking booking);

}
