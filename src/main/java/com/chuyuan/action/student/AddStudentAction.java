package com.chuyuan.action.student;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuyuan.dao.StudentDao;
import com.chuyuan.entity.Students;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class AddStudentAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private String result;
	//json返回data类型声明
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	@Autowired
	private StudentDao studentDao;
	private String name;
	private String club;
	private String location;
	private String content;
	
	public String addStu(){
		try {
			Students stu = new Students(null, name, club, location, content, null);
			studentDao.insert(stu);
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "true");
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	//get/set方法
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
