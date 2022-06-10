package com.ng.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ng.entities.Account;
import com.ng.entities.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int save(User user) 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		int id = (int) session.save(user);
		tx.commit();
		session.close();
		
		return id;
	}

	@Override
	public List<User> getAll() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		
		Query q = session.createQuery("from User");
		List<User> userList = q.list();
		
		tx.commit();
		session.close();
		
		return userList;
	}

	@Override
	public Long getCount() 
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		
		TypedQuery query = session.getNamedQuery("getCountUsers");
		Long count =(Long) query.getSingleResult();
		
		System.out.println("Total Count-->"+count);
		
		tx.commit();
		
		return count;
	}
	
	@Override
    public Account findAccount(String userName) 
    {
    	Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction(); 
		Account acc =  session.find(Account.class, userName);
		tx.commit();
		session.close();
		return acc;
       
    }
}
