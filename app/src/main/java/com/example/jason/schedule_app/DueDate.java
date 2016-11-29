package com.example.jason.schedule_app;

import java.util.Calendar;

/**
 * Created by Sabrina on 11/2/16.
 */

public class DueDate {
    Calendar dueDate;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int AM_PM;

    DueDate() {

    }

    public void setDate(int year, int month, int day, int hour, int minute, int AM_PM) {
        if (AM_PM == Calendar.PM) {
            dueDate.set(year, month, day, hour + 12, minute);
            return;
        }
        dueDate.set(year, month, day, hour, minute);
        return;
    }

    public void getDueDate() {
        if(dueDate.get(Calendar.HOUR_OF_DAY) > 12){
            return ;
        }
    }

    public int compareCurrentDate() {
        //compare with current date
        return 0;
    }

    //compare dates to prioritize
    public int compareDate(DueDate date) {
        //compare with another date
        return 0;
    }
}

