/*
 * @(#)OutApplyAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.OutApply;
import com.erp.model.OutApplyDetail;
import com.erp.model.Product;

/**
 * OutApplyAction
 * @author wang
 * @version 1.0
 *
 */
@Component("outApplyAction")
@Scope("prototype")
public class OutApplyAction extends BaseAction {
    private OutApply outApply;

    private List<OutApply> outApplyList;

    private OutApplyDetail outApplyDetail;

    private List<OutApplyDetail> outApplyDetailList;

    private Product product;

    private List<Product> productList;

    public String listOutApply() {
        outApplyList = outApplyService.list();
        return SUCCESS;
    }

    public String saveOutApply() {
        outApply.setDate(new Date());
        outApply.setUser(loginUser);
        outApplyService.saveOrUpdate(outApply);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutApply() {
        outApply = outApplyService.getEntityById(outApply.getId());
        for (OutApplyDetail pd : outApply.getOutApplyDetailList()) {
            outApplyDetailService.delete(pd);
        }
        outApplyService.delete(outApply);
        return SUCCESS;
    }

    public String listOutApplyDetail() {
        productList = productService.list();
        outApply = outApplyService.getEntityById(outApply.getId());
        outApplyDetailList = outApply.getOutApplyDetailList();
        return SUCCESS;
    }

    public String saveOutApplyDetail() {
        outApplyDetailService.saveOrUpdate(outApplyDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutApplyDetail() {
        outApplyDetailService.delete(outApplyDetail);
        return SUCCESS;
    }

    /**
     * 返回  outApply
     * @return outApply
     */
    public OutApply getOutApply() {
        return outApply;
    }

    /**
     * 设置 outApply
     * @param outApply outApply
     */
    public void setOutApply(OutApply outApply) {
        this.outApply = outApply;
    }

    /**
     * 返回  outApplyList
     * @return outApplyList
     */
    public List<OutApply> getOutApplyList() {
        return outApplyList;
    }

    /**
     * 设置 outApplyList
     * @param outApplyList outApplyList
     */
    public void setOutApplyList(List<OutApply> outApplyList) {
        this.outApplyList = outApplyList;
    }

    /**
     * 返回  outApplyDetail
     * @return outApplyDetail
     */
    public OutApplyDetail getOutApplyDetail() {
        return outApplyDetail;
    }

    /**
     * 设置 outApplyDetail
     * @param outApplyDetail outApplyDetail
     */
    public void setOutApplyDetail(OutApplyDetail outApplyDetail) {
        this.outApplyDetail = outApplyDetail;
    }

    /**
     * 返回  outApplyDetailList
     * @return outApplyDetailList
     */
    public List<OutApplyDetail> getOutApplyDetailList() {
        return outApplyDetailList;
    }

    /**
     * 设置 outApplyDetailList
     * @param outApplyDetailList outApplyDetailList
     */
    public void setOutApplyDetailList(List<OutApplyDetail> outApplyDetailList) {
        this.outApplyDetailList = outApplyDetailList;
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
