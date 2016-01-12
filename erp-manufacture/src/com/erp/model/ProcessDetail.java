/*
 * @(#)Process.java 2015-4-4 下午01:39:02 erp-manufacture
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * 生产工序细节
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class ProcessDetail {
    private Integer id;

    private String name;

    private String description;

    private Integer workTime;

    private String unit;

    private Integer timeCost;
    
    private Process process;

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
     * 返回  description
     * @return description
     */
    @Lob
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
     * 返回  workTime
     * @return workTime
     */
    public Integer getWorkTime() {
        return workTime;
    }

    /**
     * 设置 workTime
     * @param workTime workTime
     */
    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
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
     * 返回  process
     * @return process
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_id")
    public Process getProcess() {
        return process;
    }

    /**
     * 设置 process
     * @param process process
     */
    public void setProcess(Process process) {
        this.process = process;
    }

    /**
     * 返回  timeCost
     * @return timeCost
     */
    public Integer getTimeCost() {
        return timeCost;
    }

    /**
     * 设置 timeCost
     * @param timeCost timeCost
     */
    public void setTimeCost(Integer timeCost) {
        this.timeCost = timeCost;
    }

}
