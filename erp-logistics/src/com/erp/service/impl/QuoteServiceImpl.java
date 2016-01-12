/*
 * @(#)QuoteServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.QuoteDao;
import com.erp.model.Quote;
import com.erp.service.QuoteService;

/**
 * QuoteServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("quoteService")
public class QuoteServiceImpl extends BaseServiceImpl<Quote> implements QuoteService {

    @Resource(name = "quoteDao")
    private QuoteDao quoteDao;

    @Override
    protected BaseDao<Quote> getBaseDao() {
        return quoteDao;
    }

}
