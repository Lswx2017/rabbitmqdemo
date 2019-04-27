package com.jn.rabbitmqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqdemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("key", "键值");
        map.put("key2", "键值2");

        rabbitTemplate.convertAndSend("jn.fanout", "#.desta", map);



    }

    @Test
    public void getMsg() {
        Object o = rabbitTemplate.receiveAndConvert("jn.desta");
        System.out.println(o);
    }

}
