package com.example.jason.schedule_app;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Created by jason on 11/2/2016.
 */



public class assignment extends AppCompatActivity {
    EditText pointUser;
    double pointValue;
    boolean isList;
    String pointsWorth;
    String assignName;
    String assignType;
    String className;
    int points;
    String date;

    private EditText Name, Date, Date1, Date2, Date3, Date4, Date5;
int priority;


    private static final String TAG = assignment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);



        pointUser = (EditText) findViewById(R.id.pointsString);
        pointsWorth = pointUser.getText().toString();
        //points = Integer.parseInt(pointsWorth);

        Button cancel_action = (Button) findViewById(R.id.cancel_action);
        Button submit = (Button) findViewById(R.id.submit);

        cancel_action.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(assignment.this, MainActivity.class);
                startActivity(myIntent);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Name = (EditText) findViewById(R.id.pointsString) ; //this is a number
                Date = (EditText) findViewById(R.id.editText10) ; //this is classname
                Date1 = (EditText) findViewById(R.id.editText11) ; //assignment name
                Date2 = (EditText) findViewById(R.id.editText12) ; //type
                Date3 = (EditText) findViewById(R.id.editText14) ;
                Date4 = (EditText) findViewById(R.id.editText15) ;

                String type =  Date2 .getText().toString();

                String AssignmentDate=  Date1.getText().toString();


                int dateP =0;
                int typeP =0;

                //get date
                DueDate date = new DueDate();
                dateP= datePP( AssignmentDate);

                //get type
                //should be type but won't work?
               typeP=getType(type);

                //set priority
               priority =0;
               priority=setPrority(dateP,typeP);

                //save to shared preferences
                String strI = Integer.toString(priority);
                //change activity
                Intent myIntent = new Intent(assignment.this, listActivity.class);
                myIntent.putExtra("name", "Over all prority" + strI + " " + dateP);
                startActivity(myIntent);
            }
        });

    }



    void assignmentVar(double pointValue, boolean isList) {
        //log tag 1
        Log.d(TAG, "Assignment Constructor");

        this.pointValue = pointValue;
        this.isList = isList;
    }

//
    public double getPointValue(int valueOne, int valueTwo) {
        int one = valueOne;
        int two = valueTwo;

        //log tag 2 add
        Log.d(TAG, "getPointValue to return a point value");

        pointValue = (one * 0.3) + (two * 0.2);

        return pointValue;
    }

    public boolean viewType(boolean isList) {
        return isList;
    }

    //need four functions
    //1. get assignment type priority
    int getType(String ponder)
    {
        String Ponder = "Ponder";
        String Prove = "Prove";
        String Teach = "Teach";
        int typePoints=0;
        if (ponder.equals(Ponder));
        {typePoints=1;}
        if (ponder.equals(Prove));
        {typePoints=3;}
        if (ponder.equals(Teach));
        {typePoints=2; }
        return typePoints;

    }

    int datePP( String assignmentDate) {
        int priorityDate = 0;
        String dateStart = assignmentDate;
        // String dateStop = "01/15/2015 11:31:48";

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

//HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            d2 = format.parse(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//in milliseconds
        int diff = (int) (d1.getTime() - d2.getTime());

        //   long diffSeconds = diff / 1000 % 60;
        //    long diffMinutes = diff / (60 * 1000) % 60;
        //  long diffHours = diff / (60 * 60 * 1000) % 24;
        int diffDays = diff / (24 * 60 * 60 * 1000);


        return diffDays;
    }

    //2. compare priorities of assignment type and date
    int setPrority(int type, int date)
    {
        int priority=0;

        priority=type+date;

        return priority;
    }
    //3. edit/delete assignment in com.example.jason.schedule_app.SAtest.queue
    //4. save com.example.jason.schedule_app.SAtest.queue

    //tiffany add
    //this puts the assignment information into the Queue

}
