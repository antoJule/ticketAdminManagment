package hr.intellexi.demo.tickemanageradmin.model.messages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class RedisMessage implements Serializable {

}
