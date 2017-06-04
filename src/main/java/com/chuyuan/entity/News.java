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
@Table(name = "news")
public class News {

    private Integer newID;
    private String newTitle;
    private String newContent;
    private String newImage;
    private String newProvenance;// 新闻出处
    private Operation operation;// 操作者
    private int tag;//逻辑删除

    public News(Integer newID, String newTitle, String newContent, String newImage, String newProvenance,
			Operation operation,int tag) {
		super();
		this.newID = newID;
		this.newTitle = newTitle;
		this.newContent = newContent;
		this.newImage = newImage;
		this.newProvenance = newProvenance;
		this.operation = operation;
		this.tag = tag;
	}


	public News() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "new_id")
    public Integer getNewID() {
        return newID;
    }

    public void setNewID(Integer newID) {
        this.newID = newID;
    }

    @Column(name = "new_title", length = 100)
    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }
    @Column(name = "new_tag",length = 1)
    public int getTag() {
    	return tag;
    }
    
    public void setTag(int tag) {
    	this.tag = tag;
    }
    @Lob
    @Column(name = "new_content", columnDefinition = "TEXT")
    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    @Column(name = "new_image", length = 100)
    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    @Column(name = "new_provenance", length = 200)
    public String getNewProvenance() {
        return newProvenance;
    }

    public void setNewProvenance(String newProvenance) {
        this.newProvenance = newProvenance;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.EAGER, targetEntity = Operation.class)
    @JoinColumn(name = "new_opera_id")
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }   
}
