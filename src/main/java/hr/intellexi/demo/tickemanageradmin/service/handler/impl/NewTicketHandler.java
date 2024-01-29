package hr.intellexi.demo.tickemanageradmin.service.handler.impl;

import hr.intellexi.demo.tickemanageradmin.dao.jdbc.TicketDao;
import hr.intellexi.demo.tickemanageradmin.model.Ticket;
import hr.intellexi.demo.tickemanageradmin.model.messages.NewTicketMessage;
import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;
import hr.intellexi.demo.tickemanageradmin.service.handler.RedisMessageHandler;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class NewTicketHandler extends RedisMessageHandler<NewTicketMessage> {

    @NonNull
    private final TicketDao ticketDao;

    @Override
    public void handleMessage(final NewTicketMessage message) {
        log.info("Activated " + message.getClass() + "handler !!");
        Ticket ticket = from(message);
        int saved = ticketDao.saveTicket(ticket);
        if (saved != 1){
            log.error("Ticket is not created !!");
        }
        //TODO: ??? send message to view

    }

    @Override
    public Class getSupportedClass() {
        return NewTicketMessage.class;
    }

    private Ticket from(final NewTicketMessage newTicketMessage){
        Ticket ticket = new Ticket();
        ticket.setId(newTicketMessage.getId());
        ticket.setFirstName(newTicketMessage.getFirstName());
        ticket.setLastName(newTicketMessage.getLastName());
        ticket.setClub(newTicketMessage.getClub());
        ticket.setDistance(newTicketMessage.getDistance());

        return ticket;
    }
}
