package com.vehicle.rental.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.rental.models.User;
import com.vehicle.rental.repository.UserRepository;

@Service
@Transactional
public class userServiceImpl implements userService {
		
	@Autowired
	private UserRepository userrepository;

	@Override
	public List<User> getusers() {
		
		List<User> u =userrepository.findAll();
		System.out.println(u);
		return u;
	}

	@Override
	public User getuser(String username) {
		 
		Optional<User> result = userrepository.findByUsername(username);
		User u=null;
		if(result.isPresent()) {
			u=result.get();
		}else {
			throw new RuntimeException("user not found ");
		}	
		return u;
	}

	@Override
	public void deleteuser(User u) {
		userrepository.delete(u);
		
	}

		
	
	
	
	
	
}
