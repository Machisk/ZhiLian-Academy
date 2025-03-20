package com.zhilian.rabbitmq.plugins;

import com.zhilian.rabbitmq.client.RabbitClient;
import com.zhilian.rabbitmq.domain.ErrorRabbitMqMessage;
import com.zhilian.rabbitmq.properties.RabbitmqProperties;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;


public class ErrorMessageRecoverer implements MessageRecoverer {

    private RabbitClient rabbitClient;
    private RabbitmqProperties rabbitmqProperties;


    public ErrorMessageRecoverer(RabbitClient rabbitClient, RabbitmqProperties rabbitmqProperties) {
        this.rabbitClient = rabbitClient;
        this.rabbitmqProperties = rabbitmqProperties;
    }

    @Override
    public void recover(Message message, Throwable cause) {

        // 指定routingKey的消息才能进入队列
        if(rabbitmqProperties.getError().getWhiteList().contains(message.getMessageProperties().getReceivedRoutingKey())) {
            ErrorRabbitMqMessage errorRabbitMqMessage = new ErrorRabbitMqMessage();
            errorRabbitMqMessage.setOriginRoutingKey(message.getMessageProperties().getReceivedRoutingKey());
            errorRabbitMqMessage.setOriginExchange(message.getMessageProperties().getReceivedExchange());
            errorRabbitMqMessage.setMessage(new String(message.getBody()));
            rabbitClient.sendMsg(rabbitmqProperties.getError().getExchange(), rabbitmqProperties.getError().getRoutingKey(), errorRabbitMqMessage);
        }
    }

}
