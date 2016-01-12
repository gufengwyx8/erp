/*
 * @(#)InApply.java 2015-4-13 下午07:31:10 erp-stock
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
 * InApply
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class InApply {
    private Integer id;

    private String designer;

    private String reason;

    private Boolean back;

    private Date backDate;

    private List<InApplyDetail> inApplyDetailList;

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
     * 返回  designer
     * @return designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * 设置 designer
     * @param designer designer
     */
    public void setDesigner(String designer) {
        this.designer = designer;
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
     * 返回  back
     * @return back
     */
    public Boolean getBack() {
        return back;
    }

    /**
     * 设置 back
     * @param back back
     */
    public void setBack(Boolean back) {
        this.back = back;
    }

    /**
     * 返回  backDate
     * @return backDate
     */
    public Date getBackDate() {
        return backDate;
    }

    /**
     * 设置 backDate
     * @param backDate backDate
     */
    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    /**
     * 返回  inApplyDetailList
     * @return inApplyDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inApply")
    public List<InApplyDetail> getInApplyDetailList() {
        return inApplyDetailList;
    }

    /**
     * 设置 inApplyDetailList
     * @param inApplyDetailList inApplyDetailList
     */
    public void setInApplyDetailList(List<InApplyDetail> inApplyDetailList) {
        this.inApplyDetailList = inApplyDetailList;
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
}
