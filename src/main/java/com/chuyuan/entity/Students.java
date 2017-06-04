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
@Table(name = "stu")
public class Students {

    private Integer stuID;
    private String stuName;
    private String stuClub;
    private String stuLocation;
    private String stuContent;
    private Operation operation;
    
    public Students() {
        super();
    }

    public Students(Integer stuID, String stuName, String stuClub, String stuLocation, String stuContent,
			Operation operation) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.stuClub = stuClub;
		this.stuLocation = stuLocation;
		this.stuContent = stuContent;
		this.operation = operation;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    @Column(name = "stu_name", length = 20)
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Column(name = "stu_club", length = 20)
    public String getStuClub() {
        return stuClub;
    }

    public void setStuClub(String stuClub) {
        this.stuClub = stuClub;
    }

    @Column(name = "stu_location", length = 10)
    public String getStuLocation() {
        return stuLocation;
    }

    public void setStuLocation(String stuLocation) {
        this.stuLocation = stuLocation;
    }

    @Lob
    @Column(name = "stu_content", columnDefinition = "TEXT")
    public String getStuContent() {
        return stuContent;
    }

    public void setStuContent(String stuContent) {
        this.stuContent = stuContent;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY, targetEntity = Operation.class)
    @JoinColumn(name = "stu_opera_id")
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
