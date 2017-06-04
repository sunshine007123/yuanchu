package com.chuyuan.action.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuyuan.dao.StudentDao;
import com.chuyuan.entity.Students;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FindAllStuAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	@Autowired
	private StudentDao studentDao;
	private String result;
	
	public String findAllStu(){
		try {
			ArrayList<Students> students = studentDao.findAll();
			Map<String, List<Students>> map = new HashMap<String, List<Students>>();
			map.put("students", students);
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
}
