package hr.intellexi.demo.tickemanageradmin.dao.jdbc;

import hr.intellexi.demo.tickemanageradmin.model.Ticket;

import java.util.List;

public interface TicketDao {

    int saveTicket(final Ticket ticket);

    List<Ticket> findAll();

    void deleteTicketByUuid(final String uuid);

}
