/*
 * @(#)OutApplyDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutApplyDetailDao;
import com.erp.model.OutApplyDetail;
import com.erp.service.OutApplyDetailService;

/**
 * OutApplyDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outApplyDetailService")
public class OutApplyDetailServiceImpl extends BaseServiceImpl<OutApplyDetail> implements OutApplyDetailService {

    @Resource(name = "outApplyDetailDao")
    private OutApplyDetailDao outApplyDetailDao;

    @Override
    protected BaseDao<OutApplyDetail> getBaseDao() {
        return outApplyDetailDao;
    }

}
