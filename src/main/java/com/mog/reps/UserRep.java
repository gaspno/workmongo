package com.mog.reps;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mog.model.User;

@Repository
public interface UserRep extends MongoRepository<User,String> {

	
	
}
