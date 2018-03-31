package com.uis.restdemo.dao;

import com.uis.restdemo.entities.User;

public interface IUserDAO {
	
	public User getUser(String username);

}
