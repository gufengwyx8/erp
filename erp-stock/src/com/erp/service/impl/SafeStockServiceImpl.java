/*
 * @(#)SafeStockServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.SafeStockDao;
import com.erp.model.SafeStock;
import com.erp.service.SafeStockService;

/**
 * SafeStockServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("safeStockService")
public class SafeStockServiceImpl extends BaseServiceImpl<SafeStock> implements SafeStockService {

    @Resource(name = "safeStockDao")
    private SafeStockDao safeStockDao;

    @Override
    protected BaseDao<SafeStock> getBaseDao() {
        return safeStockDao;
    }

}
