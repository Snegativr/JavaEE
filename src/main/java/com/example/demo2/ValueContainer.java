package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

public class ValueContainer {
    private List<String> valuesList = new ArrayList<>();

    public List<String> getValuesList() {
        return valuesList;
    }

    public void addValues(String value) {
        valuesList.add(value);
    }

    public void remove(String value) {
        valuesList.remove(value);
    }
}
