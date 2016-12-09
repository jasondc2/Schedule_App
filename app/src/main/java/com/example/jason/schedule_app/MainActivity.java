package com.example.jason.schedule_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPreferencesFile";
    public String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences variables = getSharedPreferences(PREFS_NAME, 0);
        value = variables.getString("name", "homework");
        // Get the view from activity_main.xml

        // Locate the button in activity_main.xml
        Button listView = (Button) findViewById(R.id.buttonlist);
        //The +assignment button takes the user to the right screen - Jason
        Button addAssignment = (Button) findViewById(R.id.addAssignment);

        // Capture button clicks
        listView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this, listActivity.class);
                startActivity(myIntent);

            }
        });

        // Capture button clicks
        addAssignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent nextScreen = new Intent(MainActivity.this, assignment.class);
                startActivity(nextScreen);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}

