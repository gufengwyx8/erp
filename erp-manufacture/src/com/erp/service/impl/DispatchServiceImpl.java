/*
 * @(#)DispatchServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.DispatchDao;
import com.erp.model.Dispatch;
import com.erp.service.DispatchService;

/**
 * DispatchServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("dispatchService")
public class DispatchServiceImpl extends BaseServiceImpl<Dispatch> implements DispatchService {

    @Resource(name = "dispatchDao")
    private DispatchDao dispatchDao;

    @Override
    protected BaseDao<Dispatch> getBaseDao() {
        return dispatchDao;
    }

}
