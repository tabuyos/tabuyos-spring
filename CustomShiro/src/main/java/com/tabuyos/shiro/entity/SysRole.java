package com.tabuyos.shiro.entity;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable {
    private String role;
    private List<SysPermission> permissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public SysRole() {
    }

    public SysRole(SysRole target) {
        this.role = target.role;
        this.permissions = target.permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public static class Builder {

        private SysRole target;

        public Builder() {
            this.target = new SysRole();
        }
        public Builder role(String role) {
            target.role = role;
            return this;
        }
        public SysRole build() {
            return new SysRole(target);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
}
