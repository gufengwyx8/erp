/*
 * @(#)RealCostService.java 2015-4-4 обнГ02:34:00 erp-manufacture
 */
package com.erp.service;

import java.util.List;

import com.erp.model.Dispatch;
import com.erp.model.RealCost;

/**
 * RealCostService
 * @author wang
 * @version 1.0
 *
 */
public interface RealCostService extends BaseService<RealCost> {
    List<RealCost> listByDispatch(Dispatch dispatch);
}
