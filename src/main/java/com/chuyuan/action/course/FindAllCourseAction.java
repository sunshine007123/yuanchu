package com.chuyuan.action.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuyuan.entity.Course;
import com.chuyuan.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FindAllCourseAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
	CourseService courseService = ctx.getBean(CourseService.class);
	private String result;
	public String findAllCou(){
		try {
			ArrayList<Course> courseList = courseService.findAllCourse();
			Map<String, List<Course>> map = new HashMap<String, List<Course>>();
			map.put("courses", courseList);
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
