package com.example.twoactivitieslifecycle;
//import required library
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//MainActivity extends the property of AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE= "com.example.android.twoactivities.extra.MESSAGE";
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    // EditText view for the message
    private EditText mMessageEditText;
    // TextView for the reply header
    private TextView mReplyHeadTextView;
    // TextView for the reply body
    private TextView mReplyTextView;

    /**
     * the activity enters the Started state, the system invokes this callback
     *  onStart() call makes the activity visible to the user
     */
    @Override
    protected void onStart() {
        //super reference variable that is used to refer parent class objects
        super.onStart();
        //print in logcat if the function is called
        Log.d(LOG_TAG, "onStart");
    }

    /**
     * Maintains the Activity state across configuration changes.
     * invoked when the activity may be temporarily destroyed, save the instance state here
     * @param outState Activity state data to save
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //super reference variable that is used to refer parent class objects
        super.onSaveInstanceState(outState);
        //if reply msg is get from second page then textview will visible
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyTextView.getText().toString());
        }
    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super reference variable that is used to refer parent class objects
        super.onCreate(savedInstanceState);
        //take content from activity main xml
        setContentView(R.layout.activity_main);

        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        // Restore the state.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState
                    .getBoolean("reply_visible");
            if (isVisible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState
                        .getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Handles the onClick for the "Send" button. Gets the value of the main
     * EditText, creates an intent, and launches the second activity with
     * that intent.
     *
     * The return intent from the second activity is onActivityResult().
     *
     * @param view The view (Button) that was clicked.
     */
    public void launchSecondActivity(View view) {
        //button click
        Log.d(LOG_TAG, "Button clicked!");
        //object intent
        Intent intent = new Intent(this, SecondActivity.class);
        //message
        String message = mMessageEditText.getText().toString();
        //set extra_message to message variable
        intent.putExtra(EXTRA_MESSAGE, message);
        //locate to another page
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * Handles the data in the return intent from SecondActivity.
     *
     * @param requestCode Code for the SecondActivity request.
     * @param resultCode Code that comes back from SecondActivity.
     * @param data Intent data sent back from SecondActivity.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                // Make the reply head visible.
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                // Set the reply and make it visible.
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
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