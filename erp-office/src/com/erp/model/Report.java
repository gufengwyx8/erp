/*
 * @(#)Report.java 2015-5-6 下午07:49:14 erp-office
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
 * Report
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Report {
    private Integer id;

    private User user;

    private Date date;

    private String type;

    private String content;

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
}
