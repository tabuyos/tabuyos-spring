package com.tabuyos.log4j2.test;

import com.tabuyos.log4j2.config.LogEnum;
import com.tabuyos.log4j2.util.LogUtils;
import org.slf4j.Logger;

/**
 * @Author Tabuyos
 * @Time 2020/4/20 0:02
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Logger loggerBusiness = LogUtils.getBusinessLogger();
        Logger loggerPlatform = LogUtils.getPlatformLogger();
        Logger loggerDB = LogUtils.getDBLogger();
        Logger loggerException = LogUtils.getExceptionLogger();

        loggerBusiness.info("Business");
        loggerPlatform.info("Platform");
        loggerDB.info("DB");
        loggerException.error("Exception");
    }
}
