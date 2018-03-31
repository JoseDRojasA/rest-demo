package com.uis.restdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uis.restdemo.dao.IUserDAO;
import com.uis.restdemo.dto.ApiDTOBuilder;
import com.uis.restdemo.dto.UserDTO;
import com.uis.restdemo.entities.User;

@Component
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public UserDTO getUserByUsername(String username) {
		User user = userDAO.getUser(username);	
		return ApiDTOBuilder.userToUserDTO(user);
	}

}
