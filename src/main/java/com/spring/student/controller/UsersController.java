package com.spring.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.student.model.Users;
import com.spring.student.service.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addUsers")
	public String addUsers(@RequestBody Users user) {
		userService.addUsers(user);
		return "User Added Successfully.....";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Users getUsersById(@PathVariable String id) {
		return userService.getUsersById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public String updateUsers(@PathVariable String id, @RequestBody Users user) {
		userService.updateUsers(id, user);
		return "User Updated Successfully....";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String deleteUsers(@PathVariable String id) {
		userService.deleteUser(id);
		return "User Deleted Successfully....";
	}

}
