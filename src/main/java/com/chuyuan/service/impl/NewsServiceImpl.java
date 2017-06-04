package com.chuyuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chuyuan.dao.NewsDao;
import com.chuyuan.dao.impl.NewsDaoImpl;
import com.chuyuan.entity.News;
import com.chuyuan.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	public void insertNews(News news) {
		newsDao.insert(news);
	}

	public void updateNews(News news) {
		newsDao.update(news);

	}

	public void deleteNews(News news) {
		newsDao.delete(news);

	}

	public ArrayList<News> findAllNews() {
		ArrayList<News> news = newsDao.findAll();
		return news;
	}

	public News findNewsById(int id) {
		News news = newsDao.findById(id);
		return news;
	}

	public ArrayList<News> findNewsToIndex() {
		ArrayList<News> news = newsDao.findNewsToIndex();
		return news;
	}

	public ArrayList<News> findNotDelNews(){
		ArrayList<News> news = newsDao.findNotDelNews();
		return news;
	}
}
