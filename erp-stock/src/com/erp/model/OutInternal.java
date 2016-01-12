/*
 * @(#)InInternal.java 2015-4-13 下午07:36:47 erp-stock
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
 * InInternal
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class OutInternal {
    private Integer id;

    private String name;

    private List<OutInternalDetail> outInternalDetailList;

    private User user;

    private Date date;

    private String remark;

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
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
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
     * 返回  outInternalDetailList
     * @return outInternalDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outInternal")
    public List<OutInternalDetail> getOutInternalDetailList() {
        return outInternalDetailList;
    }

    /**
     * 设置 outInternalDetailList
     * @param outInternalDetailList outInternalDetailList
     */
    public void setOutInternalDetailList(
            List<OutInternalDetail> outInternalDetailList) {
        this.outInternalDetailList = outInternalDetailList;
    }
}
