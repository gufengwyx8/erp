/*
 * @(#)OutStockDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutStockDetailDao;
import com.erp.model.OutStockDetail;
import com.erp.service.OutStockDetailService;

/**
 * OutStockDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outStockDetailService")
public class OutStockDetailServiceImpl extends BaseServiceImpl<OutStockDetail> implements OutStockDetailService {

    @Resource(name = "outStockDetailDao")
    private OutStockDetailDao outStockDetailDao;

    @Override
    protected BaseDao<OutStockDetail> getBaseDao() {
        return outStockDetailDao;
    }

}
