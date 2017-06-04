package com.chuyuan.dao;

import java.util.ArrayList;

import com.chuyuan.entity.News;

public interface NewsDao extends GenericDao<News, Integer> {
	ArrayList<News> findNewsToIndex();
	
	ArrayList<News> findNotDelNews();
}
