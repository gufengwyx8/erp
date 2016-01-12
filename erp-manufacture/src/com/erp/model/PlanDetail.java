/*
 * @(#)PlanDetail.java 2015-4-4 下午01:50:01 erp-manufacture
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
 * 生产计划细节
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class PlanDetail {
    private Integer id;

    private Product product;

    private String description;

    private Integer count;

    private String unit;

    private Date startDate;

    private Date endDate;

    private Plan plan;

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
     * 返回  product
     * @return product
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    /**
     * 设置 product
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
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
     * 返回  unit
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置 unit
     * @param unit unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
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
     * 返回  endDate
     * @return endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置 endDate
     * @param endDate endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 返回  plan
     * @return plan
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    public Plan getPlan() {
        return plan;
    }

    /**
     * 设置 plan
     * @param plan plan
     */
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
