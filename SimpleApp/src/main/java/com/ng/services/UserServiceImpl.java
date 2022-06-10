package com.ng.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ng.dao.UserDaoImp;
import com.ng.entities.User;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDaoImp dao;
	
	@Override
	public int saveUser(User user) 
	{
		return dao.save(user);
	}

	@Override
	public List<User> getAllUser() 
	{
		return dao.getAll();
	}

	@Override
	public Long getUserCount() 
	{
		return dao.getCount();
	}

}
