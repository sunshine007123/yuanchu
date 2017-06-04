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
@Table(name = "images")
public class Images {

    private Integer imasID;
    private String imasContent;
    private String imasTitle;
    private Operation operation; // image外键

    public Images() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imas_id")
    public Integer getImasID() {
        return imasID;
    }

    public void setImasID(Integer imasID) {
        this.imasID = imasID;
    }

    @Lob
    @Column(name = "imas_content", columnDefinition = "TEXT")
    public String getImasContent() {
        return imasContent;
    }

    public void setImasContent(String imasContent) {
        this.imasContent = imasContent;
    }

    @Column(name = "imas_title", length = 200)
    public String getImasTitle() {
        return imasTitle;
    }

    public void setImasTitle(String imasTitle) {
        this.imasTitle = imasTitle;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch =FetchType.LAZY, targetEntity = Operation.class)
    @JoinColumn(name = "imas_opera_id")
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
