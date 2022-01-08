package com.skilldistillery.lifttracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.lifttracker.entities.User;
import com.skilldistillery.lifttracker.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	/*---------------------------------------------------------------------
	 * get all users
	 ---------------------------------------------------------------------*/
	
	@GetMapping("users")
	public List<User> index(){
		return userSvc.getAllUsers();
	}
	
	/*---------------------------------------------------------------------
	 * get user by id
	 ---------------------------------------------------------------------*/
	
	@GetMapping("users/{id}")
	public User getUserById(@PathVariable int id, HttpServletResponse res) {
		User user = userSvc.getUserById(id);
		if(user == null) {
			res.setStatus(400);
		}
		return user;
	}
	
	/*---------------------------------------------------------------------
	 * add user
	 ---------------------------------------------------------------------*/
	
	@PostMapping("users")
	public User addUser(@RequestBody User user, HttpServletResponse res, HttpServletRequest req) {
		try {
			userSvc.addUser(user);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(user.getId());
			res.setHeader("Location", url.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("INVALID JSON");
			res.setStatus(400);
			user = null;
		}
		return user;
	}
	
	/*---------------------------------------------------------------------
	 * edit user
	 ---------------------------------------------------------------------*/
	
	@PutMapping("users/{id}")
	public User editUser(@PathVariable int id, @RequestBody User user, HttpServletResponse res) {
		try {
			if (userSvc.getUserById(id) != null) {
				userSvc.editUser(id, user);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return user;
	}
	
	/*---------------------------------------------------------------------
	 * delete user
	 ---------------------------------------------------------------------*/
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id, HttpServletResponse res) {
		try {
		if(userSvc.deleteUser(id)) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
