package com.mq.rabbit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/11/28 10:11
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("rabbitmq.config")
public class RabbitMQConfig {

    private String queuename;
    private String exchangename;
    private String routingkey;

    public final static String QUEUE_NAME = "spring-boot-queue";
    public final static String EXCHANGE_NAME = "spring-boot-exchange";
    public final static String ROUTING_KEY = "spring-boot-key";

    // 创建队列
    @Bean
    public Queue queue() {
        System.out.println(queuename);
        return new Queue(QUEUE_NAME);
    }

    // 创建一个 topic 类型的交换器
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    /* 配置MQ地址和端口，并设置密码 也可在application.yml文件中配置*/
    // @Bean
    // public ConnectionFactory connectionFactory() {
    //     CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.1.119", 5672);
    //     connectionFactory.setUsername("guest");
    //     connectionFactory.setPassword("guest");
    //     connectionFactory.setVirtualHost("/");
    //     return connectionFactory;
    // }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
