package com.chuyuan.dao.impl;


import org.springframework.stereotype.Repository;

import com.chuyuan.dao.UserDao;
import com.chuyuan.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	public User findUserByName(String name) {
		String hql = "from User where userName = ?";
		User user = (User) getUniqueResult(hql, name);
		return user;
	}

}
