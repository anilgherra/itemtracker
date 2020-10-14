package com.item.tracker.impl.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(MessageConsumerServiceImpl .class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "test-queue")
    public void listener(String message){
        //Object obj = jmsTemplate.receiveAndConvert(message);
        logger.info("Message received {} ", message);
    }
}
