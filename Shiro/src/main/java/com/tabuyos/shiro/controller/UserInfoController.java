package com.tabuyos.shiro.controller;

import com.tabuyos.shiro.dao.UserInfoRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 12:26
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class UserInfoController {

    private UserInfoRepository userInfoRepository;
//    private static final Logger logger = LogManager.getLogger();
    Logger logger = LoggerFactory.getLogger("db");
//    Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @GetMapping("/getAll")
    public String getAll() {
        // OFF>FATAL>ERROR>WARN>INFO>DEBUG>TRACE>ALL
        logger.info("Info level log");
        logger.debug("Debug level log");
        logger.warn("Warn level log");
        logger.error("Error level log");
        logger.trace("Trace level log");
//        logger.fatal("Fatal level log");
//        logger.log(Level.ALL, "All level log");
//        logger.log(Level.OFF, "Off level log");
        return userInfoRepository.findAll().toString();
    }
}
