package com.example.demo2;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/execute")
public class TaskController {

    @EJB
    private ExecutorService executorService;

    @EJB
    private ScheduledExecutor scheduledExecutor;

    @GET
    @Path("/start-tasks")
    public String startTasks() {
        executorService.executeTasks();
        scheduledExecutor.scheduleTask();
        return "Tasks Started";
    }
}
