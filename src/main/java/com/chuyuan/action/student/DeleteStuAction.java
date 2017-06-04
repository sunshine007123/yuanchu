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

public class DeleteStuAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private String id;
	@Autowired
	private StudentDao studentDao;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	private String result;
	
	public String deleteStu(){
		try {
			Students stu = studentDao.findById(Integer.parseInt(id));
			studentDao.delete(stu);
			Map<String, String> map= new HashMap<String, String>();
			map.put("result", "true");
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//get/set
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
