package com.chuyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

    private Integer userID;
    private String userName;
    private String userNickname; // 昵称
    private String userPwd;
    private String headPho; // 头像，存图片路径
    private String qusetion; // 找回密码提示问题
    private String answer; // 答案

    @Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userNickname=" + userNickname + ", userPwd="
				+ userPwd + ", headPho=" + headPho + ", qusetion=" + qusetion + ", answer=" + answer + "]";
	}

	public User() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Column(name = "user_name", length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_pwd", length = 32)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Column(name = "user_head_pho", length = 200)
    public String getHeadPho() {
        return headPho;
    }

    public void setHeadPho(String headPho) {
        this.headPho = headPho;
    }

    @Column(name = "user_question", length = 50)
    public String getQusetion() {
        return qusetion;
    }

    public void setQusetion(String qusetion) {
        this.qusetion = qusetion;
    }

    @Column(name = "user_answer", length = 50)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Column(name = "user_nickname", length = 20)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
