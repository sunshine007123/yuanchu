package com.chuyuan.dao;

import java.util.ArrayList;
import java.util.List;

public interface GenericDao<T,PK> {

	/*
	 * 添加
	 */
	public void insert(T entity);
	
	/*
	 * 修改
	 */
	public void update(T entity);
	
	/*
	 * 删除
	 */
	public void delete(T entity);
	
	/*
	 * 通过id查询
	 */
	public T findById(PK id);
	
	/*
	 * 查询所有
	 */
	public ArrayList<T> findAll();
}
