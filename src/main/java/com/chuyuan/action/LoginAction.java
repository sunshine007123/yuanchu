package com.chuyuan.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuyuan.entity.User;
import com.chuyuan.service.UserService;
import com.chuyuan.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user;
	
	@Autowired
	private UserService userService;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private String login(){
		boolean blag = false;
		User findUser = userService.findUserByName(user.getUserName());
		if (findUser != null && MD5Util.encryptMD5(user.getUserPwd()).equals(findUser.getUserPwd())) {
			//ServletActionContext.getContext().getSession().put("user", findUser);
			blag = true;
			try {
				ServletActionContext.getResponse().getWriter().write(blag + "");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			try {
				ServletActionContext.getResponse().getWriter().write(blag + "");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ERROR;
	}
}
