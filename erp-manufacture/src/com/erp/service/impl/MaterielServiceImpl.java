/*
 * @(#)MaterielServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.MaterielDao;
import com.erp.model.Materiel;
import com.erp.model.Product;
import com.erp.service.MaterielService;

/**
 * MaterielServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("materielService")
public class MaterielServiceImpl extends BaseServiceImpl<Materiel> implements MaterielService {

    @Resource(name = "materielDao")
    private MaterielDao materielDao;

    @Override
    protected BaseDao<Materiel> getBaseDao() {
        return materielDao;
    }

    @Override
    public List<Materiel> listByProduct(Product product) {
        return materielDao.listByProduct(product);
    }

}
