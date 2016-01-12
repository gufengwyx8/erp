/*
 * @(#)InInternalAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.InInternal;
import com.erp.model.InInternalDetail;
import com.erp.model.Product;

/**
 * InInternalAction
 * @author wang
 * @version 1.0
 *
 */
@Component("inInternalAction")
@Scope("prototype")
public class InInternalAction extends BaseAction {
    private InInternal inInternal;

    private List<InInternal> inInternalList;

    private InInternalDetail inInternalDetail;

    private List<InInternalDetail> inInternalDetailList;

    private Product product;

    private List<Product> productList;

    public String listInInternal() {
        inInternalList = inInternalService.list();
        return SUCCESS;
    }

    public String saveInInternal() {
        inInternal.setDate(new Date());
        inInternal.setUser(loginUser);
        inInternalService.saveOrUpdate(inInternal);
        msg = "success";
        return SUCCESS;
    }

    public String destoryInInternal() {
        inInternal = inInternalService.getEntityById(inInternal.getId());
        for (InInternalDetail pd : inInternal.getInInternalDetailList()) {
            inInternalDetailService.delete(pd);
        }
        inInternalService.delete(inInternal);
        return SUCCESS;
    }

    public String listInInternalDetail() {
        productList = productService.list();
        inInternal = inInternalService.getEntityById(inInternal.getId());
        inInternalDetailList = inInternal.getInInternalDetailList();
        return SUCCESS;
    }

    public String saveInInternalDetail() {
        inInternalDetailService.saveOrUpdate(inInternalDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryInInternalDetail() {
        inInternalDetailService.delete(inInternalDetail);
        return SUCCESS;
    }

    /**
     * 返回  inInternal
     * @return inInternal
     */
    public InInternal getInInternal() {
        return inInternal;
    }

    /**
     * 设置 inInternal
     * @param inInternal inInternal
     */
    public void setInInternal(InInternal inInternal) {
        this.inInternal = inInternal;
    }

    /**
     * 返回  inInternalList
     * @return inInternalList
     */
    public List<InInternal> getInInternalList() {
        return inInternalList;
    }

    /**
     * 设置 inInternalList
     * @param inInternalList inInternalList
     */
    public void setInInternalList(List<InInternal> inInternalList) {
        this.inInternalList = inInternalList;
    }

    /**
     * 返回  inInternalDetail
     * @return inInternalDetail
     */
    public InInternalDetail getInInternalDetail() {
        return inInternalDetail;
    }

    /**
     * 设置 inInternalDetail
     * @param inInternalDetail inInternalDetail
     */
    public void setInInternalDetail(InInternalDetail inInternalDetail) {
        this.inInternalDetail = inInternalDetail;
    }

    /**
     * 返回  inInternalDetailList
     * @return inInternalDetailList
     */
    public List<InInternalDetail> getInInternalDetailList() {
        return inInternalDetailList;
    }

    /**
     * 设置 inInternalDetailList
     * @param inInternalDetailList inInternalDetailList
     */
    public void setInInternalDetailList(List<InInternalDetail> inInternalDetailList) {
        this.inInternalDetailList = inInternalDetailList;
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
