package com.mitchell.claim.resource;

import com.mitchell.claim.model.Claim;
import com.mitchell.claim.model.LossInfoType;
import com.mitchell.claim.model.VehicleInfo;
import com.mitchell.claim.service.McService;
import com.mitchell.claim.service.impl.McServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Jersey RESTful resource class.
 * @author hnguyen
 */
@Path("/")
public class ClaimResourceImpl implements ClaimResource {
	
	@Context
	UriInfo uriInfo;
	
	McService mcService = new McServiceImpl();

    @Path("/getClaimTest")
    @GET
    @Produces ("application/xml")
    public Claim getClaimTest() {
        Claim claim = new Claim();
        claim.setId(100L);
        claim.setClaimNumber("22c9c23bac142856018ce14a26b6ct");
        claim.setClaimantFirstName("Alan");
        claim.setClaimantLastName("Nelson");
        claim.setStatusCode("OPEN");
        claim.setLossDate(new Date());
        claim.setAssignedAdjusterId("123434");

        LossInfoType lossInfoType = new LossInfoType();
        lossInfoType.setCauseOfLossCode("Fire");
        lossInfoType.setLossDescription("this is test.");
        lossInfoType.setReportedDate(new Date());
        lossInfoType.setId(100L);
        claim.setLossInfoType(lossInfoType);

        VehicleInfo vehicleInfo =  new VehicleInfo();
        vehicleInfo.setModelYear(1986);
        vehicleInfo.setMakeDescription("Ford");
        vehicleInfo.setModelDescription("Cadilac");
        vehicleInfo.setEngineDescription("8 cylinders");
        vehicleInfo.setExteriorColor("Red");
        vehicleInfo.setVin("1234325353a");
        vehicleInfo.setLicPlate("123abc");
        vehicleInfo.setLicPlateState("Utah");
        vehicleInfo.setLicPlateExpiration(new Date());
        vehicleInfo.setDamageDescription("Fire damages");
        vehicleInfo.setMileage(121000L);
        vehicleInfo.setId(100L);
        claim.setVehicleInfo(vehicleInfo);

        return claim;
    }    

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.resource.ClaimResource#createClaim()
     */
	@POST
	@Consumes ("application/xml")
	@Produces ("application/xml")
    public Claim saveClaim(Claim claim) {
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(claim.getId())).build();
		Response res = Response.created(uri).build();

		claim.getLossInfoType().setClaim(claim);
		claim.getVehicleInfo().setClaim(claim);
		mcService.saveClaim(claim);
		
		return claim;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.resource.ClaimResource#getClaim(java.lang.Long)
     */
    @Path("/getClaim/{claim_id}")
    @GET
    @Produces("application/xml")
    public Claim getClaim(@PathParam("claim_id") Long claimId) {
        Claim claim = mcService.findClaimById(claimId);
        return claim;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.resource.ClaimResource#getClaimsByLossDateRange(java.lang.Long, java.lang.String, java.lang.String)
     */
    @Path("/getClaimsByLossDateRange/{from}/{to}")
    @GET
    @Produces("application/xml")
    public List<Claim> getClaimsByLossDateRange(@PathParam("from") String from, @PathParam("to") String to) {
    	List<Claim> claims = mcService.getClaimsByLossDateRange(from, to);
        return claims;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.resource.ClaimResource#getVehicleByClaimId(java.lang.Long)
     */
    @Path("/getVehicleByClaimId/{claimId}")
    @GET
    @Produces("application/xml")
    public VehicleInfo getVehicleByClaimId(@PathParam("claimId") Long claimId) {
    	Claim claim = mcService.findClaimById(claimId);
    	VehicleInfo vehicleInfo = claim.getVehicleInfo();
        return vehicleInfo;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.resource.ClaimResource#deleteClaimById(java.lang.Long)
     */
    @Path("/deleteClaim/{claimId}")
    @GET
    @Produces("application/xml")
    public String deleteClaim(@PathParam("claimId") Long id) {
    	Claim claim = mcService.findClaimById(id);
    	mcService.deleteClaim(claim);
    	return "OK";
    }
}
