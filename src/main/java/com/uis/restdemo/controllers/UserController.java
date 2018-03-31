package com.uis.restdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uis.restdemo.dto.UserDTO;
import com.uis.restdemo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="{username}/login", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<UserDTO> logIn(@PathVariable String username) {
		UserDTO user = service.getUserByUsername(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
