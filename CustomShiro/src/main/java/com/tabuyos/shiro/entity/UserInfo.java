package com.tabuyos.shiro.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 0:14
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class UserInfo implements Serializable {

    private String userName;

    private String password;

    private Integer state;

    private String credentialsSalt;

    private List<SysRole> roleList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCredentialsSalt() {
        return credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public UserInfo() {
    }

    public UserInfo(UserInfo target) {
        this.userName = target.userName;
        this.password = target.password;
        this.state = target.state;
        this.credentialsSalt = target.credentialsSalt;
        this.roleList = target.roleList;
    }

    public static class Builder{
        private UserInfo target;
        public Builder() {
            this.target = new UserInfo();
        }
        public Builder userName(String userName) {
            target.userName = userName;
            return this;
        }
        public Builder password(String password) {
            target.password = password;
            return this;
        }
        public Builder state(Integer state) {
            target.state = state;
            return this;
        }
        public Builder credentialsSalt(String credentialsSalt) {
            target.credentialsSalt = credentialsSalt;
            return this;
        }
        public Builder roleList(List<SysRole> roleList) {
            target.roleList = roleList;
            return this;
        }
        public UserInfo build() {
            return new UserInfo(target);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
