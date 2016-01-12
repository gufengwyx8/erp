/*
 * @(#)OutInternalDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutInternalDetailDao;
import com.erp.model.OutInternalDetail;
import com.erp.service.OutInternalDetailService;

/**
 * OutInternalDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outInternalDetailService")
public class OutInternalDetailServiceImpl extends BaseServiceImpl<OutInternalDetail> implements OutInternalDetailService {

    @Resource(name = "outInternalDetailDao")
    private OutInternalDetailDao outInternalDetailDao;

    @Override
    protected BaseDao<OutInternalDetail> getBaseDao() {
        return outInternalDetailDao;
    }

}
