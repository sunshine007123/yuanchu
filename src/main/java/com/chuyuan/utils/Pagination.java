package com.chuyuan.utils;

import java.util.List;

/**
 * 分页工具类
 * @author admin
 *
 * @param <T>
 */
public class Pagination<T> {

	private int pageNum; //当前页码
	private int pageSize; //每页记录数
	private int totalSize; //总记录数
	private List<T> pageList; //当前页的记录
	private int offset; //每页的起始位置
	
	public Pagination(){
		
	}

	public Pagination(int pageNum, int pageSize, int totalSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		if(offset <= 0){
			this.offset = 0;
		}else if (offset >= totalSize) {
			this.offset = totalSize - 1;
		}else {
			this.offset = offset;
		}
	}
}
