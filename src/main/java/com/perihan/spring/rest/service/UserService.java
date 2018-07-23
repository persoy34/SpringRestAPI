package com.perihan.spring.rest.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

import com.perihan.spring.rest.dao.CountryDAO;
import com.perihan.spring.rest.dao.UserDAO;
import com.perihan.spring.rest.model.Country;
import com.perihan.spring.rest.model.User;

@Service("userService")
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CountryDAO countryDAO;
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	@Transactional
	public void addUser(User user) {
		Set <Country> countrySet = new HashSet<>();
		user.getCountry().forEach(country -> {
			String countryCode = ((Country)country).getCountryCode();
			Country country2 =countryDAO.getCountry(countryCode);
			if (country2 == null) {
				throw  new RestClientException("There is no country in this country code: "+countryCode);
			}
			countrySet.add(country2);
			
		});
		user.setCountry(countrySet);
		userDAO.addUser(user);
	}
	
	public void deleteUser(Long userID) {
		userDAO.deleteUser(userID);
	}
	
	@Transactional
	public  void updateUser(User user) {
		Set <Country> countrySet = new HashSet<>();
		user.getCountry().forEach(country -> {
			String countryCode = ((Country)country).getCountryCode();
			Country country2 =countryDAO.getCountry(countryCode);
			if (country2 == null) {
				throw  new RestClientException("There is no country in this country code: "+countryCode);
			}
			countrySet.add(country2);
		});
		user.setCountry(countrySet);
		userDAO.updateUser(user);
	}
	
	public User getUser(Long userId) {
		 return userDAO.getUser(userId);
	}
	
}
