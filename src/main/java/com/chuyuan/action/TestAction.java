package com.chuyuan.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
public class TestAction extends ActionSupport implements ServletRequestAware{
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private String result;
    private String age;
    private String name;
    private String position;
    public void setServletRequest(HttpServletRequest arg0) {
        this.request = arg0;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    /**
     * 处理ajax请求
     * @return SUCCESS
     */
    public String excuteAjax(){
        try {
            //获取数据
            //将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("name", this.getName());
            map.put("age",this.getAge());
            map.put("position", this.getPosition());
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            result = json.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}