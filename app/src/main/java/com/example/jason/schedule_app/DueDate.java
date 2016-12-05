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
}
//SABRINA BELL
