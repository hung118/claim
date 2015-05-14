package com.mitchell.claim.dao.impl;

import java.util.List;

import com.mitchell.claim.dao.BaseEntityDao;
import com.mitchell.claim.model.BaseEntityAbstract;
import com.mitchell.claim.util.HibernateUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Implemtation class for BaseEntityDao interface.
 *
 * @author HNGUYEN
 *
 * @param <T>
 */
public class BaseEntityDaoImpl<T extends BaseEntityAbstract> implements BaseEntityDao<T>  {
	
	protected final Session session = HibernateUtil.getSession();

    /**
     * base logging capability for all extending services
     */
    protected Log logger = LogFactory.getLog(this.getClass());

    /**
     * the class of the entity
     */
    private Class<T> type;

    /**
     * public constructor that sets up the class type.
     * @param type
     */
    public BaseEntityDaoImpl(Class<T> type){
        this.type = type;
    }


    public void delete(T entity) {
    	try {
    		session.getTransaction().begin();
    		session.delete(entity);
    		session.getTransaction().commit();
    	} finally {
    		session.close();
    	}
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.dao.BaseEntityDao#findById(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
	public T findById(Long id) {
    	Query q = session.createQuery("from " + type.getName()
    			+ " where id = :id");
    	q.setParameter("id", id);
    	
        T entity = null;
        try {
            entity = (T) q.list().get(0);
        } catch (Exception e) {
            logger.info("Unable to find the requested entity: " + type + "["
                    + id + "]");
        }

        return entity;
    }


    public T findByName(String name) {
    	return null;
    }

    public List<T> listAll(String orderBy) {
    	return null;
    }
    
    public List<T> listAllActive(String orderBy) {
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.dao.BaseEntityDao#save(com.mitchell.claim.model.BaseEntityAbstract)
     */
    @SuppressWarnings("unchecked")
	public T save(T entity) {
    	try {
    		if (entity == null) return entity;
    		
    		session.getTransaction().begin();
    		if (entity.getId() != null) {	// merge
    			entity = (T) session.merge(entity);
    		} else {
    			session.persist(entity);
    		}
    		session.getTransaction().commit();
    	} finally {
    		session.close();
    	}

        return entity;
    }

    /*
     * (non-Javadoc)
     * @see com.mitchell.claim.dao.BaseEntityDao#evict(com.mitchell.claim.model.BaseEntityAbstract)
     */
    public void evict(T entity) {
    	session.evict(entity);
    }

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

}
