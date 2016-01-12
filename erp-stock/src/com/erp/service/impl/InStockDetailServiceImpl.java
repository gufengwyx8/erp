/*
 * @(#)InStockDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InStockDetailDao;
import com.erp.model.InStockDetail;
import com.erp.service.InStockDetailService;

/**
 * InStockDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inStockDetailService")
public class InStockDetailServiceImpl extends BaseServiceImpl<InStockDetail> implements InStockDetailService {

    @Resource(name = "inStockDetailDao")
    private InStockDetailDao inStockDetailDao;

    @Override
    protected BaseDao<InStockDetail> getBaseDao() {
        return inStockDetailDao;
    }

}
