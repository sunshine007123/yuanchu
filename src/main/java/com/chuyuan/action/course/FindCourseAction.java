package com.chuyuan.action.course;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuyuan.entity.Course;
import com.chuyuan.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FindCourseAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String result;
	private String id;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
	CourseService courseService = ctx.getBean(CourseService.class);
	
	public String findCouById(){
		try {
			Course course= courseService.findCourseById(Integer.parseInt(id));
			JSONObject json = JSONObject.fromObject(course);
			result = json.toString();
			System.out.println(result);
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
