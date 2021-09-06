package com.mog.res;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mog.dto.UserDto;
import com.mog.model.Post;
import com.mog.model.User;
import com.mog.servs.UserService;



@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService serv;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll(){
		
	
		return ResponseEntity.ok().body(serv.findAll().stream().map(x -> new UserDto(x)).collect(Collectors.toList()));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User u1=serv.findById(id);
	
		return ResponseEntity.ok().body(new UserDto(u1));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		serv.deleById(id);	
		return ResponseEntity.noContent().build();
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> findById(@RequestBody UserDto dtoU){
		User u1=serv.FromDto(dtoU);
		u1=serv.insert(u1);	
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(u1.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateById(@RequestBody UserDto dtoU,@PathVariable String id){
		User u1=serv.FromDto(dtoU);
		u1.setId(id);		
		serv.updById(u1);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}/posts",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPost(@PathVariable String id){
		User u1=serv.findById(id);
		List<Post> posts=u1.getPosts();
	
		return ResponseEntity.ok().body(posts);
	}
	
	
}
