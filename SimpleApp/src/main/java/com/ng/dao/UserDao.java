package com.ng.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.ng.entities.Account;
import com.ng.entities.User;

public interface UserDao 
{
	public int save(User user);
	public List<User> getAll();
	public Long getCount();
	public Account findAccount(String userName);
}
