/*
 * @(#)RecordAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Record;

/**
 * RecordAction
 * @author wang
 * @version 1.0
 *
 */
@Component("recordAction")
@Scope("prototype")
public class RecordAction extends BaseAction {
    private Record record;

    private List<Record> recordList;

    public String listRecord() {
        recordList = recordService.list();
        return SUCCESS;
    }

    public String saveRecord() {
        recordService.saveOrUpdate(record);
        msg = "success";
        return SUCCESS;
    }

    public String destoryRecord() {
        record = recordService.getEntityById(record.getId());
        recordService.delete(record);
        return SUCCESS;
    }

    /**
     * 返回  record
     * @return record
     */
    public Record getRecord() {
        return record;
    }

    /**
     * 设置 record
     * @param record record
     */
    public void setRecord(Record record) {
        this.record = record;
    }

    /**
     * 返回  recordList
     * @return recordList
     */
    public List<Record> getRecordList() {
        return recordList;
    }

    /**
     * 设置 recordList
     * @param recordList recordList
     */
    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

}
