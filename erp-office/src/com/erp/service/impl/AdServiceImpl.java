/*
 * @(#)AdServiceImpl.java 2015-4-4 обнГ02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.AdDao;
import com.erp.model.Ad;
import com.erp.service.AdService;

/**
 * AdServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("adService")
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {

    @Resource(name = "adDao")
    private AdDao adDao;

    @Override
    protected BaseDao<Ad> getBaseDao() {
        return adDao;
    }

}
