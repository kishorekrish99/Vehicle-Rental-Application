package com.vehicle.rental.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.client.result.UpdateResult;
import com.vehicle.rental.models.Vehicles;
import com.vehicle.rental.repository.vehicleRepository;

@Service
@Transactional
public class vehicleServiceImpl implements vehicleService {
	
	@Autowired
	private vehicleRepository vehiclerepository;
	
	@Override
	public List<Vehicles> getallvehcles() {
		return vehiclerepository.findAll(); 
	}
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Vehicles getvehicleById(int id) {
		Optional<Vehicles> result = vehiclerepository.findById(id);
		Vehicles vehicle=null;
		if(result.isPresent()) {
			vehicle=result.get();
		}else {
			throw new RuntimeException("Vehicle not found "+id);
		}	
		return vehicle;
	}

	@Override
	public void saveVehicle(Vehicles vehicle) {
		vehicle.setId(new Random().nextInt(1000000));
		vehicle.setUniqueId(new Random().nextInt(1000000));
		vehiclerepository.save(vehicle);
	}

	@Override
	public void deleteVehicle(int id) {
		vehiclerepository.deleteById(id);
		
	}

	@Override
	public void disableVehicle(int id) {
		Query query= new Query().addCriteria(Criteria.where("id").is(id));
		Update updateDef = new Update().set("availability",false);
		
		UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDef, Vehicles.class);
	
		
	}

	@Override
	public void editVehicle(Vehicles vehicle, int id) {
		Query query= new Query().addCriteria(Criteria.where("id").is(id));
		vehicle.setId(id);
		vehiclerepository.save(vehicle);
	}

	@Override
	public void disablecar(int id) {
		Query query= new Query().addCriteria(Criteria.where("id").is(id));
		Update updateDef = new Update().set("availability",true);
		
		UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDef, Vehicles.class);
		
	}


	
	
}
