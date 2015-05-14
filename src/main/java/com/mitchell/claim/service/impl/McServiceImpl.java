package com.mitchell.claim.service.impl;

import java.util.List;

import com.mitchell.claim.dao.ClaimDao;
import com.mitchell.claim.dao.impl.ClaimDaoImpl;
import com.mitchell.claim.model.Claim;
import com.mitchell.claim.service.McService;

/**
 * mcService implementation class.
 * 
 * @author hnguyen
 *
 */
public class McServiceImpl implements McService {

	private ClaimDao claimDao = new ClaimDaoImpl();
	
	/*
	 * (non-Javadoc)
	 * @see com.mitchell.claim.service.McService#saveClaim(com.mitchell.claim.model.Claim)
	 */
	public Claim saveClaim(Claim claim) {
		return claimDao.save(claim);
	}

	/*
	 * (non-Javadoc)
	 * @see com.mitchell.claim.service.McService#findClaimById(java.lang.Long)
	 */
	public Claim findClaimById(Long id) {
		return claimDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.mitchell.claim.service.McService#evictClaim(com.mitchell.claim.model.Claim)
	 */
	public void evictClaim(Claim claim) {
		claimDao.evict(claim);
	}

	/*
	 * (non-Javadoc)
	 * @see com.mitchell.claim.service.McService#getClaimsByLossDateRange(java.lang.Long, java.lang.String, java.lang.String)
	 */
	public List<Claim> getClaimsByLossDateRange(String from, String to) {
		return claimDao.getClaimsByLossDateRange(from, to);
	}

	/*
	 * (non-Javadoc)
	 * @see com.mitchell.claim.service.McService#deleteClaimById(java.lang.Long)
	 */
	public void deleteClaim(Claim claim) {
		claimDao.delete(claim);
	}
}
