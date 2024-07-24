package com.hijack.utils.constants;

public enum TicketStatus {
    Backlog("backlog"),
    InProgress("in_progress"),
    Completed("completed"),
    Invalid("invalid"),
    Ready_For_Deployment("ready_for_deployment"),
    Ready_For_Testing("ready_for_testing");

    private String value;
    TicketStatus(String value) {
        this.value = value;
    }
 }
