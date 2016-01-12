/*
 * @(#)ReportAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Report;

/**
 * ReportAction
 * @author wang
 * @version 1.0
 *
 */
@Component("reportAction")
@Scope("prototype")
public class ReportAction extends BaseAction {

    public static final String UPLOAD_PATH = "/upload/report";

    private Report report;

    private List<Report> reportList;

    private String content;

    public String listReport() {
        reportList = reportService.list();
        return SUCCESS;
    }

    public String saveReport() {
        report.setDate(new Date());
        report.setUser(loginUser);
        reportService.saveOrUpdate(report);
        msg = "success";
        return SUCCESS;
    }

    public String destoryReport() {
        report = reportService.getEntityById(report.getId());
        reportService.delete(report);
        return SUCCESS;
    }

    public String listReportDetail() {
        report = reportService.getEntityById(report.getId());
        return SUCCESS;
    }

    public String submitContent() {
        report = reportService.getEntityById(report.getId());
        report.setContent(content);
        reportService.saveOrUpdate(report);
        return SUCCESS;
    }

    /**
     * 返回  report
     * @return report
     */
    public Report getReport() {
        return report;
    }

    /**
     * 设置 report
     * @param report report
     */
    public void setReport(Report report) {
        this.report = report;
    }

    /**
     * 返回  reportList
     * @return reportList
     */
    public List<Report> getReportList() {
        return reportList;
    }

    /**
     * 设置 reportList
     * @param reportList reportList
     */
    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setContent(String content) {
        this.content = content;
    }

}
