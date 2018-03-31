package com.uis.restdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uis.restdemo.dto.UserDTO;
import com.uis.restdemo.exceptions.InternalServerError;
import com.uis.restdemo.exceptions.WrongParameters;
import com.uis.restdemo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="{username}", method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<UserDTO> read(@PathVariable String username) {
		UserDTO user = service.getUserByUsername(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@RequestMapping(value="", method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
		try {
			service.createUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT, produces="application/json" )
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO user) {
		try {
			service.updateUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.DELETE, produces="application/json" )
	public ResponseEntity<UserDTO> delete(@PathVariable String username) {
		try {
			service.deleteUser(username);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (WrongParameters p) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InternalServerError u) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
