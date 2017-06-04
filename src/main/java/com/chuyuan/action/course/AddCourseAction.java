package com.chuyuan.action.course;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuyuan.entity.Course;
import com.chuyuan.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
/**
 * 课程操作
 * @author Viveza 17.5.12
 *
 */
public class AddCourseAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	private String result;
	//json返回data类型声明
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
	CourseService courseService = ctx.getBean(CourseService.class);
	
	private String name;
	private String content;
	private String image;
	private String job;
	private String period;//学习周期
	private String desc;//课程简介
	

	public String add(){
		Course course = new Course();
		course.setCouContent(content);
		course.setCouDescription(desc);
		course.setCouJobDirecte(job);
		course.setCouName(name);
		course.setCouPeriod(period);
		course.setCouPhoto(image);
		if(course != null){
			try {
				courseService.add(course);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("result", "true");
				JSONObject json = JSONObject.fromObject(map);
				result = json.toString();
				return SUCCESS;
			} catch (Exception e) {
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	//get、set方法
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
