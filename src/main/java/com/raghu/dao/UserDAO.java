package com.raghu.dao;

import com.raghu.model.User;

public interface UserDAO {

	public boolean addUser(User user);
	public User findUser(int userId);
	public User updateUser(User user);
	boolean deleteUser(User user);
}
