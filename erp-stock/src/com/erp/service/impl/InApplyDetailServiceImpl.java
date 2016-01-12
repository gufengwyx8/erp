/*
 * @(#)InApplyDetailServiceImpl.java 2015-4-4 ÏÂÎç02:29:05 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InApplyDetailDao;
import com.erp.model.InApplyDetail;
import com.erp.service.InApplyDetailService;

/**
 * InApplyDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("inApplyDetailService")
public class InApplyDetailServiceImpl extends BaseServiceImpl<InApplyDetail> implements InApplyDetailService {

    @Resource(name = "inApplyDetailDao")
    private InApplyDetailDao inApplyDetailDao;

    @Override
    protected BaseDao<InApplyDetail> getBaseDao() {
        return inApplyDetailDao;
    }

}
