package com.guoshi.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LogTest {
    private Log log = LogFactory.getLog(LogTest.class);

    @Test
    public void test1() {
        log.trace("hello trace");
        log.debug("hello debug");
        log.info("hello info");
        log.warn("hello warn");
        log.error("hello error");
        log.fatal("hello fatal");
    }
}
