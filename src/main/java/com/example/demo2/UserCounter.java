package com.example.demo2;



import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


@Named
@ApplicationScoped
public class UserCounter {

    private int userCount = 0;

    public void incrementUserCount() {
        userCount++;
    }

    public int getUserCount() {
        return userCount;
    }

    public void decrementUserCount() {
        userCount--;
    }

}