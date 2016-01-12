/*
 * @(#)ProcessDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.ProcessDetailDao;
import com.erp.model.ProcessDetail;
import com.erp.service.ProcessDetailService;

/**
 * ProcessDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("processDetailService")
public class ProcessDetailServiceImpl extends BaseServiceImpl<ProcessDetail> implements ProcessDetailService {

    @Resource(name = "processDetailDao")
    private ProcessDetailDao processDetailDao;

    @Override
    protected BaseDao<ProcessDetail> getBaseDao() {
        return processDetailDao;
    }

}
