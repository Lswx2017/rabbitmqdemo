package com.jn.rabbitmqdemo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RabbitmqService {


    @RabbitListener(queues = "jn.desta")
    public void getNewMsg(Object obj) {
        System.out.println("收到信息的消息1");
        System.out.println(obj);
    }

    @RabbitListener(queues = "jn.destb")
    public void getOtherMsg(Object obj) {
        System.out.println("收到信息的消息2");
        System.out.println(obj);
    }
}
