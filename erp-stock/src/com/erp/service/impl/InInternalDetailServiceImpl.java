/*
 * @(#)InInternalDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InInternalDetailDao;
import com.erp.model.InInternalDetail;
import com.erp.service.InInternalDetailService;

/**
 * InInternalDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inInternalDetailService")
public class InInternalDetailServiceImpl extends BaseServiceImpl<InInternalDetail> implements InInternalDetailService {

    @Resource(name = "inInternalDetailDao")
    private InInternalDetailDao inInternalDetailDao;

    @Override
    protected BaseDao<InInternalDetail> getBaseDao() {
        return inInternalDetailDao;
    }

}
