package com.example.jason.schedule_app;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * Created by jason on 11/2/2016.
 */

public class assignment {
    private double pointValue;
    private boolean isList;

    public double getPointValue(int valueOne, int valueTwo) {
        int one = valueOne;
        int two = valueTwo;

        pointValue = (one * 0.3) + (two * 0.2);

        return pointValue;
    }

    public boolean viewType(boolean list) {
        isList = list;

        return isList;
    }

    //tiffany add
    //this puts the assignment information into the Queue
    void CreateQueue ()
    {
        Queue<AssignmentQueue> items = new PriorityQueue<AssignmentQueue>();

        //need an if statement here
        //if assignemnt then add to queue

        //dummy item to add 
        items.add(new AssignmentQueue("Novermber 15, 2016", 900, "Essay", "Ponder"));
    }
}
