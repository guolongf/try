package com.baidu.redisConfig;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;


public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("--------队列监听------------"+new String(message.getBody()));
    }
}
