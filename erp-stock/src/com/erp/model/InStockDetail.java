/*
 * @(#)InStockDetail.java 2015-4-13 下午07:44:58 erp-stock
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * InStockDetail
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class InStockDetail {
    private Integer id;

    private Product product;

    private String name;

    private Integer curCount;

    private Integer count;

    private InStock inStock;

    private Integer qualified;

    private Integer alreadyCount;

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
     * 返回  curCount
     * @return curCount
     */
    public Integer getCurCount() {
        return curCount;
    }

    /**
     * 设置 curCount
     * @param curCount curCount
     */
    public void setCurCount(Integer curCount) {
        this.curCount = curCount;
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
     * 返回  qualified
     * @return qualified
     */
    public Integer getQualified() {
        return qualified;
    }

    /**
     * 设置 qualified
     * @param qualified qualified
     */
    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }

    /**
     * 返回  alreadyCount
     * @return alreadyCount
     */
    public Integer getAlreadyCount() {
        return alreadyCount;
    }

    /**
     * 设置 alreadyCount
     * @param alreadyCount alreadyCount
     */
    public void setAlreadyCount(Integer alreadyCount) {
        this.alreadyCount = alreadyCount;
    }

    /**
     * 返回  inStock
     * @return inStock
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "in_stock_id")
    public InStock getInStock() {
        return inStock;
    }

    /**
     * 设置 inStock
     * @param inStock inStock
     */
    public void setInStock(InStock inStock) {
        this.inStock = inStock;
    }
}
