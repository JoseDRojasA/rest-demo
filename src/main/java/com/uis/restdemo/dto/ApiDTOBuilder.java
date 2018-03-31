package com.uis.restdemo.dto;

import com.uis.restdemo.entities.User;

public class ApiDTOBuilder {
	public static UserDTO userToUserDTO(User user) {
		return new UserDTO(user.getUsername(), "", user.getUserType(), 
				user.getEmail(), user.getName(), user.getLastName(), 
				user.getTel(), user.getBornDate());
	}
	public static User userDTOToUser(UserDTO user) {
		return new User(user.getUsername(), user.getPassword(), user.getUserType(),
				user.getEmail(), user.getName(), user.getLastName(), user.getTel(), user.getBornDate());
	}
}
