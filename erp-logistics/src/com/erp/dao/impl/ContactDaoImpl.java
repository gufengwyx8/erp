/*
 * @(#)ContactDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.ContactDao;
import com.erp.model.Contact;

/**
 * ContactDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("contactDao")
public class ContactDaoImpl extends BaseDaoImpl<Contact> implements ContactDao {

}
