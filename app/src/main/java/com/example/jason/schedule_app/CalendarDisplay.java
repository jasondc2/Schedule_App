package com.example.jason.schedule_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarDisplay extends AppCompatActivity {
    //initializes on current month,year
    //uses Tiffany's queue to load assignments that are in this month, year... so check for those
    TextView Month;
    Calendar calendar;
    Button prevMonth;
    Button nextMonth;

    View weekOne;
    View weekTwo;
    View weekThree;
    View weekFour;
    View weekFive;
    View weekSix;

    TextView Sunday;
    TextView Monday;
    TextView Tuesday;
    TextView Wednesday;
    TextView Thursday;
    TextView Friday;
    TextView Saturday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Month = (TextView) findViewById(R.id.Month);//initially says 'Month'
        calendar = Calendar.getInstance(); //current date... from here we will set up the month
        prevMonth = (Button) findViewById(R.id.prevMonth);
        nextMonth = (Button) findViewById(R.id.nextMonth);

        weekOne = findViewById(R.id.week1);
        weekTwo = findViewById(R.id.week2);
        weekThree = findViewById(R.id.week3);
        weekFour = findViewById(R.id.week4);
        weekFive = findViewById(R.id.week5);
        weekSix = findViewById(R.id.week6);


    }

    //displays month name
    public void setMonthHeader(){
        String month = new SimpleDateFormat("MMMM", Locale.US).format(calendar);
        Month.setText(month);
        //ought to get the month of our calendar. :)
    }

    //right now this is just displaying the month... add the colorDate function to put priorities in
    public void setDisplay(){
        calendar.set(Calendar.DATE, 1);
        String currentDay = new SimpleDateFormat("EEEE", Locale.US).format(calendar);//first day of the month

        int week = 1; //which week row we are on
        int dayNum = 1; //the date in number form

        View tempWeek; //lets us assign one week at a time

        while (week < 7 && dayNum != calendar.getActualMaximum(Calendar.DATE)) {//last day of month?

            if (week == 1) {
                tempWeek = weekOne;
            } else if (week == 2) {
                tempWeek = weekTwo;
            } else if (week == 3) {
                tempWeek = weekThree;
            } else if (week == 4) {
                tempWeek = weekFour;
            } else if (week == 5) {
                tempWeek = weekFive;
            } else if (week == 6) {
                tempWeek = weekSix;
            } else {
                return;
                //error
            }

            if (tempWeek == null){
                return;
                //ERROR!!!!
            }

            Sunday = (TextView) tempWeek.findViewById(R.id.Sunday);
            Monday = (TextView) tempWeek.findViewById((R.id.Monday));
            Tuesday = (TextView) tempWeek.findViewById(R.id.Tuesday);
            Wednesday = (TextView) tempWeek.findViewById(R.id.Wednesday);
            Thursday = (TextView) tempWeek.findViewById(R.id.Thursday);
            Friday = (TextView) tempWeek.findViewById(R.id.Friday);
            Saturday = (TextView) tempWeek.findViewById(R.id.Saturday);

            //start with first day
            TextView day = null;
            int dayOfWeek = 0; //Which day? ex: Sunday, Monday... //might be an error
            switch (currentDay) {
                case "Sunday":
                    day = Sunday;
                    dayOfWeek = 1;
                    break;
                case "Monday":
                    day = Monday;
                    dayOfWeek = 2;
                    break;
                case "Tuesday":
                    day = Tuesday;
                    dayOfWeek = 3;
                    break;
                case "Wednesday":
                    day = Wednesday;
                    dayOfWeek = 4;
                    break;
                case "Thursday":
                    day = Thursday;
                    dayOfWeek = 5;
                    break;
                case "Friday":
                    day = Friday;
                    dayOfWeek = 6;
                    break;
                case "Saturday":
                    day = Saturday;
                    dayOfWeek = 7;
                    break;
                default:
                    //ERROR!
                    break;
            }

            //day.setText(Integer.toString(dayNum));
            try {
                day.setText(String.format(Locale.US, "%1$02d", dayNum));
            }
            catch(NullPointerException ex){
                //HMM
                ex.printStackTrace();
            }
            dayNum++;
            dayOfWeek++;
            if (dayOfWeek == 7){
                week++;
            }
        }
    }

    //view next or previous month
    public void setMonth(int num){
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, num);
        //first of the next month or previous month
    }

    public void colorDate(){}//color each date according to highest priority assignment



    //2 buttons... <- and ->    on their clicks, switch months... switch months
}
