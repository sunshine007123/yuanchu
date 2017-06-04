package com.chuyuan.dao;

import com.chuyuan.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

	User findUserByName(String name);
}