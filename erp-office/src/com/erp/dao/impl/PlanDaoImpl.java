/*
 * @(#)PlanDaoImpl.java 2015-4-4 обнГ02:29:05 erp-manufacture
 */
package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.erp.dao.PlanDao;
import com.erp.model.Meeting;
import com.erp.model.Plan;

/**
 * PlanDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("planDao")
public class PlanDaoImpl extends BaseDaoImpl<Plan> implements PlanDao {

    @Override
    public List<Plan> listByMeeting(Meeting meeting) {
        String hql = "from Plan p where p.meeting = ?";
        Object[] params = { meeting };
        return this.list(Plan.class, hql, params);
    }

}
