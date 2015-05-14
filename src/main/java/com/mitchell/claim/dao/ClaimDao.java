package com.mitchell.claim.dao;

import java.util.List;

import com.mitchell.claim.model.Claim;

/**
 * ClaimDao interface.
 * @author hnguyen
 */
public interface ClaimDao extends BaseEntityDao<Claim> {
	
	/**
	 * Get list of claims by loss date range.
	 * @param from in format MM-dd-yyyy
	 * @param to in format MM-dd-yyyy
	 * @return
	 */
	public List<Claim> getClaimsByLossDateRange(String from, String to); 
}
