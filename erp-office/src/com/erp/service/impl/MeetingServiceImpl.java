/*
 * @(#)MeetingServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.MeetingDao;
import com.erp.model.Meeting;
import com.erp.service.MeetingService;

/**
 * MeetingServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("meetingService")
public class MeetingServiceImpl extends BaseServiceImpl<Meeting> implements MeetingService {

    @Resource(name = "meetingDao")
    private MeetingDao meetingDao;

    @Override
    protected BaseDao<Meeting> getBaseDao() {
        return meetingDao;
    }

}
