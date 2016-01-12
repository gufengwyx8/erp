/*
 * @(#)Record.java 2015-4-19 下午07:10:26 erp-logistics
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Record
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Record {
    private Integer id;

    private String name;

    private String level;

    private String category;

    private String area;

    private String liable;

    private String tel;

    private String contactor;
    
    private String url;

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
     * 返回  level
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置 level
     * @param level level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 返回  category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置 category
     * @param category category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 返回  area
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置 area
     * @param area area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 返回  liable
     * @return liable
     */
    public String getLiable() {
        return liable;
    }

    /**
     * 设置 liable
     * @param liable liable
     */
    public void setLiable(String liable) {
        this.liable = liable;
    }

    /**
     * 返回  tel
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置 tel
     * @param tel tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 返回  contactor
     * @return contactor
     */
    public String getContactor() {
        return contactor;
    }

    /**
     * 设置 contactor
     * @param contactor contactor
     */
    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    /**
     * 返回  url
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 url
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
