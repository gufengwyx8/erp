/*
 * @(#)MaterielDetailServiceImpl.java 2015-4-4 ÏÂÎç02:37:49 erp-manufacture
 */
package com.erp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.erp.dao.BaseDao;
import com.erp.dao.MaterielDetailDao;
import com.erp.model.MaterielDetail;
import com.erp.service.MaterielDetailService;

/**
 * MaterielDetailServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("materielDetailService")
public class MaterielDetailServiceImpl extends BaseServiceImpl<MaterielDetail> implements MaterielDetailService {

    @Resource(name = "materielDetailDao")
    private MaterielDetailDao materielDetailDao;

    @Override
    protected BaseDao<MaterielDetail> getBaseDao() {
        return materielDetailDao;
    }

}
