package com.perihan.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perihan.spring.rest.model.User;
import com.perihan.spring.rest.service.UserService;

@RestController
public class UserController {
	
	@Autowired 
	UserService userService; 

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers() {
 
		List<User> listOfCountries = userService.getAllUsers();
		return listOfCountries;
	}
 
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
 
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@RequestBody User user) { 
		userService.addUser(user);
 
	}
 
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
 
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") Long id) {
		userService.deleteUser(id);  
	} 
}
