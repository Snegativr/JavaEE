package com.example.demo2;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Singleton
@Startup
public class Timer {
    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void printTimer() {
        System.out.println("Message from timer");
    }
}
