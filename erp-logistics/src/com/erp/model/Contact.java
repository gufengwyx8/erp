/*
 * @(#)Contact.java 2015-4-19 下午07:26:26 erp-logistics
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
 * Contact
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Contact {
    private Integer id;

    private Record record;

    private String reason;

    private String content;

    private Date date;

    private User user;

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
     * 返回  record
     * @return record
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    public Record getRecord() {
        return record;
    }

    /**
     * 设置 record
     * @param record record
     */
    public void setRecord(Record record) {
        this.record = record;
    }

    /**
     * 返回  reason
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置 reason
     * @param reason reason
     */
    public void setReason(String reason) {
        this.reason = reason;
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

}
