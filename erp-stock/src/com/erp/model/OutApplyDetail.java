/*
 * @(#)InApplyDetail.java 2015-4-13 下午07:32:12 erp-stock
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * InApplyDetail
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class OutApplyDetail {
    private Integer id;

    private Product product;

    private Integer count;

    private String unit;

    private Integer price;

    private OutApply outApply;

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

    /**
     * 返回  outApply
     * @return outApply
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "out_apply_id")
    public OutApply getOutApply() {
        return outApply;
    }

    /**
     * 设置 outApply
     * @param outApply outApply
     */
    public void setOutApply(OutApply outApply) {
        this.outApply = outApply;
    }

}
