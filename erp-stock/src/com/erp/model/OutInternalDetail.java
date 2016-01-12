/*
 * @(#)InInternalDetail.java 2015-4-13 下午07:37:55 erp-stock
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * InInternalDetail
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class OutInternalDetail {
    private Integer id;

    private OutInternal outInternal;

    private Product product;

    private String unit;

    private Integer count;

    private Integer price;

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
     * 返回  outInternal
     * @return outInternal
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "out_internal_id")
    public OutInternal getOutInternal() {
        return outInternal;
    }

    /**
     * 设置 outInternal
     * @param outInternal outInternal
     */
    public void setOutInternal(OutInternal outInternal) {
        this.outInternal = outInternal;
    }

}
