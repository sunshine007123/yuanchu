package com.chuyuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    private Integer couID;
    private String couName;
    private String couPeriod; // 学习周期
    private String couContent; // 学习内容
    private String couPhoto; // 课程图片
    private String couDescription; // 课程介绍
    private String couTarget; // 招生对象
    private String couJobDirecte; // 就业方向
    private String couAdv; // 课程优势
    private Operation operation; // 操作号fk

    public Course() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cou_id")
    public Integer getCouID() {
        return couID;
    }

    public void setCouID(Integer couID) {
        this.couID = couID;
    }

    @Column(name = "cou_name", length = 100)
    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    @Column(name = "cou_period", length = 100)
    public String getCouPeriod() {
        return couPeriod;
    }

    public void setCouPeriod(String couPeriod) {
        this.couPeriod = couPeriod;
    }

    @Lob
    @Column(name = "cou_content", columnDefinition = "TEXT")
    public String getCouContent() {
        return couContent;
    }

    public void setCouContent(String couContent) {
        this.couContent = couContent;
    }

    @Column(name = "cou_photo", length = 200)
    public String getCouPhoto() {
        return couPhoto;
    }

    public void setCouPhoto(String couPhoto) {
        this.couPhoto = couPhoto;
    }

    @Lob
    @Column(name = "cou_description", columnDefinition = "TEXT")
    public String getCouDescription() {
        return couDescription;
    }

    public void setCouDescription(String couDescription) {
        this.couDescription = couDescription;
    }

    @Column(name = "cou_target", length = 200)
    public String getCouTarget() {
        return couTarget;
    }

    public void setCouTarget(String couTarget) {
        this.couTarget = couTarget;
    }

    @Column(name = "cou_job_directe", length = 200)
    public String getCouJobDirecte() {
        return couJobDirecte;
    }

    public void setCouJobDirecte(String couJobDirecte) {
        this.couJobDirecte = couJobDirecte;
    }

    @Column(name = "cou_adv", length = 200)
    public String getCouAdv() {
        return couAdv;
    }

    public void setCouAdv(String couAdv) {
        this.couAdv = couAdv;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY, targetEntity = Operation.class)
    @JoinColumn(name = "cou_opera_id")
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
