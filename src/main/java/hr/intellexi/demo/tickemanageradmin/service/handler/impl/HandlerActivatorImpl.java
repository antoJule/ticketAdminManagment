package hr.intellexi.demo.tickemanageradmin.service.handler.impl;

import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;
import hr.intellexi.demo.tickemanageradmin.service.handler.HandlerActivator;
import hr.intellexi.demo.tickemanageradmin.service.handler.RedisMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class HandlerActivatorImpl <T extends RedisMessage> implements HandlerActivator<T> {

    private final Map<Class<T>, RedisMessageHandler<T>> handlesMap = new ConcurrentHashMap<>();

    @Autowired
    public HandlerActivatorImpl(List<RedisMessageHandler<T>> handlers){
        for (RedisMessageHandler<T> handler : handlers){
            handlesMap.put(handler.getSupportedClass(), handler);
        }
    }

    @Override
    public void activateHandler(T message) {
        RedisMessageHandler<T> handler = handlesMap.get(message.getClass());
        if (handler == null){
            throw new IllegalArgumentException("Handler for class " + message.getClass() + "is not implemented !!");
        }
    }
}
