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
    EditText pointUser;
    double pointValue;
    boolean isList;
    String pointsWorth;
    String assignName;
    String assignType;
    String className;
    int points;
    String date;



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
                pointUser = (EditText) findViewById(R.id.pointsString);
                pointsWorth = pointUser.getText().toString();
                //points = Integer.parseInt(pointsWorth);

                CreateQueue();

                Intent myIntent = new Intent(assignment.this, listActivity.class);
                startActivity(myIntent);
            }
        });

    }

    //constructor
    assignment () {

        assignName= "Assignment Name";
                assignType= "Assignment Type";
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

    //tiffany add
    //this puts the assignment information into the Queue
    Queue<AssignmentQueue> CreateQueue() {

        //int points = Integer.parseInt(pointsWorth);

        Queue<AssignmentQueue> items = new PriorityQueue<AssignmentQueue>();

        //need an if statement here
        //if assignemnt then add to queue

        //dummy item to add
        items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 900));
        items.add(new AssignmentQueue(date, assignName, assignType, points));

        //error log
        Log.v(TAG, "Error passing value");
        ArrayList list = new ArrayList(items);
        return items;

    }
}
