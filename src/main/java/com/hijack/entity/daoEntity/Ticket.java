package com.hijack.entity.daoEntity;

import com.hijack.utils.constants.TicketStatus;
import com.hijack.utils.constants.TicketType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@DynamicInsert
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    private Long parentId;

    private Long createdBy;

    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false)
    private String title;

    @JdbcTypeCode(SqlTypes.LONGNVARCHAR)
    private String description;

    private Long assignee;

    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.Backlog;

    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate startDate;

    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate endDate;

    private Integer estimation;

    @Enumerated(EnumType.STRING)
    private TicketType type = TicketType.Task;

    private String priority;

    @ColumnDefault("false")
    @Column(nullable = false)
    private Boolean isDeleted = false;

}
