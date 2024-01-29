package hr.intellexi.demo.tickemanageradmin.model.messages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NewTicketMessage extends RedisMessage{

    private String id;
    private String firstName;
    private String lastName;
    private String club;
    private String distance;
}
