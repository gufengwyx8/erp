/*
 * @(#)DispatchDao.java 2015-4-4 обнГ02:26:58
 * erp-manufacture
 */
package com.erp.dao;

import java.util.List;

import com.erp.model.Materiel;
import com.erp.model.Product;

/**
 * DispatchDao
 * @author wang
 * @version 1.0
 *
 */
public interface MaterielDao extends BaseDao<Materiel> {
    List<Materiel> listByProduct(Product product);
}
