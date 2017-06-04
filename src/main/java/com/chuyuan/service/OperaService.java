package com.chuyuan.service;

import java.util.ArrayList;

import com.chuyuan.entity.Operation;
import com.chuyuan.entity.User;

public interface OperaService {
	Operation findOperaById(Integer id);
	
	ArrayList<Operation> findAll();
	
	User findUser(Integer id);
	
	void update(Operation opera);
}
