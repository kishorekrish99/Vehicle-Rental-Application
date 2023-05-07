package com.vehicle.rental.security.services;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.rental.models.rentaltransaction;
import com.vehicle.rental.repository.RentalRepository;
@Service
@Transactional
public class RentalServiceImpl implements RentalService {
	
	@Autowired
	private RentalRepository rentalrepository;
	
	@Autowired
	private vehicleService vehicleservice;
	
	@Override
	public List<rentaltransaction> getalltransaction(String username) {
		
		List<rentaltransaction> alltransactions = rentalrepository.findAll();
		List<rentaltransaction> usertrans = new ArrayList<>();
		try {
		for(rentaltransaction r : alltransactions) {
			if(r.getUsername().equals(username)) {
				usertrans.add(r);
				System.out.println(usertrans);
			}
		}
	
		}catch(NullPointerException ne) {
			System.out.println(ne);
		}
		
		return usertrans;

	}
	
	@Override
	public void saveTransaction(rentaltransaction rt) {
		rentalrepository.save(rt);
	}

	@Override
	public void returnvehicle(String username, int id, rentaltransaction rt) {
		
		long totalamount=0;
		long days= ChronoUnit.DAYS.between(rt.getPickupdate(), rt.getReturndate());
		rt.setId(id);
		
		
		
		Duration duration = Duration.between(rt.getPickuptime(), rt.getReturntime());
		
		long hours = 24* days + duration.toHours();;
		
		totalamount = (rt.getAmount() * hours)/24;
		rt.setTotalamount(totalamount);
		
		rt.setActive(false);
		vehicleservice.disablecar(rt.getVehicleid());
		rentalrepository.save(rt);
	}

}
