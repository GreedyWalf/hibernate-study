package com.qs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {

    private String departmentId;

    private String departmentName;

    /* 在一方添加多方的集合 */
    private Set<Account> users = new HashSet<Account>();

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Account> getUsers() {
        return users;
    }

    public void setUsers(Set<Account> users) {
        this.users = users;
    }
}
