/*
 * @(#)PlanDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.PlanDetailDao;
import com.erp.model.PlanDetail;
import com.erp.service.PlanDetailService;

/**
 * PlanDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("planDetailService")
public class PlanDetailServiceImpl extends BaseServiceImpl<PlanDetail> implements PlanDetailService {

    @Resource(name = "planDetailDao")
    private PlanDetailDao planDetailDao;

    @Override
    protected BaseDao<PlanDetail> getBaseDao() {
        return planDetailDao;
    }

}
