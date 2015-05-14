package com.mitchell.claim.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.mitchell.claim.dao.ClaimDao;
import com.mitchell.claim.model.Claim;

/**
 * ClaimDaoImpl implementation class.
 * @author hnguyen
 */
public class ClaimDaoImpl extends BaseEntityDaoImpl<Claim> implements ClaimDao {

    public ClaimDaoImpl() {
        super(Claim.class);
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.dao.ClaimDao#getClaimsByLossDateRange(java.lang.Long, java.lang.String, java.lang.String)
     */
	@SuppressWarnings("unchecked")
	public List<Claim> getClaimsByLossDateRange(String from, String to) {
		Query q = session.createQuery("from Claim c where c.lossInfoType.reportedDate between to_date('" + from + "', 'mm/dd/yyyy') and to_date('" + to + "', 'mm/dd/yyyy')");
		return q.list();
	}
}
