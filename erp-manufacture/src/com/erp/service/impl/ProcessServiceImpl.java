/*
 * @(#)ProcessServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.ProcessDao;
import com.erp.model.Process;
import com.erp.service.ProcessService;

/**
 * ProcessServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("processService")
public class ProcessServiceImpl extends BaseServiceImpl<Process> implements ProcessService {

    @Resource(name = "processDao")
    private ProcessDao processDao;

    @Override
    protected BaseDao<Process> getBaseDao() {
        return processDao;
    }

}
