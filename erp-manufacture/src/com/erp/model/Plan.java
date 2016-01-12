/*
 * @(#)Plan.java 2015-4-4 下午01:49:46 erp-manufacture
 */
package com.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 生产计划
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Plan {
    private Integer id;

    private String designer;
    
    private User user;

    private Date date;

    private String description;

    private List<PlanDetail> planDetailList;

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
     * 返回  description
     * @return description
     */
    @Lob
    public String getDescription() {
        return description;
    }

    /**
     * 设置 description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 返回  planDetailList
     * @return planDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
    public List<PlanDetail> getPlanDetailList() {
        return planDetailList;
    }

    /**
     * 设置 planDetailList
     * @param planDetailList planDetailList
     */
    public void setPlanDetailList(List<PlanDetail> planDetailList) {
        this.planDetailList = planDetailList;
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
}
