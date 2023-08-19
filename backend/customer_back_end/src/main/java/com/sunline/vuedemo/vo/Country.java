package com.sunline.vuedemo.vo;

public enum Country {
    US("United States of America"),
    UK("United Kingdom"),
    CAN("Canada"),
    GER("Germany"),
    FRA("France"),
    CHN("China"),
    KOR("Korea"),
    JPN("Japan");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 模糊查询方法
    public static Country findByCode(String code) {
        for (Country country : values()) {
            if (country.name().startsWith(code)) {
                return country;
            }
        }
        return null;
    }
}
