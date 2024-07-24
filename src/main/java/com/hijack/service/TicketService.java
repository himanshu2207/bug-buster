package com.hijack.service;

import com.hijack.dao.inter.TicketDao;
import com.hijack.entity.daoEntity.Ticket;
import com.hijack.models.CreateTicketRequest;
import com.hijack.utils.constants.TicketStatus;
import com.hijack.utils.constants.TicketType;
import com.hijack.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Component
public class TicketService {

    @Autowired
    TicketDao ticketDao;

    public Ticket processTicket(CreateTicketRequest req) throws CustomException, ParseException {
        if(!StringUtils.hasText(req.getTitle()))
            throw new CustomException("Title cannot be empty!");
        Ticket ticket = new Ticket();
        ticket.setParentId(req.getParentId());
        ticket.setTitle(req.getTitle());
        ticket.setDescription(req.getDescription());
        ticket.setAssignee(req.getAssignee());
        if(req.getStatus() != null)
            ticket.setStatus(TicketStatus.valueOf(req.getStatus()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (req.getStartDate() != null) {
            LocalDate date = LocalDate.parse(req.getStartDate(),formatter);
            ticket.setStartDate(date);
        }
        if (req.getEndDate() != null) {
            LocalDate date = LocalDate.parse(req.getEndDate(),formatter);
            ticket.setEndDate(date);
        }
        ticket.setEstimation(req.getEstimation());
        if(req.getType() != null)
            ticket.setType(TicketType.valueOf(req.getType()));
        ticket.setPriority(req.getPriority());
        ticket.setCreatedAt(new Date());
        //TODO: set the logged in user as created by
        ticket.setCreatedBy(null);
        return ticketDao.save(ticket);
    }
}
