package com.example.jason.schedule_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class listActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    // Array of strings...
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
TextView  myTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Queue<SAtest.Item> items = new PriorityQueue<>();

        Button addAssignment = (Button) findViewById(R.id.assignment);
        Button viewCalendar = (Button) findViewById(R.id.buttonCalendar);
        myTextView = (TextView) findViewById(R.id. myTextView) ;
      //  getIntent().getSerializableExtra("Priority");
        Intent mIntent = getIntent();
        String name =  mIntent.getStringExtra("name");
        myTextView.setText( name);

        // Capture button clicks
        addAssignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent nextScreen = new Intent(listActivity.this, assignment.class);
                startActivity(nextScreen);

            }
        });

        // Capture button clicks
        viewCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent nextScreen = new Intent(listActivity.this, MainActivity.class);
                startActivity(nextScreen);

            }
        });



        SAtest create = new SAtest();
        items=create.createQueue();
        ArrayList list = new ArrayList(items);


    ArrayAdapter adapter = new ArrayAdapter<String>(this,
        R.layout.activity_list_view, list);

    ListView listView = (ListView) findViewById(R.id.mobile_list);
    listView.setAdapter(adapter);
        listView.setBackgroundColor(Color.parseColor("green"));
    }
}
