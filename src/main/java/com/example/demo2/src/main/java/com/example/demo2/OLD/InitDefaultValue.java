package com.example.demo2.OLD;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class InitDefaultValue {

    @Produces
    public int InitDefaultValue(){
        return 99;
    }
}
