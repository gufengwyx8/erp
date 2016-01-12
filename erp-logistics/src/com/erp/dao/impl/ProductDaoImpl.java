/*
 * @(#)ProductDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.ProductDao;
import com.erp.model.Product;

/**
 * ProductDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

}
