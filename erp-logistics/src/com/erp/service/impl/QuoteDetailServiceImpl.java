/*
 * @(#)QuoteDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.QuoteDetailDao;
import com.erp.model.QuoteDetail;
import com.erp.service.QuoteDetailService;

/**
 * QuoteDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("quoteDetailService")
public class QuoteDetailServiceImpl extends BaseServiceImpl<QuoteDetail> implements QuoteDetailService {

    @Resource(name = "quoteDetailDao")
    private QuoteDetailDao quoteDetailDao;

    @Override
    protected BaseDao<QuoteDetail> getBaseDao() {
        return quoteDetailDao;
    }

}
