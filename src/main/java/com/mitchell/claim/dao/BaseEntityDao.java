package com.mitchell.claim.dao;

import com.mitchell.claim.model.BaseEntityAbstract;

import java.util.List;

public interface BaseEntityDao<T extends BaseEntityAbstract> {

    /**
     * Removes an entity from the store
     *
     * @param entity to be removed
     */
    public void delete(T entity);

    /**
     * Finds an entity by its surrogate id
     *
     * @param id
     * @return
     */
    public T findById(Long id);

    /**
     * Finds an entity by name
     *
     * @param name
     * @return
     */
    public T findByName(String name);

    /**
     * Gets a list of all entities of type T
     *
     * @param - an order by predicate
     * @return a list of entities (empty if none exist)
     */
    public List<T> listAll(String orderBy);

    /**
     * Gets list of all entities of type T with active = 1.
     *
     * @param orderBy
     * @return
     */
    public List<T> listAllActive(String orderBy);

    /**
     * Saves an entity to the persistent store
     *
     * @param entity to save
     */
    public T save(T entity);

    /**
     * Remove entity instance from the session cache.
     * @param entity
     */
    public void evict(T entity);
}