package com.uis.restdemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.uis.restdemo.entities.User;

@Repository
public class UserDAO implements IUserDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public User getUser(String username) {
		return em.find(User.class, username);
	}

}
