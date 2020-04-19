package com.tabuyos.log4j2.config;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 22:54
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public enum LogEnum {

    /**
     * 业务
     */
    BUSINESS("business"),

    /**
     * 平台
     */
    PLATFORM("platform"),

    /**
     * 数据库
     */
    DB("db"),

    /**
     * 异常
     */
    EXCEPTION("exception");

    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
