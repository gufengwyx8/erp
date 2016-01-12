/*
 * @(#)MaterielDetail.java 2015-4-4 下午01:59:49 erp-manufacture
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 物料细节
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class MaterielDetail {
    private Integer id;

    private ProcessDetail processDetail;

    private Integer cost;

    private Materiel materiel;

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
     * 返回  processDetail
     * @return processDetail
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_detail_id")
    public ProcessDetail getProcessDetail() {
        return processDetail;
    }

    /**
     * 设置 processDetail
     * @param processDetail processDetail
     */
    public void setProcessDetail(ProcessDetail processDetail) {
        this.processDetail = processDetail;
    }

    /**
     * 返回  cost
     * @return cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * 设置 cost
     * @param cost cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * 返回  materiel
     * @return materiel
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materiel_id")
    public Materiel getMateriel() {
        return materiel;
    }

    /**
     * 设置 materiel
     * @param materiel materiel
     */
    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

}
