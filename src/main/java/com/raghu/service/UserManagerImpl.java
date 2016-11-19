package com.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.dao.UserDAO;
import com.raghu.model.User;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
    UserDAO dao;
	public boolean addUser(User user) {
	System.out.println(user);	
	return dao.addUser(user);
		
	}
	public User findUser(int userId) {
		
		User user=dao.findUser(userId);
		return user;
	}
	public User updateUser(User user) {
		User user2=dao.updateUser(user);
		return user2;
	}
	public boolean deleteUser(User user) {
		
		return dao.deleteUser(user);
	}

}
