package com.training.userservice.dao;

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

}
