/*
 * @(#)RealCostDaoImpl.java 2015-4-4 ÏÂÎç02:29:05 erp-manufacture
 */
package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.erp.dao.RealCostDao;
import com.erp.model.Dispatch;
import com.erp.model.RealCost;

/**
 * RealCostDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("realCostDao")
public class RealCostDaoImpl extends BaseDaoImpl<RealCost> implements RealCostDao {

    @Override
    public List<RealCost> listByDispatch(Dispatch dispatch) {
        String hql = "from RealCost r where r.dispatch = ?";
        Object[] params = { dispatch };
        return this.list(RealCost.class, hql, params);
    }

}
