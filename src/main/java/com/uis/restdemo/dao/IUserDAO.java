package com.uis.restdemo.dao;

import java.util.List;

import com.uis.restdemo.entities.User;

public interface IUserDAO {
	
	public List<User> getUsers();

	public User getUser(String username);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(String username);

}
