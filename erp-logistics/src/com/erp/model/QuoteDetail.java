/*
 * @(#)QuoteDetail.java 2015-4-19 下午07:13:51 erp-logistics
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * QuoteDetail
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class QuoteDetail {
    private Integer id;

    private Product product;

    private String description;

    private Integer count;

    private String unit;

    private Integer price;

    private Integer discount;

    private Quote quote;

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
     * 返回  discount
     * @return discount
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * 设置 discount
     * @param discount discount
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * 返回  quote
     * @return quote
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    public Quote getQuote() {
        return quote;
    }

    /**
     * 设置 quote
     * @param quote quote
     */
    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
