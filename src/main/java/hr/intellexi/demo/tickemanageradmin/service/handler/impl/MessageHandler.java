package hr.intellexi.demo.tickemanageradmin.service.handler.impl;

import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;

public interface MessageHandler<T extends RedisMessage> {

    void handleMessage(T message);

    Class<T> getSupportedClass();
}
