/*
 * @(#)AdDaoImpl.java 2015-4-4 обнГ02:29:05
 * erp-manufacture
 */
package com.erp.dao.impl;

import org.springframework.stereotype.Component;

import com.erp.dao.AdDao;
import com.erp.model.Ad;

/**
 * AdDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("adDao")
public class AdDaoImpl extends BaseDaoImpl<Ad> implements AdDao {

}
