package hr.intellexi.demo.tickemanageradmin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;
import hr.intellexi.demo.tickemanageradmin.service.handler.HandlerActivator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RedisMessageConsumer {

    @NonNull
    ObjectMapper objectMapper;

    @NonNull
    HandlerActivator handlerActivator;

    public void handleMessage(Object object){

        try {
            RedisMessage message = objectMapper.convertValue(object, RedisMessage.class);
            handlerActivator.activateHandler(message);

        }catch (Exception e){
            log.error("Unsuported message input !!");
        }
    }
}
