package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/29 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQApplicationMainTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /* 单播，点对点模式 */
    @Test
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "第一条消息");
        map.put("data", Arrays.asList("abc", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct", "joker.news", map);
    }

    @Test
    public void receive() {
        Message receive = rabbitTemplate.receive("joker.news");
        System.out.println(receive.getMessageProperties());
        System.out.println(receive);
    }

}