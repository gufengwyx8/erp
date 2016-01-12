/*
 * @(#)ContactServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.ContactDao;
import com.erp.model.Contact;
import com.erp.service.ContactService;

/**
 * ContactServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("contactService")
public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {

    @Resource(name = "contactDao")
    private ContactDao contactDao;

    @Override
    protected BaseDao<Contact> getBaseDao() {
        return contactDao;
    }

}
