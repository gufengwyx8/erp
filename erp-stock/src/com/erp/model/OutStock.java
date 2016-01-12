/*
 * @(#)InStock.java 2015-4-13 下午07:44:37 erp-stock
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
 * InStock
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class OutStock {
    private Integer id;

    private String reason;

    private List<OutStockDetail> outStockDetailList;

    private User user;

    private Date date;

    private Integer count;

    private Integer actualCount;

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
     * 返回  count
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置 count
     * @param count count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 返回  actualCount
     * @return actualCount
     */
    public Integer getActualCount() {
        return actualCount;
    }

    /**
     * 设置 actualCount
     * @param actualCount actualCount
     */
    public void setActualCount(Integer actualCount) {
        this.actualCount = actualCount;
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
     * 返回  outStockDetailList
     * @return outStockDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outStock")
    public List<OutStockDetail> getOutStockDetailList() {
        return outStockDetailList;
    }

    /**
     * 设置 outStockDetailList
     * @param outStockDetailList outStockDetailList
     */
    public void setOutStockDetailList(List<OutStockDetail> outStockDetailList) {
        this.outStockDetailList = outStockDetailList;
    }
}
