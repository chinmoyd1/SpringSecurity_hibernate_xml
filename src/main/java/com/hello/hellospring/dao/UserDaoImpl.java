package com.hello.hellospring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.hello.hellospring.model.User;


public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;


	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		System.out.println("###############USERNAME: "+username+"#######################");
		users = getSessionFactory().getCurrentSession().createQuery("from User where username= :uname").setParameter("uname",username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}