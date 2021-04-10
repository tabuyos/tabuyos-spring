package com.tabuyos.shiro.entity;

import java.io.Serializable;


public class SysPermission implements Serializable {
    private String permission;

    public SysPermission(String read) {
        this.permission = read;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
