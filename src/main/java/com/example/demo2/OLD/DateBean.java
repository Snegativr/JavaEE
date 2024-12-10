package com.example.demo2.OLD;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;


@Named
@RequestScoped
public class DateBean implements Serializable {
    private Date curDate;

    public DateBean() {
        this.curDate = new Date();
    }
    public Date getCurDate() {
        return curDate;
    }
}
