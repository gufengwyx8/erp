/*
 * @(#)SafeStockDetail.java 2015-4-13 下午07:17:09 erp-stock
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * SafeStockDetail
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class SafeStockDetail {
    private Integer id;

    private String name;

    private String address;

    private String maxCount;

    private String unit;

    private SafeStock safeStock;

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
     * 返回  address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 address
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 返回  maxCount
     * @return maxCount
     */
    public String getMaxCount() {
        return maxCount;
    }

    /**
     * 设置 maxCount
     * @param maxCount maxCount
     */
    public void setMaxCount(String maxCount) {
        this.maxCount = maxCount;
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
     * 返回  safeStock
     * @return safeStock
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "safe_stock_id")
    public SafeStock getSafeStock() {
        return safeStock;
    }

    /**
     * 设置 safeStock
     * @param safeStock safeStock
     */
    public void setSafeStock(SafeStock safeStock) {
        this.safeStock = safeStock;
    }
}
