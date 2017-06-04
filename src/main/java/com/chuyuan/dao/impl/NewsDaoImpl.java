package com.chuyuan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chuyuan.dao.NewsDao;
import com.chuyuan.entity.News;

@Repository
public class NewsDaoImpl extends GenericDaoImpl<News, Integer> implements NewsDao{

	public ArrayList<News> findNewsToIndex() {
		String hql = "from News n where n.tag = 0 order by n.id desc";
		ArrayList<News> news = (ArrayList<News>)getResult(hql, null);
		return news;
	}

	public ArrayList<News> findNotDelNews() {
		String hql = "from News n where n.tag = 0";
		ArrayList<News> news = (ArrayList<News>)getResult(hql, null);
		return news;
	}

}
