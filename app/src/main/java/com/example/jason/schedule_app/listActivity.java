package com.example.jason.schedule_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class listActivity extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

          Queue<AssignmentQueue> items = new PriorityQueue<AssignmentQueue>();

        Button addAssignment = (Button) findViewById(R.id.assignment);

        // Capture button clicks
        addAssignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent nextScreen = new Intent(listActivity.this, assignment.class);
                startActivity(nextScreen);

            }
        });

        //dummy item to add
     // items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 900));
     //   items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 700));
     //  items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 100));

      //  ArrayList list = new ArrayList(items);

        assignment create = new assignment();
        items=create.CreateQueue();
        ArrayList list = new ArrayList(items);
    ArrayAdapter adapter = new ArrayAdapter<String>(this,
        R.layout.activity_list_view,list);

    ListView listView = (ListView) findViewById(R.id.mobile_list);
    listView.setAdapter(adapter);

    }
}
