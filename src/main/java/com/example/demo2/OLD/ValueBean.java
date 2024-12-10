package com.example.demo2.OLD;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class ValueBean implements Serializable {
    private String value = "Some random value";
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
