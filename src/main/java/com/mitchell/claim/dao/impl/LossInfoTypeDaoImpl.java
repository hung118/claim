package com.mitchell.claim.dao.impl;

import com.mitchell.claim.dao.LossInfoTypeDao;
import com.mitchell.claim.model.LossInfoType;

/**
 * LossInfoTypeDaoImpl implementation class.
 * @author hnguyen
 */
public class LossInfoTypeDaoImpl extends BaseEntityDaoImpl<LossInfoType> implements LossInfoTypeDao {

    public LossInfoTypeDaoImpl() {
        super(LossInfoType.class);
    }
}
