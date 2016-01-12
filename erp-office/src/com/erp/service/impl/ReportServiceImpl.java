/*
 * @(#)ReportServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.ReportDao;
import com.erp.model.Report;
import com.erp.service.ReportService;

/**
 * ReportServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("reportService")
public class ReportServiceImpl extends BaseServiceImpl<Report> implements ReportService {

    @Resource(name = "reportDao")
    private ReportDao reportDao;

    @Override
    protected BaseDao<Report> getBaseDao() {
        return reportDao;
    }

}
