package com.xinpi.rabbit;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 类 名 称：FileMessageSender
 * 类 描 述：发送消息
 * 创建时间：2019-08-05 16:35
 * 创 建 人：renhao
 */
@Component
@AllArgsConstructor
public class FileMessageSender {
    private static final String EXCHANGE = "priority-exchange";

    private static final String ROUTING_KEY_PREFIX = "priority.queue.";

    private final RabbitTemplate rabbitTemplate;

    /**
     * 发送设置有优先级的消息
     *
     * @param priority 优先级
     */
    public void sendPriorityMessage(String content, Integer priority) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX + "test", content,
                message -> {
                    message.getMessageProperties().setPriority(priority);
                    return message;
                });
    }
}
