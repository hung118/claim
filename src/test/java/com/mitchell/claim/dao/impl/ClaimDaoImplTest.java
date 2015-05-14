package com.mitchell.claim.dao.impl;

import java.util.Date;

import org.testng.annotations.Test;

import com.mitchell.claim.BaseTest;
import com.mitchell.claim.model.Claim;
import com.mitchell.claim.model.LossInfoType;
import com.mitchell.claim.model.VehicleInfo;
import com.mitchell.claim.service.McService;
import com.mitchell.claim.service.impl.McServiceImpl;

public class ClaimDaoImplTest extends BaseTest {
	McService mcService = new McServiceImpl();

	@Test
	public void insertClaim() {
        Claim claim = new Claim();
        claim.setClaimNumber("22c9c23bac142856018ce14adfaskj44");
        claim.setClaimantFirstName("Dave");
        claim.setClaimantLastName("romney");
        claim.setStatusCode("OPEN");
        claim.setLossDate(new Date());
        claim.setAssignedAdjusterId("176878");

        LossInfoType lossInfoType = new LossInfoType();
        lossInfoType.setCauseOfLossCode("Hail");
        lossInfoType.setReportedDate(new Date());
        lossInfoType.setLossDescription("this is test 2.");

        claim.setLossInfoType(lossInfoType);
        lossInfoType.setClaim(claim);

        VehicleInfo vehicleInfo =  new VehicleInfo();
        vehicleInfo.setModelYear(1986);
        vehicleInfo.setMakeDescription("Ford");
        vehicleInfo.setModelDescription("Pointiac");
        vehicleInfo.setEngineDescription("8 cylinders");
        vehicleInfo.setExteriorColor("Blue");
        vehicleInfo.setVin("12343253345ddasf");
        vehicleInfo.setLicPlate("123xyz");
        vehicleInfo.setLicPlateState("California");
        vehicleInfo.setLicPlateExpiration(new Date());
        vehicleInfo.setDamageDescription("Hail damages");
        vehicleInfo.setMileage(121000L);

        claim.setVehicleInfo(vehicleInfo);
        vehicleInfo.setClaim(claim);
        
        mcService.saveClaim(claim);
        if (claim.getId() == null) throw new AssertionError("Failed to insert Claim record!");
	}
	
	//@Test
	public void findClaimByIdTest() {
		Claim claim = mcService.findClaimById(164L);
		if (claim.getId() == null) {
			throw new AssertionError("Failed to insert Claim record!");
		} else {
			System.out.println("ID: " + claim.getId());
		}
	}
}
