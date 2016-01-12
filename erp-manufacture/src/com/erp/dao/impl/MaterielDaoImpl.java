/*
 * @(#)MaterielDaoImpl.java 2015-4-4 ÏÂÎç02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.erp.dao.MaterielDao;
import com.erp.model.Materiel;
import com.erp.model.Product;

/**
 * MaterielDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("materielDao")
public class MaterielDaoImpl extends BaseDaoImpl<Materiel> implements MaterielDao {

    @Override
    public List<Materiel> listByProduct(Product product) {
        String hql="from Materiel m where m.process.product = ?";
        Object[] params={product};
        return this.list(Materiel.class, hql, params);
    }

}
