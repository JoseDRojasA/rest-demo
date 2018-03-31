package com.uis.restdemo.dao;

import com.uis.restdemo.entities.User;

public interface IUserDAO {
	
	public User getUser(String username);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(String username);

}
