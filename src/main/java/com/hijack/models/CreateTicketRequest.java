package com.hijack.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CreateTicketRequest {

    private Long parentId;
    private String title;

    private String description;

    private Long assignee;

    private String status;

    private String startDate;
    private String endDate;

    private Integer estimation;

    private String type;

    private String priority;
}
