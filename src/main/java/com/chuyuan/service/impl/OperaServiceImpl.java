package com.chuyuan.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chuyuan.dao.OperaDao;
import com.chuyuan.dao.impl.OperaDaoImpl;
import com.chuyuan.entity.Operation;
import com.chuyuan.entity.User;
import com.chuyuan.service.OperaService;

@Repository
public class OperaServiceImpl implements OperaService {
	OperaDao operaDao = new OperaDaoImpl();
	public Operation findOperaById(Integer id) {
		return operaDao.findById(id);
	}

	public ArrayList<Operation> findAll() {
		return operaDao.findAll();
	}

	public User findUser(Integer id) {
		return operaDao.findUser(id);
	}

	public void update(Operation opera) {
		operaDao.update(opera);
	}
}
