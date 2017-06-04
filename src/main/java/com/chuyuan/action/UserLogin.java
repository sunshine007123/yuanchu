package com.chuyuan.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuyuan.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport {

	private User user;
	private  ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
//	@SuppressWarnings("serial")
//	public String login(){
//		boolean loginRes = false;
//		UserService userService = ctx.getBean(UserService.class);
//		
//		userService.insertUser(user);
//		ctx.close();
//	}
}
