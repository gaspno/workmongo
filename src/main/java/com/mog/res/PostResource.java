package com.mog.res;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.mog.model.Post;

import com.mog.servs.PostService;




@RestController
@RequestMapping(value="/post")
public class PostResource {
	
	@Autowired
	private PostService serv;

	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post=serv.findById(id);
	
		return ResponseEntity.ok().body(post);
	}
	
	
	
	
	
	
	
	
}
