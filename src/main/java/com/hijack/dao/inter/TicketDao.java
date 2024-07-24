package com.hijack.dao.inter;

import com.hijack.entity.daoEntity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket,Long> {
}
