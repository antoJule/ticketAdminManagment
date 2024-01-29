package hr.intellexi.demo.tickemanageradmin.dao.jdbc;

import hr.intellexi.demo.tickemanageradmin.model.Ticket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TicketDaoImpl implements TicketDao{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int saveTicket(final Ticket ticket) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource params = new MapSqlParameterSource(generateParams(ticket));
        //TODO: if(params.hasValue("id")) UPDATE ... WHERE ... ID
        String insertSql = "INSERT INTO MARATHON_TICKETS.TICKETS(FIRSTNAME, LASTNAME, CLUB, DISTANCE) VALUES (:firstname, :lastname, :club, :distance)";

        int updated = namedParameterJdbcTemplate.update(insertSql, params);

        return updated;
    }

    @Override
    public List<Ticket> findAll() {

        String selectSql = "SELECT id, FIRSTNAME, LASTNAME, CLUB, DISTANCE FROM MARATHON_TICKETS.TICKETS";

        try {
            return namedParameterJdbcTemplate.getJdbcTemplate().query(selectSql, new BeanPropertyRowMapper<>(Ticket.class));
        }catch (EmptyResultDataAccessException e){
            log.info("No data in table TICKETS");
        }
        return null;
    }

    @Override
    public void deleteTicketByUuid(final String uuid) {

    }

    private HashMap<String, Object> generateParams(final Ticket ticket){
        HashMap<String, Object> params = new HashMap<>();
        if (ticket.getId() != null){
            params.put("id", ticket.getId());
        }
        params.put("firstname", ticket.getFirstName());
        params.put("lasname", ticket.getLastName());
        params.put("club", ticket.getClub());
        params.put("distance",ticket.getDistance());

        return params;
    }

}
