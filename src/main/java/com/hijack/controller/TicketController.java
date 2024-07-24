package com.hijack.controller;

import com.hijack.entity.daoEntity.Ticket;
import com.hijack.models.CreateTicketRequest;
import com.hijack.service.TicketService;
import com.hijack.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class TicketController {

    @Autowired
    TicketService service;

    @Autowired
    CreateTicketRequest ticketRequest;

    @PostMapping("/ticket")
    public ResponseEntity createTicket(@RequestBody CreateTicketRequest payload) {
        Ticket ticket = null;
        try {
            ticket = service.processTicket(payload);
        }
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket status or type is invalid!");
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date format is not valid!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<CreateTicketRequest> getTicket(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(ticketRequest);
    }
}
