package com.hijack.utils.constants;

public enum TicketType {
    Bug("bug"),
    Enhancement("enhancement"),
    Feature("feature"),
    Support("support"),
    Task("task");

    private String value;

    TicketType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
