package com.chuyuan.action.course;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuyuan.entity.Course;
import com.chuyuan.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class UpdateCourseAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String content;
	private String image;
	private String job;
	private String period;//学习周期
	private String desc;//课程简介
	@Autowired
	private CourseService courseService;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	private String result;
	/**
	 * viveza 17.5.13
	 * @return 成功返回json key:result value:true
	 */
	public String updateCou(){
		try {
			Course course = courseService.findCourseById(Integer.parseInt(id));
			course.setCouName(name);
			course.setCouContent(content);
			course.setCouPhoto(image);
			course.setCouJobDirecte(job);
			course.setCouPeriod(period);
			course.setCouDescription(desc);
			courseService.update(course);
			Map<String, String> map = new HashMap<String, String>();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
