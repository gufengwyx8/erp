/*
 * @(#)Materiel.java 2015-4-4 下午01:59:42 erp-manufacture
 */
package com.erp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 物料
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Materiel {
    private Integer id;

    private Process process;

    private List<MaterielDetail> materielDetailList;

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
     * 返回  materielDetailList
     * @return materielDetailList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "materiel")
    public List<MaterielDetail> getMaterielDetailList() {
        return materielDetailList;
    }

    /**
     * 设置 materielDetailList
     * @param materielDetailList materielDetailList
     */
    public void setMaterielDetailList(List<MaterielDetail> materielDetailList) {
        this.materielDetailList = materielDetailList;
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

}
