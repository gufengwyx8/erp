/*
 * @(#)OutInternalServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutInternalDao;
import com.erp.model.OutInternal;
import com.erp.service.OutInternalService;

/**
 * OutInternalServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outInternalService")
public class OutInternalServiceImpl extends BaseServiceImpl<OutInternal> implements OutInternalService {

    @Resource(name = "outInternalDao")
    private OutInternalDao outInternalDao;

    @Override
    protected BaseDao<OutInternal> getBaseDao() {
        return outInternalDao;
    }

}
