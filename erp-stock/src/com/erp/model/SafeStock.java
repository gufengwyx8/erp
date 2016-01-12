/*
 * @(#)SafeStock.java 2015-4-13 下午07:07:10 erp-stock
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
 * SafeStock
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class SafeStock {
    private Integer id;

    private Product product;

    private List<SafeStockDetail> safeStockDetailList;

    private String alertButtom;

    private String alertTop;

    private String designer;

    private User user;

    private Date date;

    private String description;

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
     * 返回  safeStockDetailList
     * @return safeStockDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "safeStock")
    public List<SafeStockDetail> getSafeStockDetailList() {
        return safeStockDetailList;
    }

    /**
     * 设置 safeStockDetailList
     * @param safeStockDetailList safeStockDetailList
     */
    public void setSafeStockDetailList(List<SafeStockDetail> safeStockDetailList) {
        this.safeStockDetailList = safeStockDetailList;
    }

    /**
     * 返回  alertButtom
     * @return alertButtom
     */
    public String getAlertButtom() {
        return alertButtom;
    }

    /**
     * 设置 alertButtom
     * @param alertButtom alertButtom
     */
    public void setAlertButtom(String alertButtom) {
        this.alertButtom = alertButtom;
    }

    /**
     * 返回  alertTop
     * @return alertTop
     */
    public String getAlertTop() {
        return alertTop;
    }

    /**
     * 设置 alertTop
     * @param alertTop alertTop
     */
    public void setAlertTop(String alertTop) {
        this.alertTop = alertTop;
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
}
