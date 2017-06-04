package com.chuyuan.service;

import com.chuyuan.entity.User;

public interface UserService {
	void insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User findUserById(Integer id);
	
	User findUserByName(String userName);
}
