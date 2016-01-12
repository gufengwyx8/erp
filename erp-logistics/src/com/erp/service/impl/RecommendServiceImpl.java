/*
 * @(#)RecommendServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RecommendDao;
import com.erp.model.Recommend;
import com.erp.service.RecommendService;

/**
 * RecommendServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("recommendService")
public class RecommendServiceImpl extends BaseServiceImpl<Recommend> implements RecommendService {

    @Resource(name = "recommendDao")
    private RecommendDao recommendDao;

    @Override
    protected BaseDao<Recommend> getBaseDao() {
        return recommendDao;
    }

}
