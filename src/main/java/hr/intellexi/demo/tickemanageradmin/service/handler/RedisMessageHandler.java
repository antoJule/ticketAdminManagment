package hr.intellexi.demo.tickemanageradmin.service.handler;

import hr.intellexi.demo.tickemanageradmin.model.messages.RedisMessage;
import hr.intellexi.demo.tickemanageradmin.service.handler.impl.MessageHandler;

public abstract class RedisMessageHandler<T extends RedisMessage> implements MessageHandler<T> {
}
