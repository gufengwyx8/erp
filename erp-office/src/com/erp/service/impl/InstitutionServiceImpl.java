/*
 * @(#)InstitutionServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.InstitutionDao;
import com.erp.model.Institution;
import com.erp.service.InstitutionService;

/**
 * InstitutionServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("institutionService")
public class InstitutionServiceImpl extends BaseServiceImpl<Institution> implements InstitutionService {

    @Resource(name = "institutionDao")
    private InstitutionDao institutionDao;

    @Override
    protected BaseDao<Institution> getBaseDao() {
        return institutionDao;
    }

}
