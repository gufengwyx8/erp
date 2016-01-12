/*
 * @(#)Recommend.java 2015-4-19 下午07:20:44 erp-logistics
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
 * Recommend
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Recommend {
    private Integer id;

    private Product product;

    private String designer;

    private List<RecommendDetail> recommendDetailList;

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
     * 返回  recommendDetailList
     * @return recommendDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recommend")
    public List<RecommendDetail> getRecommendDetailList() {
        return recommendDetailList;
    }

    /**
     * 设置 recommendDetailList
     * @param recommendDetailList recommendDetailList
     */
    public void setRecommendDetailList(List<RecommendDetail> recommendDetailList) {
        this.recommendDetailList = recommendDetailList;
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
