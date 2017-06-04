package com.chuyuan.dao;

import java.util.ArrayList;

import com.chuyuan.entity.Students;

public interface StudentDao extends GenericDao<Students, Integer> {
	ArrayList<Students> findStuToIndex();
}
