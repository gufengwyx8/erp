/*
 * @(#)InApplyAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.InApply;
import com.erp.model.InApplyDetail;
import com.erp.model.Product;

/**
 * InApplyAction
 * @author wang
 * @version 1.0
 *
 */
@Component("inApplyAction")
@Scope("prototype")
public class InApplyAction extends BaseAction {
    private InApply inApply;

    private List<InApply> inApplyList;

    private InApplyDetail inApplyDetail;

    private List<InApplyDetail> inApplyDetailList;

    private Product product;

    private List<Product> productList;

    public String listInApply() {
        inApplyList = inApplyService.list();
        return SUCCESS;
    }

    public String saveInApply() {
        inApply.setDate(new Date());
        inApply.setUser(loginUser);
        inApplyService.saveOrUpdate(inApply);
        msg = "success";
        return SUCCESS;
    }

    public String destoryInApply() {
        inApply = inApplyService.getEntityById(inApply.getId());
        for (InApplyDetail pd : inApply.getInApplyDetailList()) {
            inApplyDetailService.delete(pd);
        }
        inApplyService.delete(inApply);
        return SUCCESS;
    }

    public String listInApplyDetail() {
        productList = productService.list();
        inApply = inApplyService.getEntityById(inApply.getId());
        inApplyDetailList = inApply.getInApplyDetailList();
        return SUCCESS;
    }

    public String saveInApplyDetail() {
        inApplyDetailService.saveOrUpdate(inApplyDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryInApplyDetail() {
        inApplyDetailService.delete(inApplyDetail);
        return SUCCESS;
    }

    /**
     * 返回  inApply
     * @return inApply
     */
    public InApply getInApply() {
        return inApply;
    }

    /**
     * 设置 inApply
     * @param inApply inApply
     */
    public void setInApply(InApply inApply) {
        this.inApply = inApply;
    }

    /**
     * 返回  inApplyList
     * @return inApplyList
     */
    public List<InApply> getInApplyList() {
        return inApplyList;
    }

    /**
     * 设置 inApplyList
     * @param inApplyList inApplyList
     */
    public void setInApplyList(List<InApply> inApplyList) {
        this.inApplyList = inApplyList;
    }

    /**
     * 返回  inApplyDetail
     * @return inApplyDetail
     */
    public InApplyDetail getInApplyDetail() {
        return inApplyDetail;
    }

    /**
     * 设置 inApplyDetail
     * @param inApplyDetail inApplyDetail
     */
    public void setInApplyDetail(InApplyDetail inApplyDetail) {
        this.inApplyDetail = inApplyDetail;
    }

    /**
     * 返回  inApplyDetailList
     * @return inApplyDetailList
     */
    public List<InApplyDetail> getInApplyDetailList() {
        return inApplyDetailList;
    }

    /**
     * 设置 inApplyDetailList
     * @param inApplyDetailList inApplyDetailList
     */
    public void setInApplyDetailList(List<InApplyDetail> inApplyDetailList) {
        this.inApplyDetailList = inApplyDetailList;
    }

    /**
     * 返回  product
     * @return product
     */
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
     * 返回  productList
     * @return productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * 设置 productList
     * @param productList productList
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
