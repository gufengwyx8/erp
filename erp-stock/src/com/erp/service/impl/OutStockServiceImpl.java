/*
 * @(#)OutStockServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutStockDao;
import com.erp.model.OutStock;
import com.erp.service.OutStockService;

/**
 * OutStockServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outStockService")
public class OutStockServiceImpl extends BaseServiceImpl<OutStock> implements OutStockService {

    @Resource(name = "outStockDao")
    private OutStockDao outStockDao;

    @Override
    protected BaseDao<OutStock> getBaseDao() {
        return outStockDao;
    }

}
