/*
 * @(#)KnowledgeServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.KnowledgeDao;
import com.erp.model.Knowledge;
import com.erp.service.KnowledgeService;

/**
 * KnowledgeServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("knowledgeService")
public class KnowledgeServiceImpl extends BaseServiceImpl<Knowledge> implements KnowledgeService {

    @Resource(name = "knowledgeDao")
    private KnowledgeDao knowledgeDao;

    @Override
    protected BaseDao<Knowledge> getBaseDao() {
        return knowledgeDao;
    }

}
