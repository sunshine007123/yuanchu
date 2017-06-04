package com.chuyuan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {

    @Override
	public String toString() {
		return "Operation [operID=" + operID + ", user=" + user + ", operTime=" + operTime + ", operUpdateTime="
				+ operUpdateTime + ", operHits=" + operHits + "]";
	}

	private Integer operID;
    private User user; // 操作账号
    private Date operTime; // 操作时间
    private Date operUpdateTime; // 修改时间
    private Integer operHits;// 点击量

    public Operation() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oper_id")
    public Integer getOperID() {
        return operID;
    }

    public void setOperID(Integer operID) {
        this.operID = operID;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "oper_user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "oper_time")
    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Column(name = "oper_update")
    public Date getOperUpdateTime() {
        return operUpdateTime;
    }

    public void setOperUpdateTime(Date operUpdateTime) {
        this.operUpdateTime = operUpdateTime;
    }

    @Column(name = "oper_hits")
    public Integer getOperHits() {
        return operHits;
    }

    public void setOperHits(Integer operHits) {
        this.operHits = operHits;
    }

}
