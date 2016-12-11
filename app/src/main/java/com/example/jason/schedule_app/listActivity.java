package com.example.jason.schedule_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
    private static final int PREFERENCE_MODE_PRIVATE = 0;
    private static final String MY_UNIQUE_PREFERENCE_FILE = "MyUniquePreferenceFile";
    private SharedPreferences preferenceSettingsUnique;
    private SharedPreferences.Editor preferenceEditorUnique;
    String value;
    TextView test;
    Set<String> nullSet = new HashSet<String>();
    //ArrayList<String> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        preferenceSettingsUnique = getSharedPreferences(MY_UNIQUE_PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);
        //Set<String> value = preferenceSettingsUnique.getStringSet("test", nullSet);
        Set<String> valueClass = preferenceSettingsUnique.getStringSet("classNames", nullSet);
        Set<String> valueAssign = preferenceSettingsUnique.getStringSet("assignNames", nullSet);
        Set<String> valueType = preferenceSettingsUnique.getStringSet("assignTypes", nullSet);
        Set<String> valuePoints = preferenceSettingsUnique.getStringSet("pointsString", nullSet);
        Set<String> valueDates = preferenceSettingsUnique.getStringSet("dueDates", nullSet);
        Set<String> valueTime = preferenceSettingsUnique.getStringSet("dueTimes", nullSet);


        Queue<SAtest.Item> items = new PriorityQueue<>();
        //test = (TextView)findViewById(R.id.textView3);
        //test.setText(value);


        Button addAssignment = (Button) findViewById(R.id.assignment);
        Button viewCalendar = (Button) findViewById(R.id.buttonCalendar);
        //myTextView = (TextView) findViewById(R.id.myTextView) ;
        //  getIntent().getSerializableExtra("Priority");
        Intent mIntent = getIntent();
        String name =  mIntent.getStringExtra("name");
        //myTextView.setText( name);

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
        items=create.createQueue(valueClass, valueAssign, valueType, valuePoints, valueDates, valueTime);
        ArrayList list = new ArrayList(items);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,
                        R.layout.activity_list_view, list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);
                if(position == 0 || position == 1  )
                {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("red"));
                }
                else  if(position == 2|| position == 3  )
                {view.setBackgroundColor(Color.parseColor("yellow"));}
                else
                {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.parseColor("green"));
                }
                return view;
            }
        };
        ListView listView = (ListView) findViewById(R.id.mobile_list);

        listView.setAdapter(adapter);
    }
}
