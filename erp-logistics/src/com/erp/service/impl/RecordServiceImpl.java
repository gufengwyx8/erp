/*
 * @(#)RecordServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.RecordDao;
import com.erp.model.Record;
import com.erp.service.RecordService;

/**
 * RecordServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("recordService")
public class RecordServiceImpl extends BaseServiceImpl<Record> implements RecordService {

    @Resource(name = "recordDao")
    private RecordDao recordDao;

    @Override
    protected BaseDao<Record> getBaseDao() {
        return recordDao;
    }

}
