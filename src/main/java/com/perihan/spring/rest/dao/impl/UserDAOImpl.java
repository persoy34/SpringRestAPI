package com.perihan.spring.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.perihan.spring.rest.dao.UserDAO;
import com.perihan.spring.rest.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;
		
	}

	@Override
	public User addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		return user;

	}

	@Override
	public User getUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.load(User.class, userId);
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);

	}

	@Override
	public void deleteUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.load(User.class, userId);
		if (null != user) {
			session.delete(user);
		}
	}

}
