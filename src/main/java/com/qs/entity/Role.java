package com.qs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private String roleId;

    private String roleName;

    /**
     * 一个角色可以对应多个用户（这里同样的映射Account，并设置inverse=“true”）
     */
    private Set<Account> accounts = new HashSet<Account>();

    public Role(){

    }


    public Role(String roleName){
        this.roleName = roleName;
    }


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
