package com.xinpi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：RabbitMq
 * 类 描 述：TODO
 * 创建时间：2019-08-05 16:32
 * 创 建 人：renhao
 */
@Configuration
public class RabbitMq {
    private static final String EXCHANGE = "priority-exchange";

    public static final String QUEUE = "priority-queue";

    private static final String ROUTING_KEY = "priority.queue.#";

    /**
     * 定义优先级队列
     */
    @Bean
    Queue queue() {
        Map<String, Object> args= new HashMap<>();
        args.put("x-max-priority", 100);
        return new Queue(QUEUE, false, false, false, args);
    }

    /**
     * 定义交换器
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
