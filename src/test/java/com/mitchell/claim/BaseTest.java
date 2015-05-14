package com.mitchell.claim;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseTest {

    /**
     * base logging capability for all subclasses.
     */
    protected Log logger = LogFactory.getLog(this.getClass());
}