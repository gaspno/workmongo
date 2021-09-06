package com.mog.servs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mog.Exceptions.ObjectNotFoundException;
import com.mog.dto.UserDto;
import com.mog.model.User;
import com.mog.reps.UserRep;

@Service
public class UserService {
	
	@Autowired
	private UserRep rep;

	public List<User> findAll(){
		
		return rep.findAll();
		
	}
	public User findById(String id) {
		Optional<User> user=rep.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		
	}
	public User insert(User u) {
		
		return rep.insert(u);
		
	}
	public User FromDto(UserDto dtoU) {
				
		return new User(dtoU.getId(),dtoU.getName(),dtoU.getEmail());
	}
	public void deleById(String id) {
		// TODO Auto-generated method stub
		findById(id);
		rep.deleteById(id);
	}
	
	public void updById(User user) {
		// TODO Auto-generated method stub
		User usux=findById(user.getId());
		usux.setName(user.getName());
		usux.setEmail(user.getEmail());
		rep.save(usux);
	}
	
	
	
}
