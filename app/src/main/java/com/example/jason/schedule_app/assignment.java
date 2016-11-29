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
import java.util.Date;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Created by jason on 11/2/2016.
 */



public class assignment extends AppCompatActivity {
    //needs edits
    EditText pointUser;
    EditText className;
    EditText assignmentType;
    EditText assignmentName;
    EditText dueDate;
    EditText estTime;
    //

    double pointValue;
    boolean isList;
    String pointsWorth;
    String assignNames;
    String assignTypes;
    String classNames;
    int points;
    String date;


    private static final String TAG = assignment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_assignment);

        //needs edits
        pointUser = (EditText) findViewById(R.id.pointsString);
        className = (EditText) findViewById(R.id.className);
        assignmentType = (EditText) findViewById(R.id.assignType);
        assignmentName = (EditText) findViewById(R.id.assignName);
        dueDate = (EditText) findViewById(R.id.dueDate);
        estTime = (EditText) findViewById(R.id.estTime);
        //

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

                Intent myIntent = new Intent(getApplicationContext(), listActivity.class);
                //needs edits
                myIntent.putExtra("points", pointUser.getText().toString());
                myIntent.putExtra("className", className.getText().toString());
                myIntent.putExtra("assignmentType", assignmentType.getText().toString());
                myIntent.putExtra("assignName", assignmentName.getText().toString());
                myIntent.putExtra("dueDate", dueDate.getText().toString());
                myIntent.putExtra("estTime", estTime.getText().toString());
                //
                startActivity(myIntent);
            }
        });

    }

    //constructor
    assignment () {

        assignNames= "Assignment Name";
        assignTypes= "Assignment Type";
        points= 1;
        date = "Assignment Date";
    }

    //constructor
    //FYI this isn't a constructor. It's just a function. Do you need a constructor? Java will create one when you're lacking one. -Tiffany
    //Is this suppose to be a copy constructor?
    void assignmentVar(double pointValue, boolean isList) {
        //log tag 1
        Log.d(TAG, "Assignment Constructor");

        this.pointValue = pointValue;
        this.isList = isList;
    }

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
    //2. compare priorities of assignment type and date
    //3. edit/delete assignment in queue
    //4. save queue

    //tiffany add
    //this puts the assignment information into the Queue
    Queue<AssignmentQueue> CreateQueue(String dueDate, String assignName, String assignType) {


        Queue<AssignmentQueue> items = new PriorityQueue<AssignmentQueue>();

        //need an if statement here
        //if assignemnt then add to queue

        //dummy item to add
        //need if else statement saying if variables !=0 then add else return "No Assignments"
        //check if null

        //needs edits
        date = dueDate;
        assignNames = assignName;
        assignTypes = assignType;
        //


        if (points==1) {
            items.add(new AssignmentQueue("November 15, 2016", "Essay", "Ponder", 900));
            items.add(new AssignmentQueue("November 15, 2016", "Essay", "Ponder", 900));
            items.add(new AssignmentQueue("November 15, 2016", "Essay", "Ponder", 200));
            items.add(new AssignmentQueue("November 15, 2016", "Essay", "Ponder", 700));
            //needs edits
            items.add(new AssignmentQueue(date, assignNames, assignTypes, 500));
        }
        else
        {items.add(new AssignmentQueue("","No Assignments Here", "", 0));}

        //error log
        Log.v(TAG, "Error passing value");
        return items;

    }
}
