package com.skilldistillery.lifttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.lifttracker.entities.User;
import com.skilldistillery.lifttracker.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	/*---------------------------------------------------------------------
	 * get all users
	 ---------------------------------------------------------------------*/

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	/*---------------------------------------------------------------------
	 * get user by id
	 ---------------------------------------------------------------------*/
	
	@Override
	public User getUserById(int userId) {
		if (userRepo.existsById(userId)) {
			return userRepo.findById(userId).get();
		} else {
			return null;
		}
	}
	
	/*---------------------------------------------------------------------
	 * add user
	 ---------------------------------------------------------------------*/

	@Override
	public User addUser(User user) {
		return userRepo.saveAndFlush(user);
	}
	
	/*---------------------------------------------------------------------
	 * edit user
	 ---------------------------------------------------------------------*/

	@Override
	public User editUser(int id, User user) {
		user.setId(id);
		if (userRepo.existsById(id)) {
			return userRepo.save(user);
		}
		return null;
	}
	
	/*---------------------------------------------------------------------
	 * delete user
	 ---------------------------------------------------------------------*/

	@Override
	public boolean deleteUser(int userId) {
		boolean deleted = false;
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			deleted = true;
		}
		return deleted;
	}

}
