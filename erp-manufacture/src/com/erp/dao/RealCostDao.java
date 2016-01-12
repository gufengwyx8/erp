/*
 * @(#)DispatchDao.java 2015-4-4 обнГ02:26:58
 * erp-manufacture
 */
package com.erp.dao;

import java.util.List;

import com.erp.model.Dispatch;
import com.erp.model.RealCost;


/**
 * DispatchDao
 * @author wang
 * @version 1.0
 *
 */
public interface RealCostDao extends BaseDao<RealCost> {
    List<RealCost> listByDispatch(Dispatch dispatch);
}
