package com.example.jason.schedule_app;

/**
 * Created by whi08_000 on 11/2/2016.
 */

public class AssignmentQueue {
   private
    String date;
    double time;
    String assignmentName;
    String assignmentType;

    //constructor
    public AssignmentQueue(String date, double time, String assignmentName, String assignmentType)
    {
       this.date = date;
        this.time = time;
        this.assignmentName=assignmentName;
        this.assignmentType=assignmentType;
    };




   public String getDate(){return date;}

    public  double getTime() {return time; }

    public  String getName(){return assignmentName; }

    public   String getType(){return assignmentType;}

  //  AssignmentQueue compareTo(AssignmentQueue i){return i; }

    //@Override
    public double compareTo(AssignmentQueue i) {
        if (this.date== i.date) {
            return this.assignmentName.compareTo(i.assignmentName);
        }

        return this.time - i.time;
    }

    @Override
    public String toString() {
        return String.format("%s: $%d", date, time);
    }



}
