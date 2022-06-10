package com.ng.spring;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ng.spring.entities.User;

@Service
public class UserService 
{
	@Autowired
	UserRespository repo;
	
	
	public void addUser(User user)
	{
		repo.save(user);
	}
	
	public Optional<User> searchUser(int id)
	{
		Optional<User> user = repo.findById(id);
		return user;
	}
	
	public void deleteUser(User user)
	{
		repo.delete(user);
	}
}
