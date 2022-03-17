package com.example.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * SecondActivity defines the second activity in the app. It is launched
 * from an intent with a message, and sends an intent back with a second
 * message.
 */
public class SecondActivity extends AppCompatActivity {
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE = "MainActivity.extra.MESSAGE";

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     * Activities have the ability,to restore themselves to a previous state using the data stored in this bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super keyword is used to refer parent class object
        super.onCreate(savedInstanceState);
        //it set the XML file as your main layout when the app starts
        setContentView(R.layout.activity_second);
    }

    /**
     *  @param view The view (Button) that was clicked.
     *  The TwoActivities app contains two activities and sends messages
     *  (intents) between them.
     */
    public void addItem (View view) {
        //creating object of Intent
        Intent replyIntent=new Intent();
        //get the text
        String message=((Button)view).getText().toString();
        //pass the value to extra_message
        replyIntent.putExtra(EXTRA_MESSAGE, message);
        //set the value to result_ok
        setResult(RESULT_OK,replyIntent);
        //the activity destroys and returns to the home screen
        finish();
    }
}