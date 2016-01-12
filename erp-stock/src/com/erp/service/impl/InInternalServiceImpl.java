/*
 * @(#)InInternalServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InInternalDao;
import com.erp.model.InInternal;
import com.erp.service.InInternalService;

/**
 * InInternalServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inInternalService")
public class InInternalServiceImpl extends BaseServiceImpl<InInternal> implements InInternalService {

    @Resource(name = "inInternalDao")
    private InInternalDao inInternalDao;

    @Override
    protected BaseDao<InInternal> getBaseDao() {
        return inInternalDao;
    }

}
