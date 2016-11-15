package com.example.jason.schedule_app;

import android.util.Log;

/**
 * Created by whi08_000 on 11/2/2016.
 */

public class AssignmentQueue {
    private static final String TAG = AssignmentQueue.class.getSimpleName();
   private
    String date;
    double time;
    String assignmentName;
    String assignmentType;

    //constructor
    public AssignmentQueue(String date, double time, String assignmentName, String assignmentType)
    {

           //log tag 1
            Log.d(TAG, "AssignmentQueue Constructor");


       this.date = date;
        this.time = time;
        this.assignmentName=assignmentName;
        this.assignmentType=assignmentType;
    };




   public String getDate(){
       //log tag 2 add
        Log.d(TAG, "getDate to return date");
       return date;}

    public  double getTime() {return time; }

    public  String getName(){return assignmentName; }

    public   String getType(){return assignmentType;}

  //  AssignmentQueue compareTo(AssignmentQueue i){return i; }

    //@Override
    public double compareTo(AssignmentQueue i) {

        if (this.date== i.date) {
            //error log
            Log.v(TAG, "date==" + i.date);
            return this.assignmentName.compareTo(i.assignmentName);
        }

        return this.time - i.time;
    }

    @Override
    public String toString() {
        return String.format("%s: $%d", date, time);
    }



}
