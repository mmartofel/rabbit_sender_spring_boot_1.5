package com.example.rabbit_sender;

/**
 * Created by mmartofel on 10/15/18.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageSender
{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMessageSender.class);

    @Value("${spring.rabbitmq.template.exchange}")
    private String EXCHANGE;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String ROUTING_KEY;

    @Scheduled(fixedRate = 3000)
    public void produce()
    {
        String jsonMessage = "{abcd: 1}";
        LOGGER.info(" Publishing message : " + jsonMessage);
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY,jsonMessage);
    }
}
