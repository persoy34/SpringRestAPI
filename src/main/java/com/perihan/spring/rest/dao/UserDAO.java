package com.perihan.spring.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.perihan.spring.rest.model.User;

@Repository
public interface UserDAO {
	List<User> getAllUsers();
	User addUser(User user);
	User getUser(Long userId);
	void updateUser(User user);
	void deleteUser(Long userId);
	
}
