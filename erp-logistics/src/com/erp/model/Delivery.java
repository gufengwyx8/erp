/*
 * @(#)Delivery.java 2015-4-19 下午07:29:58 erp-logistics
 */
package com.erp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Delivery
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Delivery {
    private Integer id;

    private String consumer;

    private Product product;

    private Integer count;

    private Integer deliverCount;

    private User user;

    private Date date;
    
    private Integer price;

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
     * 返回  consumer
     * @return consumer
     */
    public String getConsumer() {
        return consumer;
    }

    /**
     * 设置 consumer
     * @param consumer consumer
     */
    public void setConsumer(String consumer) {
        this.consumer = consumer;
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
     * 返回  deliverCount
     * @return deliverCount
     */
    public Integer getDeliverCount() {
        return deliverCount;
    }

    /**
     * 设置 deliverCount
     * @param deliverCount deliverCount
     */
    public void setDeliverCount(Integer deliverCount) {
        this.deliverCount = deliverCount;
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
     * 返回  price
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置 price
     * @param price price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
