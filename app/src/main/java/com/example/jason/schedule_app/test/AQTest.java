package com.example.jason.schedule_app.test;


import android.test.InstrumentationTestCase;

import com.example.jason.schedule_app.AssignmentQueue;
import com.example.jason.schedule_app.DueDate;

import java.util.Calendar;

import static junit.framework.Assert.assertEquals;

/**
 * Created by whi08_000 on 11/2/2016.
 */

public class AQTest  extends InstrumentationTestCase {
    public void test1() throws Exception {
        AssignmentQueue aqtest = null;
        double expected = 3;
        double newOutput;
       newOutput= aqtest.compareTo(aqtest);
        assertEquals(expected,newOutput);
    }

    public void test2() throws Exception {
        AssignmentQueue aqtest =null;
        String newDate;
       String expected = "June";
       newDate= aqtest.getDate();
        assertEquals(expected, newDate);
    }

    public void testCompareDueDate() {
        DueDate date(1996, Calendar.OCTOBER, 16, 11, 00, Calendar.AM); //year, month, day, hour, minute //include calendar
        DueDate due(1996, Calendar.OCTOBER, 16, 11, 00, Calendar.AM);
        assert(date.compareDate(due) == 0); //first see which year is bigger... then month (in method)
        //use compareTO...a calendar method
        //returns milliseconds, so multiply by a 1000 for seconds
        //*60 for minutes
        //*60 for hours
        //*24 for days
        //it will also round to the whole day... (int)

        date.setDate(1864, Calendar.AUGUST, 12, 10, 30, Calendar.PM);
        due.setDate(1864, Calendar.AUGUST, 11, 10, 30, Calendar.PM);
        assert(date.compareDate(due) == -1);

        date.setDate(2012, Calendar.JANUARY, 01, 02, 15, Calendar.AM);
        due.setDate(2012, Calendar.JANUARY, 02, 02, 30, Calendar.AM);
        assert(date.compareDate(due) == 1);

        date.setDate(2016, Calendar.OCTOBER, 31, 12, 00, Calendar.PM);
        due.setDate(2017, Calendar.OCTOBER, 31, 12, 00, Calendar.PM);
        assert(date.compareDate(due) == 365);
    }

    public void testGetDueDate() {
        DueDate date(1234, Calendar.MAY, 06, 07, 08, Calendar.AM);
        assert(date.getDueDate().equals(date));

        date.setDate(1984, Calendar.JULY, 12, 8, 45, Calendar.PM);
        assert(date.getDueDate().equals(date));
    }



}
