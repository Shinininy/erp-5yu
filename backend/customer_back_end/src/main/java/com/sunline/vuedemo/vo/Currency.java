package com.sunline.vuedemo.vo;

public enum Currency {
    CNY("人民币 - Chinese Yuan"),
    USD("美元 - United States Dollar"),
    EUR("欧元 - Euro"),
    GBP("英镑 - British Pound"),
    AUD("澳元 - Australia Dollar"),
    CAD("加元 - Canadian Dollar"),
    JPY("日元 - Japanese Yen"),
    HKD("港币 - Hong Kong Dollar"),
    INR("印度卢比 - Indian Rupee"),
    ZAR("南非兰特 - South African Rand"),
    TWD("新台币 - New Taiwan Dollar"),
    MOP("澳门元 - Macau Pataca"),
    KRW("韩元 - South Korean Won"),
    THB("泰铢 - Thai Baht"),
    NZD("新西兰元 - New Zealand Dollar"),
    SGD("新加坡元 - Singapore Dollar");

    private final String description;

    Currency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Currency findByCode(String code) {
        for (Currency currency : values()) {
            if (currency.name().equals(code)) {
                return currency;
            }
        }
        return null;
    }
}
