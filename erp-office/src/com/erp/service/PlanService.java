/*
 * @(#)PlanService.java 2015-4-4 обнГ02:26:58 erp-manufacture
 */
package com.erp.service;

import java.util.List;

import com.erp.model.Meeting;
import com.erp.model.Plan;

/**
 * PlanService
 * @author wang
 * @version 1.0
 *
 */
public interface PlanService extends BaseService<Plan> {
    List<Plan> listByMeeting(Meeting meeting);
}
