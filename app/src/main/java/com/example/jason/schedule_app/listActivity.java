package com.example.jason.schedule_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
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

      //  TextView mTextView = (TextView) findViewById(R.id.textview1);

        Queue<AssignmentQueue> items = new PriorityQueue<AssignmentQueue>();

        //dummy item to add
      items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 900));
        items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 700));
        items.add(new AssignmentQueue("Novermber 15, 2016", "Essay", "Ponder", 100));

        ArrayList list = new ArrayList(items);

    ArrayAdapter adapter = new ArrayAdapter<String>(this,
        R.layout.activity_list_view,list);

    ListView listView = (ListView) findViewById(R.id.mobile_list);
    listView.setAdapter(adapter);
      //  mTextView.setText("test here");
    }
}
