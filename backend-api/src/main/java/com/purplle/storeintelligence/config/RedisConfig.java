package com.purplle.storeintelligence.config;

import com.purplle.storeintelligence.service.RedisSubscriberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        
        // This MUST match the exact channel name Python is publishing to
        container.addMessageListener(listenerAdapter, new PatternTopic("security_alerts"));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisSubscriberService subscriber) {
        // Adapts our service class to function as a background listener thread
        return new MessageListenerAdapter(subscriber);
    }
}