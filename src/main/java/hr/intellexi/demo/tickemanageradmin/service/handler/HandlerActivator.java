package hr.intellexi.demo.tickemanageradmin.service.handler;

import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;

public interface HandlerActivator<T extends RedisMessage> {

    void activateHandler(T message);
}
