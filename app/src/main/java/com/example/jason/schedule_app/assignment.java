package com.example.jason.schedule_app;

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
}
