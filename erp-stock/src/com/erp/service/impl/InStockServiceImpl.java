/*
 * @(#)InStockServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InStockDao;
import com.erp.model.InStock;
import com.erp.service.InStockService;

/**
 * InStockServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inStockService")
public class InStockServiceImpl extends BaseServiceImpl<InStock> implements InStockService {

    @Resource(name = "inStockDao")
    private InStockDao inStockDao;

    @Override
    protected BaseDao<InStock> getBaseDao() {
        return inStockDao;
    }

}
