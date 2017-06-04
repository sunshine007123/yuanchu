package com.chuyuan.service;

import java.util.ArrayList;

import com.chuyuan.entity.News;

public interface NewsService {

	void insertNews(News news);
	
	void updateNews(News news);
	
	void deleteNews(News news);
	
	public ArrayList<News> findAllNews();
	
	public ArrayList<News> findNewsToIndex();
	
	public News findNewsById(int id);
	
	public ArrayList<News> findNotDelNews();
}
