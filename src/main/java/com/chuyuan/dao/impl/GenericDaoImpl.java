package com.chuyuan.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.chuyuan.dao.GenericDao;
import com.chuyuan.utils.Pagination;


public class GenericDaoImpl<T,PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {

	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		clazz = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public void insert(T entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public T findById(PK id) {
		return getHibernateTemplate().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> findAll() {
		String hql = "from " + clazz.getName();
		return (ArrayList<T>) getHibernateTemplate().find(hql);
	}
	
	/**
	 * 查找唯一的对象
	 * @param hql hql语言
	 * @param params 所带参数
	 * @return
	 */
	public Object getUniqueResult(final String hql,final Object...params){
		return getHibernateTemplate().execute(new HibernateCallback<T>() {

			@SuppressWarnings("unchecked")
			public T doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				if(params != null){
					for(int i = 0; i < params.length; i++){
						query.setParameter(i, params[i]);
					}
				}
				return (T) query.uniqueResult();
			}
		});
	}
	
	/**
	 * 查询结果集
	 * @param hql hql语言
	 * @param params 参数
	 * @return 结果集合
	 */
	@SuppressWarnings("unchecked")
	public List<T> getResult(final String hql,final Object...params){
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				if(params != null){
					for(int i = 0; i < params.length; i++){
						query.setParameter(i, params[i]);
					}
				}
				return (T) query.list();
			}
		});
	}
	
	/**
	 * 获取分页
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 * @param totalSize 总记录数
	 * @param hql hql语言
	 * @param params 所带参数
	 * @return 分页对象
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> getPagination(final int pageNum,final int pageSize,final int totalSize,final String hql,final Object...params){
		return (Pagination<T>) getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				if(params != null){
					for(int i = 0; i < params.length; i++){
						query.setParameter(i, params[i]);
					}
				}
				//设置起始位置
				query.setFirstResult((pageNum - 1) * pageSize);
				//设置每页记录数
				query.setMaxResults(pageSize);
				//获取每页的记录
				List<T> pageList = query.list();
				//创建分页对象
				Pagination<T> pagination = new Pagination<T>(pageNum,pageSize,totalSize);
				//设置每页数据
				pagination.setPageList(pageList);
				return (T) pagination;
			}
		});
	}

}
