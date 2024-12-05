package com.example.demo2;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MessageBean implements Serializable {

    private String message;
    private String lastMessage;

    @Inject
    private MessageSender messageSender;

    @Inject
    private MessageReceiver messageReceiver;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void sendMessage() {
        messageSender.sendMessage(message);
    }

    public void receiveMessage() {
        lastMessage = messageReceiver.receiveMessage();
    }
}