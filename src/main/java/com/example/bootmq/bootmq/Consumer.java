package com.example.bootmq.bootmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 * <p>
 * Author: miangong
 * <p>
 * Date: Created in 2020/12/25 13:57
 */
@Component
@RocketMQMessageListener(topic = "Topic", consumerGroup = "consumer-demo1")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("收到"+s);
    }
}
