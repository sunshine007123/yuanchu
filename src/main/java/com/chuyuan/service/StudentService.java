package com.chuyuan.service;

import java.util.ArrayList;

import com.chuyuan.entity.Students;

public interface StudentService {
	
	void insertStu(Students stu);
	
	void updateStu(Students stu);
	
	void deleteStu(Students stu);
	
	public ArrayList<Students> findAllStu();
	
	public ArrayList<Students> findStuToIndex();
	
	public Students findStuById(int id);
	
	
}
