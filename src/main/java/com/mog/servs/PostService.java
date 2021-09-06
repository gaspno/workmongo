package com.mog.servs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mog.Exceptions.ObjectNotFoundException;
import com.mog.dto.UserDto;
import com.mog.model.Post;
import com.mog.model.User;
import com.mog.reps.PostRep;
import com.mog.reps.UserRep;

@Service
public class PostService {
	
	@Autowired
	private PostRep rep;

	
	public Post findById(String id) {
		Optional<Post> user=rep.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		
	}
	
	
	
}
