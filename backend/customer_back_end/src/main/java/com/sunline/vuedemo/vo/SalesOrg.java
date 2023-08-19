package com.sunline.vuedemo.vo;

public enum SalesOrg {
    UE00("欧盟销售组织00"),
    US00("美国销售组织00"),
    EU00("欧洲销售组织00"),
    AP00("亚太销售组织00"),
    DE00("德国销售组织00"),
    CN00("中国销售组织00");

    private final String description;

    SalesOrg(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SalesOrg findByCode(String code) {
        for (SalesOrg org : values()) {
            if (org.name().startsWith(code)) {
                return org;
            }
        }
        return null;
    }
}
