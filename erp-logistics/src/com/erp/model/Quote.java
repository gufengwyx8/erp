/*
 * @(#)Quote.java 2015-4-19 下午07:13:44 erp-logistics
 */
package com.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Quote
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Quote {
    private Integer id;

    private Record record;

    private Date startDate;

    private User user;

    private Date date;

    private String remark;

    private List<QuoteDetail> quoteDetailList;

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
     * 返回  startDate
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置 startDate
     * @param startDate startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
     * 返回  quoteDetailList
     * @return quoteDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quote")
    public List<QuoteDetail> getQuoteDetailList() {
        return quoteDetailList;
    }

    /**
     * 设置 quoteDetailList
     * @param quoteDetailList quoteDetailList
     */
    public void setQuoteDetailList(List<QuoteDetail> quoteDetailList) {
        this.quoteDetailList = quoteDetailList;
    }
}
