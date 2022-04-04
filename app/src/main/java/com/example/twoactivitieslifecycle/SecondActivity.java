package com.example.twoactivitieslifecycle;
//import require library
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * SecondActivity defines the second activity in the app. It is launched
 * from an intent with a message, and sends an intent back with a second
 * message.
 */
public class SecondActivity extends AppCompatActivity {

    // Class name for Log tag.
    private static final String LOG_TAG
            = SecondActivity.class.getSimpleName();
    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    // EditText for the reply.
    private EditText mReply;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize view variables.
        mReply = findViewById(R.id.editText_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Put that message into the text_message TextView.
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    /**
     * Handles the onClick for the "Reply" button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to
     * the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void returnReply(View view) {
        // Get the reply message from the edit text.
        String reply = mReply.getText().toString();

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }

    /**
     * An interruptive event occurs,
     * the activity enters the Paused state, and the system invokes the onPause() callback.
     */
    @Override
    protected void onPause() {
        //super reference variable that is used to refer parent class objects
        super.onPause();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onPause");
    }

    /**
     * Called after your activity has been stopped, prior to it being started again.
     * Always followed by onStart()
     */
    @Override
    protected void onRestart() {
        //super reference variable that is used to refer parent class objects
        super.onRestart();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onRestart");
    }

    /**
     * activity enters the Resumed state, it comes to the foreground,
     * and then the system invokes the onResume() callback
     */
    @Override
    protected void onResume() {
        //super reference variable that is used to refer parent class objects
        super.onResume();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onResume");
    }

    /**
     * activity is no longer visible to the user, it has entered the Stopped state,
     * and the system invokes the onStop() callback
     */
    @Override
    protected void onStop() {
        //super reference variable that is used to refer parent class objects
        super.onStop();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onStop");
    }

    /**
     * onDestroy() is called before the activity is destroyed
     */
    @Override
    protected void onDestroy() {
        //super reference variable that is used to refer parent class objects
        super.onDestroy();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onDestroy");
    }
}