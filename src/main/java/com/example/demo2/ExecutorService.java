package com.example.demo2;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;

@Stateless
public class ExecutorService {

    @Resource
    private ManagedExecutorService executorService;

    public void executeTasks() {
        executorService.submit(() -> {
            System.out.println("Executing Task 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 1 Completed");
        });

        executorService.submit(() -> {
            System.out.println("Executing Task 2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task 2 Completed");
        });
    }
}
