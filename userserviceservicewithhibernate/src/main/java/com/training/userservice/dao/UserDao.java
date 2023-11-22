package com.training.userservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public String saveUser(UserDetails user) {

		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(user); 
		ts.commit();
		session.close();
		return "UserSaved";

	}
	
	public List<UserDetails> geatAllUsers(){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		List<UserDetails> ul =  session.createQuery("from UserDetails").list();
		session.close();
		return ul;
	}
	
	public UserDetails getUser(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		UserDetails user = session.load(UserDetails.class,uid );
		return user;
	}
	
	public String deleteUser(Integer uid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		UserDetails user = session.load(UserDetails.class,uid );
		session.delete(user);
		ts.commit();
		session.close();
		return "User Deleted";
	}

}
