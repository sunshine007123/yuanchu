package com.chuyuan.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuyuan.dao.CourseDao;
import com.chuyuan.entity.Course;
import com.chuyuan.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	public void add(Course course) {
		courseDao.insert(course);
	}
	
	public void delete(Course course) {
		courseDao.delete(course);

	}

	public void update(Course course) {
		courseDao.update(course);

	}

	public Course findCourseById(int id) {
		return courseDao.findById(id);
	}

	public ArrayList<Course> findAllCourse() {
		return courseDao.findAll();
	}

}
