package com.sunline.vuedemo.vo;

public enum CompanyCode {
    CN00("中国"),
    VN00("越南"),
    EG00("埃及"),
    BR00("巴西"),
    AR00("阿根廷"),
    IN00("印度"),
    JP00("日本"),
    TH00("泰国"),
    US00("美国");

    private final String name;

    CompanyCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CompanyCode findByCode(String code) {
        for (CompanyCode companyCode : values()) {
            if (companyCode.name().equals(code)) {
                return companyCode;
            }
        }
        return null;
    }
}
