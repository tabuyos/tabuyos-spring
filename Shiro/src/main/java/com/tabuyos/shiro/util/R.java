package com.tabuyos.shiro.util;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    public static String SUCCESS_CODE = "200";
    public static String ERROR_CODE = "500";
    public static String DATA_KEY = "data";
    public static String CODE_KEY = "code";
    public static String MESSAGE_KEY = "message";
    public static String FAILED = "Failed";
    public static String SUCCESSFUL = "Successful";

    private R() {
    }

    public R set(String key, Object object) {
        super.put(key, object);
        return this;
    }

    private static R ok() {
        return new R();
    }

    public static R success() {
        return R.ok().set(R.CODE_KEY, R.SUCCESS_CODE).set(R.MESSAGE_KEY, R.SUCCESSFUL);
    }

    public static R success(String msg) {
        return R.ok().set(R.CODE_KEY, R.SUCCESS_CODE).set(R.MESSAGE_KEY, msg);
    }

    public static R success(String msg, Object object) {
        return R.ok().set(R.CODE_KEY, R.SUCCESS_CODE).set(R.MESSAGE_KEY, msg).set(R.DATA_KEY, object);
    }

    public R data(Object obj) {
        return this.set(R.CODE_KEY, obj);
    }

    public static R error() {
        return R.ok().set(R.MESSAGE_KEY, R.FAILED).set(R.CODE_KEY, R.ERROR_CODE);
    }

    public static R error(String msg) {
        return R.ok().set(R.MESSAGE_KEY, msg).set(R.CODE_KEY, R.ERROR_CODE);
    }

    public static R error(String msg, Object object) {
        return R.ok().set(R.MESSAGE_KEY, msg).set(R.DATA_KEY, object).set(R.CODE_KEY, R.ERROR_CODE);
    }

}
