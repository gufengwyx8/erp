/*
 * @(#)SafeStockAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.SafeStock;
import com.erp.model.SafeStockDetail;
import com.erp.model.Product;

/**
 * SafeStockAction
 * @author wang
 * @version 1.0
 *
 */
@Component("safeStockAction")
@Scope("prototype")
public class SafeStockAction extends BaseAction {
    private SafeStock safeStock;

    private List<SafeStock> safeStockList;

    private SafeStockDetail safeStockDetail;

    private List<SafeStockDetail> safeStockDetailList;

    private Product product;

    private List<Product> productList;

    public String listSafeStock() {
        safeStockList = safeStockService.list();
        productList = productService.list();
        return SUCCESS;
    }

    public String saveSafeStock() {
        safeStock.setDate(new Date());
        safeStock.setUser(loginUser);
        safeStockService.saveOrUpdate(safeStock);
        msg = "success";
        return SUCCESS;
    }

    public String destorySafeStock() {
        safeStock = safeStockService.getEntityById(safeStock.getId());
        for (SafeStockDetail pd : safeStock.getSafeStockDetailList()) {
            safeStockDetailService.delete(pd);
        }
        safeStockService.delete(safeStock);
        return SUCCESS;
    }

    public String listSafeStockDetail() {
        safeStock = safeStockService.getEntityById(safeStock.getId());
        safeStockDetailList = safeStock.getSafeStockDetailList();
        return SUCCESS;
    }

    public String saveSafeStockDetail() {
        safeStockDetailService.saveOrUpdate(safeStockDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destorySafeStockDetail() {
        safeStockDetailService.delete(safeStockDetail);
        return SUCCESS;
    }

    /**
     * 返回  safeStock
     * @return safeStock
     */
    public SafeStock getSafeStock() {
        return safeStock;
    }

    /**
     * 设置 safeStock
     * @param safeStock safeStock
     */
    public void setSafeStock(SafeStock safeStock) {
        this.safeStock = safeStock;
    }

    /**
     * 返回  safeStockList
     * @return safeStockList
     */
    public List<SafeStock> getSafeStockList() {
        return safeStockList;
    }

    /**
     * 设置 safeStockList
     * @param safeStockList safeStockList
     */
    public void setSafeStockList(List<SafeStock> safeStockList) {
        this.safeStockList = safeStockList;
    }

    /**
     * 返回  safeStockDetail
     * @return safeStockDetail
     */
    public SafeStockDetail getSafeStockDetail() {
        return safeStockDetail;
    }

    /**
     * 设置 safeStockDetail
     * @param safeStockDetail safeStockDetail
     */
    public void setSafeStockDetail(SafeStockDetail safeStockDetail) {
        this.safeStockDetail = safeStockDetail;
    }

    /**
     * 返回  safeStockDetailList
     * @return safeStockDetailList
     */
    public List<SafeStockDetail> getSafeStockDetailList() {
        return safeStockDetailList;
    }

    /**
     * 设置 safeStockDetailList
     * @param safeStockDetailList safeStockDetailList
     */
    public void setSafeStockDetailList(List<SafeStockDetail> safeStockDetailList) {
        this.safeStockDetailList = safeStockDetailList;
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
