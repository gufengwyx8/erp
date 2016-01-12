/*
 * @(#)MaterielAction.java 2015-4-4 下午03:42:44 erp-manufacture
 */
package com.erp.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Materiel;
import com.erp.model.MaterielDetail;
import com.erp.model.Process;
import com.erp.model.ProcessDetail;

/**
 * MaterielAction
 * @author wang
 * @version 1.0
 *
 */
@Component("materielAction")
@Scope("prototype")
public class MaterielAction extends BaseAction {
    private List<Process> processList;

    private Process process;

    private List<Materiel> materielList;

    private Materiel materiel;

    private List<MaterielDetail> materielDetailList;

    private MaterielDetail materielDetail;

    public String listMateriel() {
        materielList = materielService.list();
        return SUCCESS;
    }

    public String saveMateriel() {
        materielService.saveOrUpdate(materiel);
        process = processService.getEntityById(materiel.getProcess().getId());
        for (ProcessDetail pd : process.getProcessDetailList()) {
            MaterielDetail md = new MaterielDetail();
            md.setMateriel(materiel);
            md.setProcessDetail(pd);
            materielDetailService.save(md);
        }
        return SUCCESS;
    }

    public String saveMaterielDetail() {
        materielDetailService.saveOrUpdate(materielDetail);
        msg = "success";
        return SUCCESS;
    }

    public String showMateriel() {
        materiel = materielService.getEntityById(materiel.getId());
        return SUCCESS;
    }

    public String destoryMateriel() {
        materiel = materielService.getEntityById(materiel.getId());
        for (MaterielDetail md : materiel.getMaterielDetailList()) {
            materielDetailService.delete(md);
        }
        materielService.delete(materiel);
        return SUCCESS;
    }

    /**
     * 返回  processList
     * @return processList
     */
    public List<Process> getProcessList() {
        return processList;
    }

    /**
     * 设置 processList
     * @param processList processList
     */
    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    /**
     * 返回  process
     * @return process
     */
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
     * 返回  materielList
     * @return materielList
     */
    public List<Materiel> getMaterielList() {
        return materielList;
    }

    /**
     * 设置 materielList
     * @param materielList materielList
     */
    public void setMaterielList(List<Materiel> materielList) {
        this.materielList = materielList;
    }

    /**
     * 返回  materiel
     * @return materiel
     */
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

    /**
     * 返回  materielDetailList
     * @return materielDetailList
     */
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
     * 返回  materielDetail
     * @return materielDetail
     */
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
}
