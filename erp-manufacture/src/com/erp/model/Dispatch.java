/*
 * @(#)Dispatch.java 2015-4-4 下午01:54:21 erp-manufacture
 */
package com.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 派工
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Dispatch {
    private Integer id;

    private String designer;

    private User user;

    private Date date;

    private Date startDate;

    private Date endDate;

    private Product product;

    private String description;

    private Integer count;

    private Materiel materiel;

    private String remark;

    private List<RealCost> realCost;

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
     * 返回  designer
     * @return designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * 设置 designer
     * @param designer designer
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * 返回  user
     * @return user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
     * 设置 user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回  startDate
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置 startDate
     * @param startDate startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 返回  endDate
     * @return endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置 endDate
     * @param endDate endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    /**
     * 返回  remark
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 remark
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 返回  realCost
     * @return realCost
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dispatch")
    public List<RealCost> getRealCost() {
        return realCost;
    }

    /**
     * 设置 realCost
     * @param realCost realCost
     */
    public void setRealCost(List<RealCost> realCost) {
        this.realCost = realCost;
    }

}
