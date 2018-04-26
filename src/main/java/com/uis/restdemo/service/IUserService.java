package com.uis.restdemo.service;

import java.util.List;

import com.uis.restdemo.dto.UserDTO;

public interface IUserService {

	public List<UserDTO> getAllUsers();

	public UserDTO getUserByUsername(String username);

	public void createUser(UserDTO user);

	public void updateUser(UserDTO user);

	public void deleteUser(String username);
}
