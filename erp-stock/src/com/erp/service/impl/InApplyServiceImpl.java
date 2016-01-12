/*
 * @(#)InApplyServiceImpl.java 2015-4-4 ÏÂÎç02:29:05
 * erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InApplyDao;
import com.erp.model.InApply;
import com.erp.service.InApplyService;

/**
 * InApplyServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inApplyService")
public class InApplyServiceImpl extends BaseServiceImpl<InApply> implements InApplyService {

    @Resource(name="inApplyDao")
    private InApplyDao inApplyDao;
    
    @Override
    protected BaseDao<InApply> getBaseDao() {
        return inApplyDao;
    }
}
