package com.mog.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mog.dto.AuthorDto;
import com.mog.dto.CommentDto;
import com.mog.model.Post;
import com.mog.model.User;
import com.mog.reps.PostRep;
import com.mog.reps.UserRep;
@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRep userRep;
	@Autowired
	private PostRep postRep;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat s1=new SimpleDateFormat("dd/MM/yyyy");
		s1.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRep.deleteAll();
		postRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRep.saveAll(Arrays.asList(maria,alex,bob));
		
		Post p1=new Post(null,s1.parse("21/03/2018"),"Bom dia","Viagem até São paulo",new AuthorDto(maria));
		Post p2=new Post(null,s1.parse("21/09/2018"),"Bom dia a todos","Dormir ate de tarde",new AuthorDto(alex));
		Post p3=new Post(null,s1.parse("23/09/2018"),"Bom dia a todos ","acordei feliz hoje",new AuthorDto(maria));
		
		CommentDto c1=new CommentDto("Cuidado com a floresta a noite",s1.parse("21/03/2018"),new AuthorDto(alex));
		CommentDto c2=new CommentDto("Cuidado com a floresta a noite",s1.parse("22/03/2018"),new AuthorDto(maria));
		CommentDto c3=new CommentDto("Cuidado com a floresta a noite",s1.parse("22/03/2018"),new AuthorDto(bob));
		CommentDto c4=new CommentDto("Tenha um otimo dia",s1.parse("21/09/2018"),new AuthorDto(maria));
		
		p1.getComm().addAll(Arrays.asList(c1,c2,c3));
		p2.getComm().add(c4);
	
		postRep.saveAll(Arrays.asList(p1,p2,p3));
		
		maria.setPosts(Arrays.asList(p1,p3));
		alex.setPosts(Arrays.asList(p2));
		
		userRep.saveAll(Arrays.asList(maria,alex));
		
		
	}

}
