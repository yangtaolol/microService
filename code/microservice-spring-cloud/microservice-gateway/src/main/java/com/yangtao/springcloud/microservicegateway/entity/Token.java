package com.yangtao.springcloud.microservicegateway.entity;

import lombok.Getter;

public class Token {

    private long createTime;

    @Getter
    private String value;

    private int expiryDate = 5;

    public Token(String value) {
        this(value, null);
    }

    public Token(String value, Integer expiryDate) {
        if (expiryDate != null) {
            this.expiryDate = expiryDate;
        }
        createTime = System.currentTimeMillis();
        this.value = value;
    }

    public boolean isValid() {
        long expiryDateValue = expiryDate * 60 * 1000;
        long checkTime = System.currentTimeMillis();
        return checkTime - createTime <= expiryDateValue;
    }
}
