package com.chuyuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuyuan.dao.UserDao;
import com.chuyuan.entity.User;
import com.chuyuan.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void insertUser(User user) {
		userDao.insert(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	public User findUserByName(String userName) {
		return userDao.findUserByName(userName);
	}

}
