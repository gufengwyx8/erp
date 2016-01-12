/*
 * @(#)ProductServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.ProductDao;
import com.erp.model.Product;
import com.erp.service.ProductService;

/**
 * ProductServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Override
    protected BaseDao<Product> getBaseDao() {
        return productDao;
    }

}
