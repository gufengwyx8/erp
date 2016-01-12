/*
 * @(#)RealCost.java 2015-4-4 下午02:12:17 erp-manufacture
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 实际成本
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class RealCost {
    private Integer id;

    private MaterielDetail materielDetail;

    private Integer time;

    private Integer timeCost;

    private Integer materielCost;

    private Dispatch dispatch;

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
     * 返回  materielDetail
     * @return materielDetail
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materiel_detail_id")
    public MaterielDetail getMaterielDetail() {
        return materielDetail;
    }

    /**
     * 设置 materielDetail
     * @param materielDetail materielDetail
     */
    public void setMaterielDetail(MaterielDetail materielDetail) {
        this.materielDetail = materielDetail;
    }

    /**
     * 返回  time
     * @return time
     */
    public Integer getTime() {
        return time;
    }

    /**
     * 设置 time
     * @param time time
     */
    public void setTime(Integer time) {
        this.time = time;
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

    /**
     * 返回  materielCost
     * @return materielCost
     */
    public Integer getMaterielCost() {
        return materielCost;
    }

    /**
     * 设置 materielCost
     * @param materielCost materielCost
     */
    public void setMaterielCost(Integer materielCost) {
        this.materielCost = materielCost;
    }

    /**
     * 返回  dispatch
     * @return dispatch
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatch_id")
    public Dispatch getDispatch() {
        return dispatch;
    }

    /**
     * 设置 dispatch
     * @param dispatch dispatch
     */
    public void setDispatch(Dispatch dispatch) {
        this.dispatch = dispatch;
    }
}
