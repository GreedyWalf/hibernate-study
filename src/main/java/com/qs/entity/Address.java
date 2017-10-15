package com.qs.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String addressId;

    private String addressName;

    //双向1对1 被控端也知道主控端的引用
    private Account account;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
