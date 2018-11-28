package com.mq.rabbit.quickstart;

import cn.hutool.core.lang.Console;
import com.mq.rabbit.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/28 10:09
 */
@Component
public class Consumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(String message) {
        Console.log("consume message {}", message);
    }

}