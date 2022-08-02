package com.cydeo.enums;

public enum CompanyStatus {

    ENABLED("Enabled"),
    DISABLED("Disabled");

    private final String value;

    CompanyStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
