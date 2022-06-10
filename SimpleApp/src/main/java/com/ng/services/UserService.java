package com.ng.services;

import java.util.List;

import com.ng.entities.Account;
import com.ng.entities.User;

public interface UserService 
{
	public int saveUser(User user);
	public List<User> getAllUser();
	public Long getUserCount();
}
