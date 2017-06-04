package com.chuyuan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

    private Integer imaId;
    private Images images;//多对一
    private String imaPath;
    private String imaTitle;
    
    public Image() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ima_id")
    public Integer getImaId() {
        return imaId;
    }

    public void setImaId(Integer imaId) {
        this.imaId = imaId;
    }

    @ManyToOne
    @JoinColumn(name = "imas_id")
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Column(name = "ima_path", length = 100)
    public String getImaPath() {
        return imaPath;
    }

    public void setImaPath(String imaPath) {
        this.imaPath = imaPath;
    }

    @Column(name = "ima_title", length = 200)
    public String getImaTitle() {
        return imaTitle;
    }

    public void setImaTitle(String imaTitle) {
        this.imaTitle = imaTitle;
    }
    
}
