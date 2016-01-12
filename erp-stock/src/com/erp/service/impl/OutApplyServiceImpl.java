/*
 * @(#)OutApplyServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.OutApplyDao;
import com.erp.model.OutApply;
import com.erp.service.OutApplyService;

/**
 * OutApplyServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("outApplyService")
public class OutApplyServiceImpl extends BaseServiceImpl<OutApply> implements OutApplyService {

    @Resource(name = "outApplyDao")
    private OutApplyDao outApplyDao;

    @Override
    protected BaseDao<OutApply> getBaseDao() {
        return outApplyDao;
    }

}
