package com.example.bootmq.bootmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Description： TODO
 * <p>
 * Author: miangong
 * <p>
 * Date: Created in 2020/12/25 13:40
 */
@Component
public class ProductMq {

    @Autowired
    private RocketMQTemplate t;

    public void send() {
        //发送消息
        t.convertAndSend("Topic1:TagA", "Hello world! ");
        t.convertAndSend("Topic:TagA","hello");

        //发送spring的Message
        t.send("Topic1:TagA", MessageBuilder.withPayload("Hello world! ").build());
        t.send("Topic:TagA",MessageBuilder.withPayload("Hello word").build());
        //发送异步消息
        t.asyncSend("Topic1:TagA", "Hello world!", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });
        t.asyncSend("Topic:TagA", "helloworld", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });

        //发送顺序消息
        t.syncSendOrderly("Topic1", "98456237,创建", "98456237");
        t.syncSendOrderly("Topic1", "98456237,支付", "98456237");
        t.syncSendOrderly("Topic1", "98456237,完成", "98456237");
    }
}
