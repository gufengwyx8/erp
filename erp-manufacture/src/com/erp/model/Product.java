/*
 * @(#)Product.java 2015-4-4 下午01:33:18
 * erp-manufacture
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Product
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Product {
    private Integer id;
    
    private String name;

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
    
}
