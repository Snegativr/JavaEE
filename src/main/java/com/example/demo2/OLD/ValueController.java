package com.example.demo2.OLD;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ValueController implements Serializable {
    private ValueContainer valueContainer = new ValueContainer();
    private String newValue;
    private String deleteValue;

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
        newValue = "";
    }

    public void removeValue(String item) {
        valueContainer.remove(item);
    }
    public List<String> getValuesList() {
        return valueContainer.getValuesList();
    }
}
