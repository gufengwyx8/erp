/*
 * @(#)Knowledge.java 2015-5-6 下午07:47:41 erp-office
 */
package com.erp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Knowledge
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Knowledge {
    private Integer id;

    private String title;

    private String type;

    private String organ;

    private String content;

    private String realFileName;

    private String fileName;

    private String remark;

    private User user;

    private Date date;

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 返回  type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 type
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 返回  organ
     * @return organ
     */
    public String getOrgan() {
        return organ;
    }

    /**
     * 设置 organ
     * @param organ organ
     */
    public void setOrgan(String organ) {
        this.organ = organ;
    }

    /**
     * 返回  content
     * @return content
     */
    @Lob
    public String getContent() {
        return content;
    }

    /**
     * 设置 content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回  fileName
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 fileName
     * @param fileName fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 返回  remark
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 remark
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 返回  user
     * @return user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
     * 设置 user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回  realFileName
     * @return realFileName
     */
    public String getRealFileName() {
        return realFileName;
    }

    /**
     * 设置 realFileName
     * @param realFileName realFileName
     */
    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }
}
