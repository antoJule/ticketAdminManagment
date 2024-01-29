package hr.intellexi.demo.tickemanageradmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.intellexi.demo.tickemanageradmin.service.RedisMessageConsumer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class RedisListenerConfig {


    @NonNull
    private ObjectMapper objectMapper;

    @Value("${redis.ticket.topic}")
    private String ticketTopic;


    @Bean
    public RedisMessageListenerContainer listenerContainer(MessageListenerAdapter listenerAdapter,
                                                           RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(ticketTopic));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisMessageConsumer consumer) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
        messageListenerAdapter.setSerializer(new Jackson2JsonRedisSerializer<>(objectMapper, Object.class));
        return messageListenerAdapter;
    }


}
