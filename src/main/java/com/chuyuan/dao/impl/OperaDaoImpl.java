package com.chuyuan.dao.impl;

import org.springframework.stereotype.Repository;

import com.chuyuan.dao.OperaDao;
import com.chuyuan.entity.Operation;
import com.chuyuan.entity.User;
@Repository
public class OperaDaoImpl extends GenericDaoImpl<Operation, Integer> implements OperaDao {

	public User findUser(Integer operaId) {
		String hql = "from User where operID = ?";
		User user = (User) getUniqueResult(hql, operaId);
		return user;
	}

}
