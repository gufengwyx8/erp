/*
 * @(#)DeliveryServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.DeliveryDao;
import com.erp.model.Delivery;
import com.erp.service.DeliveryService;

/**
 * DeliveryServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("deliveryService")
public class DeliveryServiceImpl extends BaseServiceImpl<Delivery> implements DeliveryService {

    @Resource(name = "deliveryDao")
    private DeliveryDao deliveryDao;

    @Override
    protected BaseDao<Delivery> getBaseDao() {
        return deliveryDao;
    }

}
