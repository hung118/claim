package com.mitchell.claim.service;

import java.util.List;

import com.mitchell.claim.model.Claim;

public interface McService {
	/**
	 * Save claim entity.
	 * @param claim
	 * @return Claim object
	 */
	public Claim saveClaim(Claim claim);
	
	/**
	 * Find claim entity by id.
	 * @param id
	 * @return
	 */
	public Claim findClaimById(Long id);
	
	/**
	 * Evict claim instance from session cache.
	 * @param claim
	 */
	public void evictClaim(Claim claim);

	/**
	 * Get list of claims by loss date range.
	 * @param from in format MM-dd-yyyy
	 * @param to in format MM-dd-yyyy
	 * @return
	 */
	public List<Claim> getClaimsByLossDateRange(String from, String to);
	
	/**
	 * Deletes claim entity.
	 * @param claim
	 */
	public void deleteClaim(Claim claim);
}
