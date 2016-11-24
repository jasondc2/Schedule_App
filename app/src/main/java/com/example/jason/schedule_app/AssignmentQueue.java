package com.example.jason.schedule_app;

import android.util.Log;

/**
 * Created by whi08_000 on 11/2/2016.
 */
//how to save the queue when program closes?

public class AssignmentQueue implements Comparable<AssignmentQueue> {
    private static final String TAG = AssignmentQueue.class.getSimpleName();

   private String date;
    private int time;
    private String assignmentName;
    private  String assignmentType;

    //constructor
    public AssignmentQueue(String assignmentType,String assignmentName, String date, int time) {
        this.date = date;
        this.time = time;
        this.assignmentName=assignmentName;
        this.assignmentType=assignmentType;
    }




    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public String getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignmentQueue other = (AssignmentQueue) obj;
        if ((this.date == null) ? (other.date != null) : !this.date.equals(other.date)) {
            return false;
        }
        if ((this.assignmentName == null) ? (other.assignmentName != null) : !this.assignmentName.equals(other.assignmentName)) {
            return false;
        }
        if ((this.assignmentType == null) ? (other.assignmentType != null) : !this.assignmentType.equals(other.assignmentType)) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.date != null ? this.date.hashCode() : 0);
        hash = 97 * hash + this.time;
        return hash;
    }

    @Override
    public int compareTo(AssignmentQueue i) {
        if ((this.time == i.time) ){
            return this.date.compareTo(i.date) ;
            // return (this.assignmentName.compareTo(i.assignmentName));
        }

        return this.time - i.time;
    }

    @Override
    public String toString() {
        return String.format("%s: %s: %s: $%d", assignmentName,assignmentType,date,time);
    }




}
