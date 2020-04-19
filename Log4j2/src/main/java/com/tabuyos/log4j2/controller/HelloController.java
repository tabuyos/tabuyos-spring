package com.tabuyos.log4j2.controller;

import com.tabuyos.log4j2.util.LogUtils;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 20:22
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    //    private static final Logger logger = LogManager.getLogger();
    private static Logger loggerBusiness = LogUtils.getBusinessLogger();
    private static Logger loggerPlatform = LogUtils.getPlatformLogger();
    private static Logger loggerDB = LogUtils.getDBLogger();
    private static Logger loggerException = LogUtils.getExceptionLogger();

    @GetMapping("/hi")
    public String hello() {
        logger.trace("Trace log msg.");
        logger.debug("Debug log msg.");
        logger.info("Info log msg.");
        logger.warn("Warn log msg.");
        logger.error("Error log msg.");

        loggerBusiness.info("Business");
        loggerPlatform.info("Platform");
        loggerDB.info("DB");
        loggerException.error("Exception");

        return "Hello, Tabuyos";
    }
}
