/*
 * @(#)PlanServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.PlanDao;
import com.erp.model.Meeting;
import com.erp.model.Plan;
import com.erp.service.PlanService;

/**
 * PlanServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("planService")
public class PlanServiceImpl extends BaseServiceImpl<Plan> implements PlanService {

    @Resource(name = "planDao")
    private PlanDao planDao;

    @Override
    protected BaseDao<Plan> getBaseDao() {
        return planDao;
    }

    @Override
    public List<Plan> listByMeeting(Meeting meeting) {
        return planDao.listByMeeting(meeting);
    }

}
