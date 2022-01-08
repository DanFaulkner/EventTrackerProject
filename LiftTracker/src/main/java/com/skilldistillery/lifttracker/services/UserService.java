package com.skilldistillery.lifttracker.services;

import java.util.List;

import com.skilldistillery.lifttracker.entities.User;

public interface UserService {

	List<User> getAllUsers();
	User getUserById(int userId);
	User addUser(User user);
	User editUser(int id, User user);
	boolean deleteUser(int userId);
}
