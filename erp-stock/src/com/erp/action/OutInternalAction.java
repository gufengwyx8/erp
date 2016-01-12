/*
 * @(#)OutInternalAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.OutInternal;
import com.erp.model.OutInternalDetail;
import com.erp.model.Product;

/**
 * OutInternalAction
 * @author wang
 * @version 1.0
 *
 */
@Component("outInternalAction")
@Scope("prototype")
public class OutInternalAction extends BaseAction {
    private OutInternal outInternal;

    private List<OutInternal> outInternalList;

    private OutInternalDetail outInternalDetail;

    private List<OutInternalDetail> outInternalDetailList;

    private Product product;

    private List<Product> productList;

    public String listOutInternal() {
        outInternalList = outInternalService.list();
        return SUCCESS;
    }

    public String saveOutInternal() {
        outInternal.setDate(new Date());
        outInternal.setUser(loginUser);
        outInternalService.saveOrUpdate(outInternal);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutInternal() {
        outInternal = outInternalService.getEntityById(outInternal.getId());
        for (OutInternalDetail pd : outInternal.getOutInternalDetailList()) {
            outInternalDetailService.delete(pd);
        }
        outInternalService.delete(outInternal);
        return SUCCESS;
    }

    public String listOutInternalDetail() {
        productList = productService.list();
        outInternal = outInternalService.getEntityById(outInternal.getId());
        outInternalDetailList = outInternal.getOutInternalDetailList();
        return SUCCESS;
    }

    public String saveOutInternalDetail() {
        outInternalDetailService.saveOrUpdate(outInternalDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutInternalDetail() {
        outInternalDetailService.delete(outInternalDetail);
        return SUCCESS;
    }

    /**
     * 返回  outInternal
     * @return outInternal
     */
    public OutInternal getOutInternal() {
        return outInternal;
    }

    /**
     * 设置 outInternal
     * @param outInternal outInternal
     */
    public void setOutInternal(OutInternal outInternal) {
        this.outInternal = outInternal;
    }

    /**
     * 返回  outInternalList
     * @return outInternalList
     */
    public List<OutInternal> getOutInternalList() {
        return outInternalList;
    }

    /**
     * 设置 outInternalList
     * @param outInternalList outInternalList
     */
    public void setOutInternalList(List<OutInternal> outInternalList) {
        this.outInternalList = outInternalList;
    }

    /**
     * 返回  outInternalDetail
     * @return outInternalDetail
     */
    public OutInternalDetail getOutInternalDetail() {
        return outInternalDetail;
    }

    /**
     * 设置 outInternalDetail
     * @param outInternalDetail outInternalDetail
     */
    public void setOutInternalDetail(OutInternalDetail outInternalDetail) {
        this.outInternalDetail = outInternalDetail;
    }

    /**
     * 返回  outInternalDetailList
     * @return outInternalDetailList
     */
    public List<OutInternalDetail> getOutInternalDetailList() {
        return outInternalDetailList;
    }

    /**
     * 设置 outInternalDetailList
     * @param outInternalDetailList outInternalDetailList
     */
    public void setOutInternalDetailList(List<OutInternalDetail> outInternalDetailList) {
        this.outInternalDetailList = outInternalDetailList;
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
