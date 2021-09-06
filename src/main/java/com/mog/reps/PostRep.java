package com.mog.reps;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mog.model.Post;

@Repository
public interface PostRep extends MongoRepository<Post,String> {

	
	
}
