/*
 * @(#)RecommendDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RecommendDetailDao;
import com.erp.model.RecommendDetail;
import com.erp.service.RecommendDetailService;

/**
 * RecommendDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("recommendDetailService")
public class RecommendDetailServiceImpl extends BaseServiceImpl<RecommendDetail> implements RecommendDetailService {

    @Resource(name = "recommendDetailDao")
    private RecommendDetailDao recommendDetailDao;

    @Override
    protected BaseDao<RecommendDetail> getBaseDao() {
        return recommendDetailDao;
    }

}
