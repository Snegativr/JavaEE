package com.example.demo2;

import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Singleton
@Startup
public class ScheduledExecutor {

    @Resource
    private ManagedScheduledExecutorService scheduledExecutorService;

    public void scheduleTask() {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Executing Scheduled Task");
            performScheduledTask();
        },0, 10, TimeUnit.SECONDS);
    }

    private void performScheduledTask() {
        System.out.println("Scheduled Task Completed");
    }
}
