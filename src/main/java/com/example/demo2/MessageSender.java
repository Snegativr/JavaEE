package com.example.demo2;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Named
@RequestScoped
public class MessageSender {

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/TestQueue")
    private Queue queue;

    public void sendMessage(String message) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, message);
        }
    }
}