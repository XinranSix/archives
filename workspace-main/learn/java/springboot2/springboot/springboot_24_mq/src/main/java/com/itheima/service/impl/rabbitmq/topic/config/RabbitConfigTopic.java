package com.itheima.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigTopic {

    @Bean
    public Queue topicQueue() {
        return new Queue("direct_queue");
    }

    @Bean
    public DirectExchange topicExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.order.id");
    }
}
