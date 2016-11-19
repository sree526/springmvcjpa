package com.raghu.service;


import com.raghu.model.User;

public interface UserManager {
	public boolean addUser(User user);

	public User findUser(int userId);
	public User updateUser(User user);
	public boolean deleteUser(User user);
}
