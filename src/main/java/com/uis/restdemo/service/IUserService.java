package com.uis.restdemo.service;

import com.uis.restdemo.dto.UserDTO;

public interface IUserService {
	public UserDTO getUserByUsername(String username);
}
