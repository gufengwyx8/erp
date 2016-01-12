/*
 * @(#)MaterielService.java 2015-4-4 обнГ02:34:00 erp-manufacture
 */
package com.erp.service;

import java.util.List;

import com.erp.model.Materiel;
import com.erp.model.Product;

/**
 * MaterielService
 * @author wang
 * @version 1.0
 *
 */
public interface MaterielService extends BaseService<Materiel> {
    List<Materiel> listByProduct(Product product);
}
