package com.mitchell.claim.resource;

import com.mitchell.claim.model.Claim;
import com.mitchell.claim.model.VehicleInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

/**
 * Jersey RESTful resource interface.
 * @author hnguyen
 */
public interface ClaimResource {

	/**
	 * Saves claim record (create/update). 
	 * See ClaimResouceImplTest class in TestNG section to test this method.
	 * @param claim
	 * @return
	 */
	@POST
	@Consumes ("application/xml")
	@Produces ("application/xml")
    public Claim saveClaim(Claim claim);

    /**
     * Get claim record by id.
     * For testing, type this url in browser:
     * 		http://localhost:8080/claim/getClaim/167
     * where 167 is a claim id of claim record in database.
     * @param claimId
     * @return
     */
    @Path("/getClaim/{claim_id}")
    @GET
    @Produces("application/xml")
    public Claim getClaim(@PathParam("claim_id") Long claimId);

    /**
     * Gets all claim records by loss data range.
     * For testing, type this url, for example, in browser:
     * 		http://localhost:8080/claim/getClaimsByLossDateRange/05-12-2015/05-16-2015
     * @param claimId
     * @param from in format MM-dd-yyyy
     * @param to in format MM-dd-yyyy
     * @return
     */
    @Path("/getClaimsByLossDateRange/{from}/{to}")
    @GET
    @Produces("application/xml")    
    public List<Claim> getClaimsByLossDateRange(@PathParam("from") String from, @PathParam("to") String to);

    /**
     * Gets vehicle information by claim id.
     * For testing, type this url, for example, in browser:
     * 		http://localhost:8080/claim/getVehicleByClaimId/174
     * @param claimId
     * @return
     */
    @Path("/getVehicleByClaimId/{claimId}")
    @GET
    @Produces("application/xml")
    public VehicleInfo getVehicleByClaimId(@PathParam("claimId") Long claimId);

    /**
     * Deletes claim entity
     * For testing, type this url, for example, in browser:
     * 		http://localhost:8080/claim/deleteClaim/166
     * @param claimId
     * @return
     */
    @Path("/deleteClaim/{claimId}")
    @GET
    @Produces("application/xml")
    public String deleteClaim(@PathParam("claimId") Long id);
}
