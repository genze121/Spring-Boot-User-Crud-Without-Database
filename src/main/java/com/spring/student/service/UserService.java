package com.spring.student.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.student.model.Users;

@Service
public class UserService {

	List<Users> lists = new ArrayList<Users>(
			Arrays.asList(new Users("1000", "User-1", "User-1-address", "user-1@gmail.com"),
					new Users("1001","User-2", "User-2-address", "user-2@gmail.com"),
					new Users("1002", "User-3", "User-3-address", "user-3@gmail.com")));

	public List<Users> getAllUsers() {
		return lists;
	}

	public void addUsers(Users users) {
		lists.add(users);
	}

	public Users getUsersById(String id) {
		return lists.stream().filter(u -> u.getId().equals(id)).findFirst().get();
	}
	
	public void updateUsers(String id, Users user) {
		for (int i = 0; i < lists.size(); i++) {
			Users users = lists.get(i);
			if (users.getId().equals(id)) {
				lists.set(i, user);
				return;
			}
		}
	}

	public void deleteUser(String id) {
		lists.removeIf(user -> user.getId().equals(id));
	}

}
