package com.example.jason.schedule_app.test;

import android.test.InstrumentationTestCase;

import com.example.jason.schedule_app.assignment;

import static junit.framework.Assert.assertEquals;


/**
 * Created by jason on 11/2/2016.
 */

public class AssignTest extends InstrumentationTestCase {

    assignment assign;

    public void checkPointType() throws Exception {
        assert(assign.getPointValue(7, 8) == 3.8);
        assert(assign.getPointValue(4, 10) == 3.2);
    }

    public void checkViewType() throws Exception {
        assert(assign.viewType(true) == true);
        assert(assign.viewType(false) == false);
    }
}
