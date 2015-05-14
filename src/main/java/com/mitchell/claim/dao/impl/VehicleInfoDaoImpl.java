package com.mitchell.claim.dao.impl;

import com.mitchell.claim.dao.VehicleInfoDao;
import com.mitchell.claim.model.VehicleInfo;

/**
 * VehicleInfoDaoImpl implementation class.
 * @author hnguyen
 */
public class VehicleInfoDaoImpl extends BaseEntityDaoImpl<VehicleInfo> implements VehicleInfoDao {

    public VehicleInfoDaoImpl() {
        super(VehicleInfo.class);
    }
}
