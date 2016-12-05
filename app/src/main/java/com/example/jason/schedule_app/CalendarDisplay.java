package com.example.jason.schedule_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

public class CalendarDisplay extends AppCompatActivity {
    //initializes on current month,year
    //uses Tiffany's queue to load assignments that are in this month, year... so check for those
    //put them in an array
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

    boolean reset; //are we resetting the view?
    Queue<assignment> AssignmentList;
    List<List<assignment>> AssignmentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = getIntent();
        AssignmentList = (PriorityQueue<assignment>)intent.getSerializableExtra("AssignmentQueue");
        //now we have all of the assignments
        AssignmentDay = new ArrayList<>();
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DATE); i++){
            //make each AssignmentDay array a mini arraylist...
            ArrayList temp = new ArrayList();
            AssignmentDay.add(temp);//of type assignmentMain //should be uppercase
            //if MONTH CHANGES, CLEAR EACH sublist's assignments
            //we've added each day's lists... now we can add the assignments in each day by going
            //to AssignmentDay
        }

        Month = (TextView) findViewById(R.id.Month);//initially says 'Month'
        calendar = Calendar.getInstance(); //current date... from here we will set up the month


        prevMonth = (Button) findViewById(R.id.prevMonth);
        nextMonth = (Button) findViewById(R.id.nextMonth);

        prevMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth(-1);
                setMonthHeader();
                resetDisplay();//make sure we don't have old data
                setDisplay();
            }
        });

        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth(1);
                setMonthHeader();
                resetDisplay();
                setDisplay();
            }
        });

        weekOne = findViewById(R.id.week1);
        weekTwo = findViewById(R.id.week2);
        weekThree = findViewById(R.id.week3);
        weekFour = findViewById(R.id.week4);
        weekFive = findViewById(R.id.week5);
        weekSix = findViewById(R.id.week6);

    }

    //view next or previous month
    public void setMonth(int num){
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, num);
        //first of the next month or previous month
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
        String currentDay = new SimpleDateFormat("EEEE", Locale.US).format(calendar);//1st day of mo

        int week = 1; //which week row we are on
        int dayNum = 1; //the date in number form

        View tempWeek; //lets us assign one week at a time

        while (week < 7 && dayNum != calendar.getActualMaximum(Calendar.DATE)) {//last day of month

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

            try {
                if (reset){
                    day.setText(" ");
                }
                else {
                    day.setText(String.format(Locale.US, "%1$d", dayNum));//00d?
                    List tempAssign = new ArrayList();
                    //AssignmentDay.add(dayNum, tempListof assigns )
                    //set color
                    //priority queue stuff // put in any dates
                    //AssignmentList
                }
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

    public void resetDisplay(){
        reset = true;
        setDisplay();
        AssignmentList.clear();
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DATE); i++){
            ArrayList temp = new ArrayList();
            AssignmentDay.add(temp); //reset the array for the new month
        }
        reset = false;
    }

    public void colorDate(){}//color each date according to highest priority assignmentMain

    //What's the score range???

    //having clicked a date
    public void onClick(View v){
        //open popup
        PopupWindow popUpWindow = new PopupWindow(this);
        //it's a scrollable list screen
        //WORK HERE
        //view assignments from least to most important
        //edit button next to each?
        //complete buton next to each
        //if complete, delete.
        //
    }

    //for int i = 0; i < Calendar.maxMonth...; i++
    //Date =assignmentlist.get(i).getDate?
    //if date.month == the month we need
    //and date.year == the year we need
    //add to date.day's list
    //continue through list

    //WHEN WE GO TO OTHER PAGES, SHARE THE ARRAY AND MAKE NECESSARY CHANGES (DELETE... or if edited, it
    //will delete and add)

    //MENU BUTTON
    //Intent intent = new intent();
    //intent.putExtra("AssignmentList", assignmentList);
    //if add, go to addassign
    //if listview, go to listview
    //intent.putExtra(flag, C)//from Calendar maybe

    //MAKE PRIORITY QUEUE SERIALIZABLE!!!!!!!!
}
//SABRINA BELL
