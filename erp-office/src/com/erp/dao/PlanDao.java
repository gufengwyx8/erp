/*
 * @(#)PlanDao.java 2015-4-4 обнГ02:26:58
 * erp-manufacture
 */
package com.erp.dao;

import java.util.List;

import com.erp.model.Meeting;
import com.erp.model.Plan;

/**
 * PlanDao
 * @author wang
 * @version 1.0
 *
 */
public interface PlanDao extends BaseDao<Plan> {
    List<Plan> listByMeeting(Meeting meeting);
}
