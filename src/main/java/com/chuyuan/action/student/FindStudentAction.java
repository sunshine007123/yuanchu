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

public class FindStudentAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String result;
	private String id;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	@Autowired
	private StudentDao studentDao;
	
	public String findStuById(){
		try {
			Students stu = studentDao.findById(Integer.parseInt(id));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("student", stu);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//get/set
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
