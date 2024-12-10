package com.example.demo2.OLD;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CalculationBean implements Serializable {

    private int value;
    private int input;
    @Inject
    public CalculationBean(int defualtValue) {
        this.value = defualtValue;
    }

    public void add() {
        this.value += input;
    }

    public void subtract() {
        this.value -= input;
    }

    public void multiply() {
        this.value *= input;
    }

    public void divide() {
        if (input != 0) {
            this.value /= input;
        }
    }
    public int getValue() {
        return value;
    }
    public int getInput() {
        return input;
    }
    public void setInput(int input) {
        this.input = input;
    }
}