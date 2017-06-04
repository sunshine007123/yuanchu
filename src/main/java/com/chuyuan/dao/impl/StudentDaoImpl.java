package com.chuyuan.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.chuyuan.dao.StudentDao;
import com.chuyuan.entity.News;
import com.chuyuan.entity.Students;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Students , Integer> implements StudentDao {

	public ArrayList<Students> findStuToIndex() {
		String hql = "from Students s order by s.id desc";
		ArrayList<Students> Stu = (ArrayList<Students>)getResult(hql, null);
		return Stu;
	}

}
