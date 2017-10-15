package com.qs.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Account implements Serializable {
    private String accountId;

    private String accountName;

    private String password;

    private String sex;

    private Integer age;

    private String mobile;

    private String email;

    /* account和address一对一关系 */
    private Address address;

    /**
     *  account和role之间为多对多关系，在account表中维护roles集合
     */
    private Set<Role> roles = new HashSet<Role>();

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}



