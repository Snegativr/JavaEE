package com.example.demo2;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ValueController implements Serializable {
    private ValueContainer valueContainer = new ValueContainer();
    private String newValue;

    public ValueController() {
        valueContainer.addValues("Roman");
        valueContainer.addValues("Chechinev");
        valueContainer.addValues("Vector");
        valueContainer.addValues("Chair");
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public void addValue() {
        valueContainer.addValues(newValue);
        newValue = ""; // очищаємо поле після додавання
    }

    public void removeValue(String value) {
        valueContainer.remove(value);
    }

    public List<String> getValuesList() {
        return valueContainer.getValuesList();
    }
}
