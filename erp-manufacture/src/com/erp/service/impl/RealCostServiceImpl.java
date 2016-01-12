/*
 * @(#)RealCostServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RealCostDao;
import com.erp.model.Dispatch;
import com.erp.model.RealCost;
import com.erp.service.RealCostService;

/**
 * RealCostServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("realCostService")
public class RealCostServiceImpl extends BaseServiceImpl<RealCost> implements RealCostService {

    @Resource(name = "realCostDao")
    private RealCostDao realCostDao;

    @Override
    protected BaseDao<RealCost> getBaseDao() {
        return realCostDao;
    }

    @Override
    public List<RealCost> listByDispatch(Dispatch dispatch) {
        return realCostDao.listByDispatch(dispatch);
    }

}
