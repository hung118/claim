package com.mitchell.claim.resource;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.testng.annotations.Test;

import com.mitchell.claim.BaseTest;
import com.mitchell.claim.model.Claim;
import com.mitchell.claim.model.LossInfoType;
import com.mitchell.claim.model.VehicleInfo;
import com.mitchell.claim.service.McService;
import com.mitchell.claim.service.impl.McServiceImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClaimResourceImplTest extends BaseTest {

	McService mcService = new McServiceImpl();
	
	//@Test
	public void createClaimTest() {
		// hard code claim record
        Claim claim = new Claim();
        claim.setClaimNumber("22c9c23bac142856018ce14adfaskj44");
        claim.setClaimantFirstName("Austin");
        claim.setClaimantLastName("Haws");
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
        
        // create REST client object and web resource
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/claim");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).post(
        		ClientResponse.class, claim);
        
        assert true;
	}
	
	@Test
	public void updateClaimTest() {
		Claim claim = mcService.findClaimById(166L);
		claim.setClaimNumber("22c9c23bac142856018ce14a26b6c299");
		claim.setAssignedAdjusterId("67890");
		claim.getVehicleInfo().setVin("testingupdate1234a");
		claim.getVehicleInfo().setExteriorColor("update Red");
		claim.getVehicleInfo().setLicPlateExpiration(new Date());
		
        // create REST client object and web resource
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/claim");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).post(
        		ClientResponse.class, claim);
        
        assert true;
	}
}
