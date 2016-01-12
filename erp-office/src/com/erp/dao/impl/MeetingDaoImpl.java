/*
 * @(#)MeetingDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.MeetingDao;
import com.erp.model.Meeting;

/**
 * MeetingDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("meetingDao")
public class MeetingDaoImpl extends BaseDaoImpl<Meeting> implements MeetingDao {

}
