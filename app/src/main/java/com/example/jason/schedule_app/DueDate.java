package com.example.jason.schedule_app;
import android.util.Log;

import java.util.Calendar;
import java.util.Locale;

//for the assignments' due dates... can be used while putting them in the queue maybe?
public class DueDate {
    private Calendar dueDate;

    DueDate() {
        dueDate = Calendar.getInstance(Locale.US); //defaults on current day
    }

    public void setDate(int year, int month, int day, int hour, int minute, int AM_PM) {
        if (hour > 12){
            Log.e("DueDate", "Impossible time");
            //throw error?
        }
        if (AM_PM == Calendar.PM) {
            dueDate.set(year, month, day, hour + 12, minute);
            Log.i("dueDate", "actual time is" + hour);
            return;
        }
        dueDate.set(year, month, day, hour, minute);
    }

    public boolean isPM() {
        if(dueDate.get(Calendar.HOUR_OF_DAY) > 12){
            return true;
        }
        Log.i("dueDate", "AM");
        return false;
    }

    public Calendar getDueDate() {
        if((dueDate.get(Calendar.HOUR_OF_DAY) > 12) &&
                (dueDate.get(Calendar.AM_PM) == Calendar.PM)){ //weird bug
            dueDate.set(Calendar.HOUR_OF_DAY, dueDate.get(Calendar.HOUR_OF_DAY) - 12);
        }
        return dueDate;//might need work here
    }

    public int compareCurrentDate() {
        return dueDate.compareTo(Calendar.getInstance()); //compare to current day
        //+# means we still got time, -# means overdue

    }

    //compare dates to prioritize
    public int compareDate(Calendar date) {
        return dueDate.compareTo(date);
        //compare with another date
        //+# means first is bigger, -# means second is bigger, I think
    }

    public int getDatePriority(){
        int diff = compareCurrentDate();
        int priority;
        diff = diff * 1000 * 60; //minute
        diff = diff * 60; //hours
        if (diff <= 24){
            //1 day
            priority = 10;
            return priority;
        }
        else if (diff <= 48){
            //2 days
            priority = 9;
            return priority;
        }

        diff = diff * 24; //day
        if (diff <= 7){
            //1 week
            priority = 8;
        }
        else if (diff <= 14) {
            //2 weeks
            priority = 7;
        }
        else if (diff <= 21){
            //3 weeks
            priority = 6;
        }
        //average a month at 30
        else if (diff <= 30){
            //1 month
            priority = 5;
        }
        else if (diff <= 60){
            //2 months
            priority = 4;
        }
        else if (diff <= 90){
            //3 months
            priority = 3;
        }
        else if (diff <= 180){
            //6 months
            priority = 2;
        }
        else{
            priority = 1;
        }
        return priority;
    }
}
//SABRINA BELL
