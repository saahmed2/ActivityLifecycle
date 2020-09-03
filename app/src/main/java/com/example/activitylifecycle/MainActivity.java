package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showGuess;
    private EditText enterGuessText;
    private final int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "onCreate called", Toast.LENGTH_SHORT).show();

        enterGuessText = findViewById(R.id.enter_guess_text);

        showGuess = findViewById(R.id.guess_button);
        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retrieve the guess text with the most minimal String (to remove all the junk)
                String guess = enterGuessText.getText().toString().trim();

                //if guess is not empty then proceed to show the name on the next screen
                if (!guess.isEmpty()) {
                    //changing activity passing all the data to the next screen
                    Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                    intent.putExtra("guess", guess);
                    //it's possible to assign multiple names
                    intent.putExtra("name", "Bond");
                    intent.putExtra("Sally", "Smith");
                    intent.putExtra("age", 34);
                    startActivityForResult(intent, REQUEST_CODE);
                    //startActivity(intent);
                    //another way to navigate through classes is this
                    //startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
                }
                // if the guess box is empty then return this notice so the user can try to input a name again
                //this will not take you to the next screen though
                else {
                    Toast.makeText(MainActivity.this, "Please enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy called", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            //the message String allows you to move between the main and secondary screen
            //therefore cannot be null
            assert data != null;
            String message = data.getStringExtra("message_back");

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }

}