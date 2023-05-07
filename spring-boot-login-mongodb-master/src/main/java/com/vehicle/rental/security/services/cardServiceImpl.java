package com.vehicle.rental.security.services;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.client.result.UpdateResult;
import com.vehicle.rental.models.User;
import com.vehicle.rental.models.cards;
import com.vehicle.rental.repository.UserRepository;
import com.vehicle.rental.repository.cardsRepository;
import com.vehicle.rental.security.jwt.JwtUtils;

@Service
@Transactional
public class cardServiceImpl implements cardsService {

	@Autowired
	private cardsRepository cardsrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	 @Autowired
	 private JwtUtils jwtUtils;
	 
	@Override
	public void deletecard(int id) {
		cardsrepository.deleteById(id);
		
	}

	@Override
	public Long saveCards(cards card, String username) {
			Query query= new Query().addCriteria(Criteria.where("username").is(username));
			Update updateDef = new Update().push("cards",card);
			
			UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDef, User.class);
			return updateResult.getModifiedCount();
	}

	@Override
	public List<Object> getcards(String username) {
		 User user = userrepository.findByUsername(username)
			        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		 System.out.println(username);
		 System.out.println(user);
		 List<Object> card =  Arrays.asList(user.getCards());
		 System.out.println(user.getCards());
		return card;
	}
	

}
