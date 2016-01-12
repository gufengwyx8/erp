/*
 * @(#)SafeStockDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.SafeStockDetailDao;
import com.erp.model.SafeStockDetail;
import com.erp.service.SafeStockDetailService;

/**
 * SafeStockDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("safeStockDetailService")
public class SafeStockDetailServiceImpl extends BaseServiceImpl<SafeStockDetail> implements SafeStockDetailService {

    @Resource(name = "safeStockDetailDao")
    private SafeStockDetailDao safeStockDetailDao;

    @Override
    protected BaseDao<SafeStockDetail> getBaseDao() {
        return safeStockDetailDao;
    }

}
