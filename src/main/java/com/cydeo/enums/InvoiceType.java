package com.cydeo.enums;

public enum InvoiceType {

    PURCHASE("Purchase"), SALE("Sale");

    private final String value;

    InvoiceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
