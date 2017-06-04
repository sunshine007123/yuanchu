package com.chuyuan.service;

import java.util.ArrayList;

import com.chuyuan.entity.Course;

public interface CourseService {
	/*
	 * 增
	 */
	void add(Course course);
	/*
	 * 删
	 */
	void delete(Course course);
	/*
	 * 改
	 */
	void update(Course course);
	/*
	 * 查
	 */
	Course findCourseById(int id);
	
	ArrayList<Course> findAllCourse();
	
}
