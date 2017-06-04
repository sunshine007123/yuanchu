package com.chuyuan.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuyuan.dao.StudentDao;
import com.chuyuan.entity.Students;
import com.chuyuan.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	public void insertStu(Students stu) {
		studentDao.insert(stu);
	}

	public void updateStu(Students stu) {
		studentDao.update(stu);
	}

	public void deleteStu(Students stu) {
		studentDao.delete(stu);
	}

	public ArrayList<Students> findAllStu() {
		return studentDao.findAll();
	}

	public ArrayList<Students> findStuToIndex() {
		return studentDao.findStuToIndex();
	}

	public Students findStuById(int id) {
		return studentDao.findById(id);
	}

}
