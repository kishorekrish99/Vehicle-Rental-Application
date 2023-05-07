package com.vehicle.rental.security.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.rental.models.User;
import com.vehicle.rental.models.Vehicles;
import com.vehicle.rental.models.booking;
import com.vehicle.rental.models.rentaltransaction;
import com.vehicle.rental.repository.RentalRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private RentalRepository rentalrepository;
	
	@Autowired
	private vehicleService vehicleservice;
	
	@Autowired
	private userService userservice;
	
	@Override
	public void bookvehicle(String username, int id,booking booking) {
		
		Vehicles v= vehicleservice.getvehicleById(id);
		System.out.println(v);
		
		
		
		User u = userservice.getuser(username);
		
		
		rentaltransaction rt = new rentaltransaction();
		rt.setActive(true);
		rt.setAmount(v.getPrice());
		if(u.getAge()<25 )
		rt.setDiscount(10);
		else
			rt.setDiscount(20);
		
		rt.setModel(booking.getModel());
		rt.setPickupdate(booking.getPickupdate());
		rt.setPickuplocation(booking.getPickuplocation());
		rt.setPickuptime(booking.getPickuptime());
		rt.setReturntime(booking.getReturntime());
		rt.setReturnlocation(booking.getReturnlocation());
		rt.setReturndate(booking.getReturndate());
		rt.setReturnfuelquantity(null);
		rt.setUsername(username);
		rt.setInsurencestatus(booking.isInsurence());
		rt.setTotalamount(0);
		rt.setMiscellaneous("not yet returned the vehicle");
		rt.setComments("not yet returned the vehicle");
		rt.setVehicleid(id);
		rt.setId(new Random().nextInt(1000000));
		rentalrepository.save(rt);
	}
	
	
}
