package com.mitchell.claim.model;

import java.io.Serializable;

public abstract class BaseEntityAbstract implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Gets the entity ID of sub-class which has overriden getId method.
     * @return
     */
    public abstract Long getId();

}
