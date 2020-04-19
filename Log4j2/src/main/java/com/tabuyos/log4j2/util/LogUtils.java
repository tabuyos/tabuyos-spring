package com.tabuyos.log4j2.util;

import com.tabuyos.log4j2.config.LogEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 23:57
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class LogUtils {
    /**
     * 获取业务日志logger
     * @return Logger
     */
    public static Logger getBusinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSINESS.getCategory());
    }

    /**
     * 获取平台日志logger
     * @return Logger
     */
    public static Logger getPlatformLogger() {
        return LoggerFactory.getLogger(LogEnum.PLATFORM.getCategory());
    }

    /**
     * 获取数据库日志logger
     * @return Logger
     */
    public static Logger getDBLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }


    /**
     * 获取异常日志logger
     * @return Logger
     */
    public static Logger getExceptionLogger() {
        return LoggerFactory.getLogger(LogEnum.EXCEPTION.getCategory());
    }
}
