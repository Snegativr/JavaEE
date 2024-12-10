package com.example.demo2;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class UserListener implements HttpSessionListener {

    @Inject
    private UserCounter userCounter;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        userCounter.incrementUserCount();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        userCounter.decrementUserCount();
    }
}
