/*
 * @(#)OutStockAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.OutStock;
import com.erp.model.OutStockDetail;
import com.erp.model.Product;

/**
 * OutStockAction
 * @author wang
 * @version 1.0
 *
 */
@Component("outStockAction")
@Scope("prototype")
public class OutStockAction extends BaseAction {
    private OutStock outStock;

    private List<OutStock> outStockList;

    private OutStockDetail outStockDetail;

    private List<OutStockDetail> outStockDetailList;

    private Product product;

    private List<Product> productList;

    public String listOutStock() {
        outStockList = outStockService.list();
        return SUCCESS;
    }

    public String saveOutStock() {
        outStock.setDate(new Date());
        outStock.setUser(loginUser);
        outStockService.saveOrUpdate(outStock);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutStock() {
        outStock = outStockService.getEntityById(outStock.getId());
        for (OutStockDetail pd : outStock.getOutStockDetailList()) {
            outStockDetailService.delete(pd);
        }
        outStockService.delete(outStock);
        return SUCCESS;
    }

    public String listOutStockDetail() {
        productList = productService.list();
        outStock = outStockService.getEntityById(outStock.getId());
        outStockDetailList = outStock.getOutStockDetailList();
        return SUCCESS;
    }

    public String saveOutStockDetail() {
        outStockDetailService.saveOrUpdate(outStockDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryOutStockDetail() {
        outStockDetailService.delete(outStockDetail);
        return SUCCESS;
    }

    /**
     * 返回  outStock
     * @return outStock
     */
    public OutStock getOutStock() {
        return outStock;
    }

    /**
     * 设置 outStock
     * @param outStock outStock
     */
    public void setOutStock(OutStock outStock) {
        this.outStock = outStock;
    }

    /**
     * 返回  outStockList
     * @return outStockList
     */
    public List<OutStock> getOutStockList() {
        return outStockList;
    }

    /**
     * 设置 outStockList
     * @param outStockList outStockList
     */
    public void setOutStockList(List<OutStock> outStockList) {
        this.outStockList = outStockList;
    }

    /**
     * 返回  outStockDetail
     * @return outStockDetail
     */
    public OutStockDetail getOutStockDetail() {
        return outStockDetail;
    }

    /**
     * 设置 outStockDetail
     * @param outStockDetail outStockDetail
     */
    public void setOutStockDetail(OutStockDetail outStockDetail) {
        this.outStockDetail = outStockDetail;
    }

    /**
     * 返回  outStockDetailList
     * @return outStockDetailList
     */
    public List<OutStockDetail> getOutStockDetailList() {
        return outStockDetailList;
    }

    /**
     * 设置 outStockDetailList
     * @param outStockDetailList outStockDetailList
     */
    public void setOutStockDetailList(List<OutStockDetail> outStockDetailList) {
        this.outStockDetailList = outStockDetailList;
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
