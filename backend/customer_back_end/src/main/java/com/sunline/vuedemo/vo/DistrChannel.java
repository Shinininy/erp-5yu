package com.sunline.vuedemo.vo;

public enum DistrChannel {
    WH("Whole Sale"),
    RT("Retail"),
    OL("Online");

    private final String name;

    DistrChannel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DistrChannel findByCode(String code) {
        for (DistrChannel channel : values()) {
            if (channel.name().startsWith(code)) {
                return channel;
            }
        }
        return null;
    }
}
