package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {

    private TextView showGuessTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //is a class that allows you to put many things inside of it
        // then all the things inside can be extracted as a method now one String at a time
        Bundle extra = getIntent().getExtras();
        showGuessTv = findViewById(R.id.guessed_name);

        if (extra != null) {
            showGuessTv.setText(extra.getString("guess"));
            //you can retrieve String, int, boolean etc from the bundle in the log
            Log.d("Name extra", "onCreate: " + extra.getString("name"));
            Log.d("Name extra", "onCreate: " + extra.getInt("age"));

        }

        showGuessTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "From Secondary Activity to MainActivity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        /*
        if (getIntent().getStringExtra("guess") != null) {
            //we can now check the debug option in the logcat under "stuff"
            //if the user entered anything in this statement
            Log.d("stuff", "onCreate: a name was successfully entered");
            //return the value inserted from the main activity
            //String value = getIntent().getStringExtra("guess");
            //showGuessTv.setText(value);
            //or it can be returned in one line
            showGuessTv.setText(getIntent().getStringExtra("guess"));
        }

         */

    }


}
