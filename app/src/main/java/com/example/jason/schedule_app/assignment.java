package com.example.jason.schedule_app;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashSet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jason on 11/2/2016.
 */



public class assignment extends AppCompatActivity {
    EditText classNames;
    EditText assignNames;
    EditText assignTypes;
    EditText pointsString;
    EditText dueDates;
    EditText dueTimes;

    private static final int PREFERENCE_MODE_PRIVATE = 0;
    private static final String MY_UNIQUE_PREFERENCE_FILE = "MyUniquePreferenceFile";
    private SharedPreferences preferenceSettingsUnique;
    private SharedPreferences.Editor preferenceEditorUnique;

    Set<String> nullSet;
    Set<String> valueClass = new HashSet<>();
    Set<String> valueAssign = new HashSet<>();
    Set<String> valueType = new HashSet<>();
    Set<String> valuePoint = new HashSet<>();
    Set<String> valueDates = new HashSet<>();
    Set<String> valueTime = new HashSet<>();


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



        //pointUser = (EditText) findViewById(R.id.pointsString);
        //pointsWorth = pointUser.getText().toString();
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
                Date2 = (EditText) findViewById(R.id.dueDate); //type
                Date3 = (EditText) findViewById(R.id.assignType);

                String text =  Date2.getText().toString();
                String pp =  Date2.getText().toString();
                int dateP =0;
                int typeP =0;

                //get date
                DueDate date = new DueDate();
                dateP= date.getDatePriority(text);

                //get types
                typeP=getType(pp);

                //set priority
                priority =0;



                //this sets priority
                priority=setPrority(dateP,typeP);


                //this converts it to a string
                String strI = Integer.toString(priority);

                saveVar();
                //change activitys
                Intent myIntent = new Intent(assignment.this, listActivity.class);
               // myIntent.putExtra("name", "Over all prority" + strI + " " + text);
                startActivity(myIntent);
            }
        });

    }

    //constructor


    public void saveVar() {
        preferenceSettingsUnique = getSharedPreferences(MY_UNIQUE_PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);
        preferenceEditorUnique = preferenceSettingsUnique.edit();
        Set<String> var1 = preferenceSettingsUnique.getStringSet("classNames", nullSet);
        Set<String> var2 = preferenceSettingsUnique.getStringSet("assignNames", nullSet);
        Set<String> var3 = preferenceSettingsUnique.getStringSet("assignTypes", nullSet);
        Set<String> var4 = preferenceSettingsUnique.getStringSet("pointsString", nullSet);
        Set<String> var5 = preferenceSettingsUnique.getStringSet("dueDates", nullSet);
        Set<String> var6 = preferenceSettingsUnique.getStringSet("dueTimes", nullSet);
        valueClass = var1;
        valueAssign = var2;
        valueType = var3;
        valuePoint = var4;
        valueDates = var5;
        valueTime = var6;

        classNames = (EditText) findViewById(R.id.className);
        assignNames = (EditText) findViewById(R.id.assignName);
        assignTypes = (EditText) findViewById(R.id.assignType);
        pointsString = (EditText) findViewById(R.id.pointString);
        dueDates = (EditText) findViewById(R.id.dueDate);
        dueTimes = (EditText) findViewById(R.id.dueTime);

        valueClass.add(classNames.getText().toString());
        valueAssign.add(assignNames.getText().toString());
        valueType.add(assignTypes.getText().toString());
        valuePoint.add(pointsString.getText().toString());
        valueDates.add(dueDates.getText().toString());
        valueTime.add(dueTimes.getText().toString());


        preferenceEditorUnique.putStringSet("classNames", valueClass);
        preferenceEditorUnique.putStringSet("assignNames", valueAssign);
        preferenceEditorUnique.putStringSet("assignTypes", valueType);
        preferenceEditorUnique.putStringSet("pointsString", valuePoint);
        preferenceEditorUnique.putStringSet("dueDates", valueDates);
        preferenceEditorUnique.putStringSet("dueTimes", valueTime);
        preferenceEditorUnique.commit();
    }

    /*public String getVar() {
        preferenceSettingsUnique = getSharedPreferences(MY_UNIQUE_PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);
        String value = preferenceSettingsUnique.getString("test", "null");

        return value;
    }*/


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
        int typePoints=0;
        if (ponder=="Ponder")
        {typePoints=1;}
        if (ponder=="Prove")
        {typePoints=3;}
        if (ponder=="Teach")
        {typePoints=2; }
        return typePoints;

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