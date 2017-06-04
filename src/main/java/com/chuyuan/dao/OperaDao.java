package com.chuyuan.dao;

import com.chuyuan.entity.Operation;
import com.chuyuan.entity.User;

public interface OperaDao extends GenericDao<Operation, Integer>{
	User findUser(Integer operaId);
	
}
