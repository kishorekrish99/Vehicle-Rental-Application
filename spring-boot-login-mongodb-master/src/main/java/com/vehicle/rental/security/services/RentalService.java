package com.vehicle.rental.security.services;

import java.util.List;

import com.vehicle.rental.models.rentaltransaction;

public interface RentalService {

	public List<rentaltransaction> getalltransaction(String username);

	

	public void saveTransaction(rentaltransaction rt);



	public void returnvehicle(String username, int id, rentaltransaction rt);

}
