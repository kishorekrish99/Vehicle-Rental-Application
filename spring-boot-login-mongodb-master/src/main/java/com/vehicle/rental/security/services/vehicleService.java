package com.vehicle.rental.security.services;

import java.util.List;

import com.vehicle.rental.models.Vehicles;

public interface vehicleService {

	public List<Vehicles> getallvehcles();

	public Vehicles getvehicleById(int id);

	public void saveVehicle(Vehicles vehicle);

	public void deleteVehicle(int id);

	public void disableVehicle(int id);

	public void editVehicle(Vehicles vehicle, int id);

	public void disablecar(int id);

	
	
}
